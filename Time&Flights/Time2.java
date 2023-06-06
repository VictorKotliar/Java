
/**
 *
 *
 * @name Victor Aviv kotliar
 * @version (1)
 */

/**
 * Represents time - hours:minutes. Values must represent a proper time..
 */
public class Time2
{
 private int _minFromMid;
  private final int  MIN_HOUR = 0; // the range of hour is from 0 to 24 (not included)
  private final int  MAX_HOUR = 24;
  private final int  MIN_MINUTE = 0;
  private final int MAX_MINUTE = 60; // the range of minute is from 0 to 60 (not included)
  private final int DAY_HOUR_IN_MIN = 1440;
  private final int VALID = 0;
  private final int TWO_DIGIT_NUMBER= 10;
  /**
  Constructs a Time2 object. */
  public Time2 (int h, int m)
  
  { 
      if (h<VALID) {h=VALID;}
      if (m<VALID) {m=VALID;}
      if (h<MAX_HOUR && m<MAX_MINUTE && h>=VALID && m>=VALID){_minFromMid = h*MAX_MINUTE + m;}
     
    }
         /**
   Copy constructor for Time2.
   */
    public Time2 (Time2 other){
    _minFromMid = other._minFromMid;
    }
      /**     
Returns the hour of the time.
     */
    int getHour(){
    return _minFromMid/MAX_MINUTE;
    }
      /**     
Returns the minute of the time.
     */
    int getMinute(){
    return Math.floorMod(_minFromMid,MAX_MINUTE);
    }/**
     * Changes the hour of the time.
     */
    public void setHour(int num){
      int _moduloOfMinFromMid = Math.floorMod(_minFromMid,MAX_MINUTE); // I made a modulo to save the minutes if i didnt declare it  will return hour:00
      if (num *MAX_MINUTE >= VALID && num * MAX_MINUTE < DAY_HOUR_IN_MIN )
      _minFromMid = num*MAX_MINUTE + _moduloOfMinFromMid;
     
    }
    /**
     * Changes the minute of the time.
     */
    void setMinute(int num){
        int hoursnow = getHour()*MAX_MINUTE; // same as the set hour I saved the hour so that it wont declare 00:minute
        if(num >= VALID && num <MAX_MINUTE)
        _minFromMid = hoursnow + num;
        
        
    }
      /**
         Return the amount of minutes since midnight.
         */
    int minFromMidnight(){
    return _minFromMid%DAY_HOUR_IN_MIN;
    }
        /**
Check if the received time is equal to this time.
     */
    boolean equals (Time2 other)
    {return _minFromMid==other._minFromMid ;}
     /**
Check if this time is before a received time.
     */
    boolean before (Time2 other)
    {return (_minFromMid < other._minFromMid);
    }
     /**Check if this time is after a received time.
     */
    boolean after (Time2 other)
    {return (other.before(this));
    }
    /**Calculates the difference (in minutes) between two times.
 */
    int difference(Time2 other){
    return Math.abs (_minFromMid - other._minFromMid);
    }
    /**    
Return a string representation of this time (hh:mm).
 */
       public String toString(){
           String timeString = "";
           if(getHour()<TWO_DIGIT_NUMBER){
            timeString+="0"+getHour();}
            else timeString+=getHour();
            timeString+=":";
             if(getMinute()<TWO_DIGIT_NUMBER){
            timeString+="0"+getMinute();}
            else timeString+=getMinute();
            return timeString;
        }
/**Copy current object and add requested minutes to new object.*/
 public Time2 addMinutes (int num)  {
     num = Math.floorMod((num),DAY_HOUR_IN_MIN);
        if(num>=0) { 
          
    int sumMinAndHour = _minFromMid; // saving the value of _minFromMid so i can add or subtract the added/subtracted minute
    int totalMin = sumMinAndHour + num;
    
          
    return new Time2 (Math.floorMod(totalMin , DAY_HOUR_IN_MIN)/MAX_MINUTE,Math.floorMod(totalMin , MAX_MINUTE));
      }
      else{
     int sumMinAndHour = _minFromMid;
    int totalMin = sumMinAndHour - num;
    return new Time2 (Math.floorMod(totalMin , DAY_HOUR_IN_MIN)/MAX_MINUTE,Math.floorMod(totalMin , MAX_MINUTE));
     
    }}
    
     
        }
    

