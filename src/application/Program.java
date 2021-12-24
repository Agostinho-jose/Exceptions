package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	    System.out.println("Room number: ");
	    int number = scan.nextInt();
	    System.out.println("Check-in date (dd/MM/yyyy): ");
	    Date checkIn = sdf.parse(scan.next());
	    System.out.println("Check-out date (dd/MM/yyyy): ");
	    Date checkOut = sdf.parse(scan.next());
	    
	    
//Testar se uma data é depois da outra com after
	    if(!checkOut.after(checkIn)) {
	    	System.out.println("Error in reservation");
	    } else {
	    	Reservation reservation = new Reservation(number, checkIn, checkOut );
	        System.out.println("Reservation: " + reservation);
	        System.out.println();
	        System.out.println("Enter data to update the reservation: ");
	        System.out.println("Check-in date (dd/MM/yyyy): ");
		    checkIn = sdf.parse(scan.next());
		    System.out.println("Check-out date (dd/MM/yyyy): ");
		    checkOut = sdf.parse(scan.next());
	        
//Validação: Date now(data de agora) se teste for antes de agora apresentar error
		    
		    String error =  reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Reservation: " + error); 
			} else {
				System.out.println("Reservation: " + reservation);
				  }
	    }
		scan.close();
	}
}
