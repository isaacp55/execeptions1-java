package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		System.out.println("Room number: ");
		int number = scn.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scn.next());
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scn.next());
		if(! checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
		    checkIn = sdf.parse(scn.next());
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scn.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Erro in reservation: Reservation dates for update must be future");
			}
			else if(! checkOut.after(checkIn)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updatesDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		
		scn.close();
	}
}
