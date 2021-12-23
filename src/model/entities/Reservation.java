package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
//Formatação de data
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
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
	public void updateDates(Date checkIn, Date checkOut) {
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
