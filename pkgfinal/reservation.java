

package pkgfinal;

/**
Reservation class
 */
class reservation {
    //fields
    
    private String flightNumber, first, last, iD, seat;
    
    //constructors
              
    public reservation(String flight, String name, String surname, String number, String choice)
    { 
        this.flightNumber = flight;
        this.first = name;
        this.last = surname;
        this.iD = number;
        this.seat = choice;
    } 
    
    public reservation() 
    { 
        this.flightNumber = " ";
        this.first = " ";
        this.last = " ";
        this.iD = " ";
        this.seat = " ";
    } 
    
    
    //methods

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    
    public String showReservations(){
    return String.format("%-10s%-12s%-12s%-12s\n", first, last, iD, seat);
    }

    public String log() {
        return String.format("%-10s%-12s%-12s%-12s%-12s%-12s\n", flightNumber, first, last, iD, seat);
    }
    
    @Override
    public String toString() {
        return "reservation{" + "flightNumber=" + flightNumber + ", first=" + first + ", last=" + last + ", iD=" + iD + ", seat=" + seat + '}';
    }

    }