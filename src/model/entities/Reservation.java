package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
//Formatação de data
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
//Propagar excesoes no construtor se chama programação defenciva
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
	    	throw new DomainException("Check-out date must be after check-in date");
	    }
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
//set checkIn e checkoult devem ser excluido para evitar mudnaças arbitrarias
//Pois existem metodos para eles
	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

//metodo para calcular duração em dias
	public long duration() {
//getTime() devolve a quant de milisegundos da data
//Pegam a diferença de datas em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();

//Conversão de milisegundos p/ dias usar classe TimeUnit
	return	TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
//Metodo recebe as datas e atualiza sistema
	public void updateDates(Date checkIn, Date checkOut){
		
		 Date now = new Date();
		    if(checkIn.before(now) || checkOut.before(now)) {
		    throw new DomainException("Error in reservation: update must be future dates");
		    } else if(!checkOut.after(checkIn)) {
		    	throw new DomainException("Check-out date must be after check-in date");
		    }
		
		this.checkIn = checkIn; //checkIn do objeto recebe chekIn do parametro
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber 
			 + ", check-in: "
			 + sdf.format(checkIn)
			 + ", check-out: "
			 + sdf.format(checkOut)
			 + ", "
			 + duration()
			 + " nigths";
	}
}
