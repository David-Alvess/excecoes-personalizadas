package model.entities;

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

    public Reservation(){

    }
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
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
    public String updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){ // se quaisquer das datas forem antes de agora, dara erro!
            return "Reservation dates for update must be future dates!";
        }
        else if (!checkOut.after(checkIn)){ //checkout nao pode ser antes do checkin
            return "Check-out date must be after check-in date!";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room " +roomNumber+
                ", check-in: " +sdf.format(checkIn)+
                ", checkOut: " +sdf.format(checkOut)+
                ", " +duration()+ " nights";
    }
}
