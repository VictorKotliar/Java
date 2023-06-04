
/**
 * 
 * 
 *
 * @victor aviv kotliar (your name)
 * @1 (a version number or a date)
 */

/** Represents a flight. A Flight object is represented by the flight's origin,destination,departure time, flight duration, no of passengers,if it is full and the price.
*/
public class Flight
{
    // instance variables - replace the example below with your own
    private String _origin;
    /** The city the flight lands at.*/
    private String _destination;

    private Time1 _departure;
    /** The duration time in minute*/
    private int _flightDuration;
    /** The number of passengers (should be between 0-maximum capacity).*/
    private int _noOfPassengers;

    private boolean _isFull;
    private int _price;
    private final int MAX_CAPACITY = 250; // max capacity
    private final int VALID=0;
    private final int MAX_HOUR = 23; // the max declared number for hour (included)
    private final int MAX_MINUTE = 59; // the max declared number for minute (included)
    /**
     * Constructor for objects of class Flight
     */
    public Flight(String origin , String dest , int depHour, int depMinute, int durTimeMinutes , int noOfPass, int price)
    {
        /**The city the flight leaves from.*/
        _origin = origin;
        /** The city the flight lands at.*/
        _destination = dest;
        /**the departure hour (should be between 0-23).*/

        if(depHour>VALID && depHour <= MAX_HOUR){
        }else depHour=VALID;

        /**The departure minute (should be between 0-59).*/
        if(depMinute>VALID && depMinute <= MAX_HOUR){
            new Time1(depHour,depMinute);
        }else depMinute=VALID;

        _departure = new Time1(depHour,depMinute);

        /** The duration time in minutes(should not be negative).*/
        if (durTimeMinutes >= VALID )
            durTimeMinutes=_flightDuration;
        else _flightDuration = VALID;
        /** The number of passengers (should be between 0-maximum capacity).*/
        if(noOfPass <= MAX_CAPACITY)
            _noOfPassengers = noOfPass;
        else if (noOfPass < VALID)
            _noOfPassengers = VALID;
        else if (noOfPass >= MAX_CAPACITY)
        {_noOfPassengers = MAX_CAPACITY;};

        /** The price (should not be negative).*/
        if(price >= VALID)
        {_price = price ;}
        else _price = VALID;

    }

    /**Copy constructor for a Flight object.*/
    public Flight(Flight other){

        _origin = other._origin;
        _destination = other._destination;
        _noOfPassengers = other._noOfPassengers;
        _flightDuration = other._flightDuration;
        _departure = new Time1 (other._departure);
        _price = other._price;

    }

    /**    Returns the flight origin.*/
    public String getOrigin(){
        return _origin;
    }

    /**Returns the flight destination.*/
    public String getDestination(){
        return _destination;
    }

    /** Returns the flight departure time.*/

    public Time1 getDeparture(){
        return new Time1(_departure.getHour(), _departure.getMinute());
    }

    /**    Returns the flight duration time in minutes.*/
    public int getFlightDuration(){
        return _departure.difference(getArrivalTime());
    }

    /**    Returns the number of passengers on the flight.*/
    public int getNoOfPassengers(){
        return _noOfPassengers;
    }

    /**    Returns whether the flight is full or not.*/
    public boolean getIsFull(){
        return (_noOfPassengers==MAX_CAPACITY);

    }

    /**    Returns the price of the flight .*/
    public int getPrice(){
        return _price;
    }

    /**Changes the flight's destination.*/
    public void setDestination(String dest){
        dest=_destination;
    }

    /**Changes the flight's origin.*/
    public void setOrigin(String origin){
        _origin = origin;
    }

    /**Changes the flight's departure time.*/
    public void setDeparture (Time1 departureTime)
    {   _departure = new Time1(departureTime);
    }

    /**Changes the number of passengers.*/
    public void setNoOfPassengers (int noOfPass)
    {   if (noOfPass < MAX_CAPACITY){
            _noOfPassengers = noOfPass;}
        else{_noOfPassengers = MAX_CAPACITY;
        }

    }

    /**    Changes the flight price.*/
    public void setPrice(int price){
        _price = price;
    }

    /**Return a string representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").*/
    public String toString(){
        if ( getIsFull() ) {
            String fullFlight = " Flight is full.";
            return ("Flight from" + " " + _origin + " to " + _destination + " departs at " + _departure.toString() + "."+ fullFlight);
        }
        else {
            String fullFlight = " Flight is not full.";
            return ("Flight from" + " " + _origin + " to " + _destination + " departs at " + _departure.toString() + "." + fullFlight);
        }

    
    }

    /**Check if the received flight is equal to this flight.*/
    public boolean equals (Flight other){
        return(_origin == other._origin && _destination == other._destination && _departure == other._departure);
    }

    /**    Returns the arrival time of the flight .*/
    public Time1 getArrivalTime(){
        return new Time1(_departure.addMinutes(_flightDuration));
    }

    /**    Add passengers to this flight.*/
    public boolean addPassengers(int num){
        if(num + _noOfPassengers <= MAX_CAPACITY){
            num+=_noOfPassengers;
            if(_noOfPassengers == MAX_CAPACITY){
                return _isFull=true; }
            else return _isFull=false;}else return false;
    }

    /**Check if this flight is cheaper than another flight.*/
    public boolean isCheaper(Flight other){
        return (_price < other._price);
    }

    /**Calculate the total price of the flight.*/
    public int totalPrice(){
        return _price * _noOfPassengers;
    }

    /**    Check if this flight lands before another flight.*/
    public boolean landsEarlier(Flight other){
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**Changes the flight's duration time.*/
    public void setFlightDuration(int durTimeMinutes){
        durTimeMinutes = _flightDuration;
    }


}

