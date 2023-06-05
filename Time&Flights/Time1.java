
/**
 * Represents time - hours:minutes. Coordinates cannot be negative.
 *
 * @name Victor aviv kotliar
 * @version 1
 */

/**Represents time - hours:minutes. Coordinates cannot be negative. 
   */
public class Time1
{
    private int _hour;
    private int _minute;
    private int _newTime;
    private final int  MIN_HOUR = 0; // the range is 0 to 24 (not included)
    private final int  MAX_HOUR = 24;
    private final int  MIN_MINUTE = 0;
    private final int MAX_MINUTE = 60;// the range is 0 to 60 (not included)
    private final int DAY_HOUR_IN_MIN = 1440;
    private final int TWO_DIGIT_NUMBER = 10;
    private final int VALID = 0;

    /**
    Constructs a Time1 object. */
    public Time1 (int h, int m)
    {
        if(MIN_HOUR<_hour||MAX_HOUR>_hour){
            _hour = h;
        }else _hour = VALID;
        if(MIN_MINUTE<_minute||MAX_MINUTE>_minute){
            _minute = m;
        }else _minute = VALID;
    }    

    /**
    Copy constructor for Time1.
     */
    public Time1 (Time1 other)
    {
        _hour = other._hour;
        _minute = other._minute; 

    }

    /**Returns the hour of the time.
     */
    public int getHour(){
        return _hour;
    }

    /**     
    Returns the minute of the time.
     */
    public int getMinute(){
        return _minute;
    }

    /**
     * Changes the hour of the time.
     */
    public void setHour(int num){
        if(MIN_HOUR<num&&MAX_HOUR>num){
            _hour = num;
        }

    } 

    /**
     * Changes the minute of the time.
     */
    public void setMinute(int num){
        if(MIN_MINUTE < num && MAX_MINUTE > num){
            _minute = num;  }
    }

    /**    
    Return a string representation of this time (hh:mm).
     */
    public String toString(){
        String timeString = ""; // the declration of the String that im going to print when im returning
        if(_hour<TWO_DIGIT_NUMBER){
            timeString+="0"+_hour;}
        else timeString+=_hour;
        timeString+=":";
        if(_minute<TWO_DIGIT_NUMBER){
            timeString+="0"+_minute;}
        else timeString+=_minute;
        return timeString;
    }

    /**
    Return the amount of minutes since midnight.
     */
    public int minFromMidnight(){
        return (getHour()*MAX_MINUTE + getMinute());
    }   

    /**
    Check if this time is before a received time.
     */
    public boolean before (Time1 other){
        return(_hour<other._hour)||(_hour == other._hour) && (_minute < other._minute);
    }

    /**Check if this time is after a received time.
     */
    public boolean after (Time1 other){
        return(other.before(this));
    }

    /**
    Check if the received time is equal to this time.
     */
    public boolean equals (Time1 other){
        return (_hour==other._hour && _minute==other._minute);
    }

    /**Calculates the difference (in minutes) between two times.
     */
    public int difference(Time1 other){
        return Math.abs((_hour-other._hour)*MAX_MINUTE + (_minute-other._minute) );
    }

    /**Copy current object and add requested minutes to new object.*/
    public Time1 addMinutes (int num)  {
        num = num%DAY_HOUR_IN_MIN;
        if(num>0) { 
            int sumMinAndHour = _minute + _hour*MAX_MINUTE; // I have added the hours so I can save the value of it
            int totalMin = sumMinAndHour + num; // basically adding up the function  hours and minutes and the new number of minute

            return new Time1(totalMin % DAY_HOUR_IN_MIN/MAX_MINUTE,totalMin %MAX_MINUTE);
        }
        else{
            int sumMinAndHour = _minute + _hour*MAX_MINUTE;// I have added the hours so I can save the value of it
            int totalMin = sumMinAndHour - num; // basically adding up the function  hours and minutes and the new number of minute
            return new Time1(Math.floorMod(totalMin , DAY_HOUR_IN_MIN/MAX_MINUTE),Math.floorMod(totalMin ,MAX_MINUTE));

        }
    } 

}

