
/**
 * AirPort represents an airPort board which shows which flights departs or arrive at the airport thier origin and Time both arrival and departure time
 *
 * @author Victor kotliar 324133982
 * @version 1.1
 */
public class Airport {

    private final int MAX_FLIGHTS = 200; // max flights for an airpot
    final Flight[] _flightsSchedule; // arry of airport
    private int _noOfFlights; // the number of flights in the arry
    String _city; // city which is declared in airpot (string city) and sets the name for the airport
    private final int VALID = 0; // zero
    /** 
     * Creates an arry with Max ammount of flights and every flight is set to null until its declared (see in AddFlight)
     * @param String
     */

    public Airport(String city) {

        _city = city; 
        _flightsSchedule = new Flight[MAX_FLIGHTS]; // creates an arry placing the MAX_FLIGHT (200) to its index maxing the arry with null 
        _noOfFlights = VALID; 

    }

    /**
     * adds flight to set airport checks if the city or the origin is valid 
     * after adding a flight in the arry its sets the flights insteed of null
     * and gives +1 to _noOfflights making the count for the added flight
     * @param Flight - The flight the user want to add
     * @return returns true or false based on if the flight was successfully added
     */
    public boolean addFlight(Flight f) {
        if(f.getDestination().equals(this._city) || f.getOrigin().equals(this._city)){
            if (_noOfFlights == MAX_FLIGHTS) { // checks if it can add more flights (if not max it will add )
                return false;
            }
            _flightsSchedule[_noOfFlights] = new Flight(f); 
            _noOfFlights++;
            return true;
        }return false;
    }

    /**
     * Remove the flight that is already in the airport 
     * after removing moves all the arry to save the empty spots and order the flights again and -1 the _noOfFlights
     *  returning either false or true based on the outcome
     * @param Flight - Flight that the user wants to delete
     * @return boolean true/false - based on the outcome of the method if it successfully deleted it will return true
     */
    public boolean removeFlight(Flight f) {
        for(int i=0; i<_noOfFlights;i++){ // for that runs and checks the equality of the flight given as a param to see if there is one like this
            if(_flightsSchedule[i].equals(f)){
                for(int j=i; j<(_noOfFlights);j++){     // second for to move all the arry so it wont have empty spaces in between the normal flights
                    _flightsSchedule[j]= _flightsSchedule[j+1];
                }
                _flightsSchedule[_noOfFlights]=null; // the arry in the place of number of flights = place as if length is set to null
                _noOfFlights --; // because we removed the flight we have to remove one flight from no of flights
                return true;
            } 
        } return false;
    }

    /**
     * Prints out using toString of Time1 and Flight to print out the title of the airport (Name + city ) + prints out all the flights which departs or arrive at set airpot
     * checks if the number of flights set to 0 to make sure the program wont run without an airport with valid flights
     * @return (String - returns Airports title and all the flights located in set airport)
     */

    public String toString() {
        if(_noOfFlights==VALID){return null;}
        String Str1 ="The flights for airport " + _city + " today are:\n";
        for(int i = VALID; i<_noOfFlights;i++) // for that adds to the string
        {Str1 +=   _flightsSchedule[i].toString() + "\n" ;
        }
        return Str1; 
    }

    /**
     * Prints out the number (in int) which represents the number of full flight using getIsFull from Flight class
     * @returns (Int - returns the number of full flights located in set airport)
     */

    public int howManyFullFlights() {
        int fullFlights = VALID; // to check the full flights ammount starts with zero 
        for(int i = VALID; i<_noOfFlights;i++)
        {
            if(_flightsSchedule[i].getIsFull())
                fullFlights++; // if there is a full flight ++
        }

        return fullFlights;
    }

    /**
     * Prints out a number (in int ) which represents the number of flights either origin or destination equals to the city 
     *  at the end the user will know how much flights he has from or to set City
     *  @param (String City - The name of the city the user checks for dest or origin )
     *  @return (int flightsBetween - which represents the number of Flights which origin or dest equals to city in parametar)
     */

    public int howManyFlightsBetween(String city) {
        int flightsBetween=VALID;
        for (int i = VALID; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].getOrigin().equals(city) || _flightsSchedule[i].getDestination().equals(city)) { // if there is any flight with city adds ++
                flightsBetween++;
            }
        }
        return flightsBetween;

    }

    /**
     * Prints out the String which represents the most popular destination  using 2 for (the first flight he founds and then it searches to see if he can find another flights with the same Dest
     * afterwerds it goes on for each city in the Airpot until the method finally finds the most popular dest
     * 
     * @returns String - which represnts the most Popular flight.if there is not flights in the airport returns null
     */
    public String mostPopularDestination() {
        if(_noOfFlights == VALID)
        {return null;}
        int topCount = VALID; // Top count to make sure that we are more or less the the top contendor in the most popular dest
        String topCity = ""; 
        for(int i = VALID ; i< _noOfFlights; i++){ // first for to run the program by the arry
            int count = VALID;
            for(int k = VALID ; k< _noOfFlights;k++){ // each index in the arry goes into the second for the check for the dest to count the times
                if(_flightsSchedule[i].getDestination().equals(_flightsSchedule[k].getDestination())){
                    count ++; // each time dest equals to the other fors dest ++
                }
                if(count>topCount) // if by the end the count is more then the top count swap the top count and makes sure to swap the top string
                    topCount = count;
                topCity = _flightsSchedule[k].getDestination();  

            }
        }
        return topCity;
    }

    /**
     * Returns the flight with the highest price for the ticket
     * if there is no flights in the airport returns null
     * @returns flight - The flight with the highest price for a ticket .if there is not flights in the airport returns null
     */

    public Flight mostExpensiveTicket() {

        if (_noOfFlights > VALID) {
            Flight highest =_flightsSchedule[0];
            for(int i=1;i<_noOfFlights;i++) // checks the highest ticket price . it will swap if the price is higher and swap the highest to the _flightsSchedule[i] of the highest one
            {
                if(highest.isCheaper( _flightsSchedule[i]))
                {
                    highest=_flightsSchedule[i];
                }
             }return new Flight(highest); // returns new for anti aliasing
        }return null;
    }
    /**
     * The method returns the time of the first flight from origin using an testTime which is maxed out (23,59) I can run the fors to see if there is any time from set place and change the Time
     * of the testTime afterwards returning the new and earliest time to the user
     * @param String place - The place of the Origin
     * @return Returns Time1 - first flight from set origin using the param place if the _noOfflights lower the zero (Valid) it will return null , if it didnt find any flights from set origin 
     * returns null aswell.
     */

    public Time1 firstFlightFromOrigin (String place)
    { 
        if(_noOfFlights > VALID){
            Time1 testFirst = new Time1 (23,59); // making a new time1 with the maxed out hour and minute to make sure its the latest
            boolean originValid = false; // making a boolean OriginValid 
            for(int i = VALID ; i< _noOfFlights; i++){
                if (_flightsSchedule[i].getOrigin().equals(place)){ // checking the Origin with the place
                    originValid = true; // because the if is true change the originvalid to true
                    if(_flightsSchedule[i].getDeparture().before(testFirst)){
                        testFirst = new Time1( _flightsSchedule[i].getDeparture()); // new found time with the first flight from origin

                    }
                }

            }if (originValid)   //print it out if its valid if not return null
            {return testFirst;}
            else return null ;
        }return null; 
    }
    /**
     * The method returns the longest flight in the arry by compering the flight duration if its longer it will swap between them and keep the for going
     * @returns Returns the longest Flight (if not flight to be found return null )
     */
    
    public Flight longestFlight() {
        if (_noOfFlights > VALID) {       
            Flight longest = _flightsSchedule[VALID]; // setting it up fro the index 0 
            for (int i = 1; i < _noOfFlights; i++) {

                if (_flightsSchedule[i].getFlightDuration() > longest.getFlightDuration()) { // checks if the flight time is shorter if yes it changes the longest
                    longest = _flightsSchedule[i];
                }

            }return new Flight(longest); // new longest to avoid aliasing
        }
        else return null;
    }
}