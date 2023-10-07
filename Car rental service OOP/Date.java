
/**
 * Write a description of class Date here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date
{

    private int _day;
    private  int _month;
    private int _year;
    private  int maxDay= 31;
    private int maxDay2 = 30;
    private  int maxDayOnFebOnLeap = 28;
    private int MaxDayOnFebNotLeap = 29;
    private int maxMonth = 12;
    private int validDay = 1 ;
    private int defYear = 2000;
    private int min = 0 ;
    private int jan = 1;
    private int feb = 2;
    private int mar = 3;
    private int apr = 4;
    private int may = 5;
    private int jun = 6;
    private int jul = 7;
    private int aug = 8;
    private int sep = 9;
    private int oct = 10;
    private int nov = 11;
    private int dec = 12;
    private int validYearMax = 9999;
    private int validYearMin = 1000;

    /**
     * private method that calculates days since the counting
     * @param day - the day
     * month - the month
     * year - year
     * @return the number of days since counting
     */

    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62); }

    /**
     * Checks if its a leap year
     * @param year
     * @rturn boolean if its a leap year or no.
     * 
     */

    private boolean leapYearCheck( int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

    }

    /**
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     * @param 
     * day - the day in the month (1-31)
    month - the month in the year (1-12)
    year - the year (4 digits)

     */

    public Date(int day ,int month , int year){

        if(leapYearCheck(year) == false && (month == feb && day > maxDayOnFebOnLeap)) // checks every option with leap non leap and max days
        {   _day = validDay;
            _month = jan; 
            _year = defYear;
            return;}
        if(leapYearCheck(year) == true && (month == feb && day > MaxDayOnFebNotLeap))
        {   _day = jan;
            _month = jan; 
            _year = defYear;
            return;}
        if(leapYearCheck(year) == true && (month == feb && day == MaxDayOnFebNotLeap))
        {   _day = MaxDayOnFebNotLeap;
            _month = feb; 
            _year = year;
            return;}
        if(leapYearCheck(year) == false && (month == feb && day == MaxDayOnFebNotLeap))
        {   _day = validDay;
            _month = jan; 
            _year = defYear;
            return;} 
        if( (month == nov && day >= maxDay||month == apr && day >= maxDay|| month == jun && day >= maxDay|| month == sep && day >= maxDay) || year < validYearMin || year > validYearMax)
        {   _day = validDay;
            _month = jan; 
            _year = defYear;
            return;} 
        else if (month <= dec && month >= jan && day >= jan && day <= maxDay){
            _day = day;
            _month = month;
            _year = year;}
        else{ _day = validDay;
            _month = jan; 
            _year = defYear;
            return;}  

    } 

    /**
     * Copy constructor
     * @parm other - the date to be copied

     */

    public Date ( Date other){
        // simple copy
        other._day=_day;
        other._month=_month ;
        other._year= _year;
    }

    /**
     * Gets the day
     * @return the day
     */

    public int getDay(){
        return _day;
    }

    /**
     * Set the day (only if date remains valid)
     * @param 
    dayToSet - the day value to be set
     */

    public void setDay(int dayToSet){
        //same checks as constarctor
        if(leapYearCheck(this.getYear()) == false && (this.getMonth() == feb && dayToSet > maxDayOnFebOnLeap))
        {  
            return;}
        if(leapYearCheck(this.getYear()) == true && (this.getMonth() == feb && dayToSet > maxDayOnFebOnLeap))
        { 
            return;}
        if(leapYearCheck(this.getYear()) == true && (this.getMonth() == feb && dayToSet == maxDayOnFebOnLeap))
        {   _day = MaxDayOnFebNotLeap; 
            return;}
        if(leapYearCheck(this.getYear()) == false && (this.getMonth() == feb && dayToSet == maxDayOnFebOnLeap))
        { 
            return;} 
        if( (this.getMonth() == nov && dayToSet >= maxDay||this.getMonth() == apr && dayToSet >= maxDay|| this.getMonth() == jun && dayToSet >= maxDay|| this.getMonth() == sep && dayToSet >= maxDay) || this.getYear() < validYearMin || this.getYear() > validYearMin)
        { 
            return;} 

        _day = dayToSet;
    }

    /**
     * Gets the month
     * @return the month
     */

    public int getMonth(){ 
        return _month;
    }

    /**
     * Set the month (only if date remains valid)
     * @param monthToSet - the month value to be set
     */
    //checking if day and month valid and if its feb or not a full month
    public void setMonth(int monthToSet){
        if(this.getDay()== MaxDayOnFebNotLeap && monthToSet == feb){return;}
        if(this.getDay() == maxDay && monthToSet == nov ||this.getDay() == maxDay && monthToSet == apr || this.getDay() == maxDay && monthToSet == jun ||this.getDay() == maxDay && monthToSet == sep){return;}
        if (monthToSet <= dec && monthToSet >=jan) 
            _month = monthToSet;
    }

    /**
     * Gets the year
     * @return the year
     */

    public int getYear(){
        return _year;
    }

    /**
     * Sets the year (only if date remains valid)
     * @param yearToSet - the year value to be set
     */
    //check if its okey to set leap and non leap
    public void setYear(int yearToSet){
        if(leapYearCheck(yearToSet) == false  && (this.getMonth() == feb && this.getDay() > maxDayOnFebOnLeap))
        {  
            return;}
        if(leapYearCheck(yearToSet) == true && (this.getMonth() == feb && this.getDay() > MaxDayOnFebNotLeap))
        { 
            return;}
        if(leapYearCheck(yearToSet) == true && (this.getMonth() == feb && this.getDay() == MaxDayOnFebNotLeap))
        {   _year = yearToSet;
            return;}
        if(leapYearCheck(yearToSet) == false && (this.getMonth() == feb && this.getDay() == MaxDayOnFebNotLeap))
        { 
            return;} 

        if(yearToSet >=validYearMin && yearToSet <= validYearMax){
            _year = yearToSet;
            return;}

    }

    /**
     * Calculates the difference in days between two dates
     * @param other - the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */

    public boolean equals (Date other){
        if(_day == other._day && _month == other._month && _year == other._year){return true;}
        return false;
    }

    /**
     * Check if this date is before other date
     * @param other - date to compare this date to
     * @return true if this date is before other date, otherwise false
     */

    public boolean before (Date other){
        if(this.equals(other)) {return false;}  
        if (calculateDate(this.getDay(),this.getMonth(),this.getYear()) < calculateDate(other.getDay(),other.getMonth(),other.getYear())){return true; }
        else
            return false;
    }

    /**
     * Check if this date is after other date
     * @parm other - date to compare this date to
     * @return true if this date is after other date, otherwise false
     */

    public boolean after (Date other){
        if(this.equals(other) == true){return false;}
        if(this.before(other) == false){return true;}
        else return false;
    }

    /**
     * 
     * Calculates the difference in days between two dates
     * @param other - the date to calculate the difference between
     * @return 
     * the number of days between the dates (non negative value)
     */

    public int difference (Date other){
        return  Math.abs(other.calculateDate(other.getDay(),other.getMonth(),other.getYear()) - this.calculateDate(this.getDay(),this.getMonth(),this.getYear()));

    }

    /**
     * Returns a String that represents this date
     * @overrides toString in class java.lang.Object
     * @return String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */

    public String toString(){
        String str = "";
        if(_day<10) str += "0" + _day + "/";
        else str+= _day+"/";

        if(_month<10) str +="0"+_month + "/";
        else str+= _month+"/";

        str+= _year;
        return str;

    }

    /**
     * Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    // calculates the next day 
    public Date tomorrow(){
        Date newDate = new Date(this.getDay(),this.getMonth(),this.getYear());
        if(leapYearCheck(newDate.getYear()) == false && newDate.getMonth() == feb){
            if(newDate.getDay() == maxDayOnFebOnLeap){
                newDate.setMonth(mar);
                newDate.setDay(jan);
                return newDate ;}
        }
        else if(leapYearCheck(newDate.getYear()) == true && newDate.getMonth() == feb){
            if(newDate.getDay() == MaxDayOnFebNotLeap){
                newDate.setMonth(mar);
                newDate.setDay(jan);
                return newDate ;}
        }

        else if (newDate.getMonth() == nov && newDate.getDay() == maxDay2 ||newDate.getMonth() == apr && newDate.getDay() == maxDay2 ||newDate.getMonth() == jun && newDate.getDay() == maxDay2 ||newDate.getMonth() == sep && newDate.getDay() == maxDay2){
            newDate.setMonth(newDate.getMonth()+1);
            newDate.setDay(jan);
            return newDate;
        }

        else if (newDate.getDay() == maxDay && newDate.getMonth() == dec){
            newDate.setMonth(jan);
            newDate.setDay(validDay);
            newDate.setYear(newDate.getYear()+1);
            return newDate;

        }else if (newDate.getDay() == maxDay && newDate.getMonth()!=dec){
            newDate.setMonth(newDate.getMonth()+1);
            newDate.setDay(validDay);
            return newDate;}

        else
        {
            newDate.setDay(newDate.getDay()+1);
            return newDate;};
        return newDate;}
}

