package pkgfinal;

/**
 * Flight class
 */
public class flight {
    //fields

    private String number, date, departing, arriving, deptTime, arrivalTime;
    private int seats;
    //constructors

    public flight(String flight, String mmddyy, String departing, String arriving, String dCity, String aCity, int seats) {
        this.number = flight;
        this.date = mmddyy;
        this.departing = dCity;
        this.arriving = aCity;
        this.deptTime = departing;
        this.arrivalTime = arriving;
        this.seats = 56;
    }

    public flight() {
        this.number = " ";
        this.date = " ";
        this.departing = " ";
        this.arriving = " ";
        this.deptTime = " ";
        this.arrivalTime = " ";
        this.seats = 56;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparting() {
        return departing;
    }

    public void setDeparting(String departing) {
        this.departing = departing;
    }

    public String getArriving() {
        return arriving;
    }

    public void setArriving(String arriving) {
        this.arriving = arriving;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeats() {
        return seats;
    }

    //methods
    public void setSeats(int seats) {    
        this.seats = seats;
    }

    public String log() {
        return String.format("%-10s%-12s%-12s%-12s%-12s%-12s\n", number, date, deptTime, arrivalTime, departing, arriving, seats);
    }

    @Override
    public String toString() {
        return "flight{" + "number=" + number + ", date=" + date + ", departing=" + departing + ", arriving=" + arriving + ", dTime=" + deptTime + ", aTime=" + arrivalTime + ", seats=" + seats + '}';
    }

}
