package model.entities;

import model.excepection.DomainException;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // static para que nao haja novas implementacoes do sdf desta classe

    Date now = new Date();
    public Reservation(){

    }
    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException{
        if (!checkout.after(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        if (checkin.before(now) || checkout.before(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diffMilliSeconds = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diffMilliSeconds, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        if (checkIn.before(now) || checkOut.before(now)){ // se quaisquer das datas forem antes de agora, dara erro!
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)){ //checkout nao pode ser antes do check-in
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room " +roomNumber+
                ", check-in: " +sdf.format(checkIn)+
                ", checkOut: " +sdf.format(checkOut)+
                ", " +duration()+ " nights";
    }
}
