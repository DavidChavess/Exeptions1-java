package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("room number");
		int number = sc.nextInt(); 
		System.out.println("check in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("check out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if(!checkOut.after(checkIn)){
			System.out.println("error in reservation: check-out date must be after check-in date");
		}else{
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
			System.out.println("enter data to update the reservation: ");
			System.out.print("check in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			if(checkIn.before(now)||checkOut.before(now)){
				System.out.println("error in reservation: dates for updates must be future");
			}else if(!checkOut.after(checkIn)){
				System.out.println("error in reservation: check-out date must be after check-in date");
			}else{
				reservation.updatesDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation.toString());
			}			
		}
	}

}
