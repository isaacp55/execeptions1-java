package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			System.out.println("Room number: ");
			int number = scn.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scn.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scn.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
		    checkIn = sdf.parse(scn.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scn.next());
			
			reservation.updatesDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e){
			System.out.println("Error in reservation: " + e.getMessage());
		}
			scn.close();
	}
	}