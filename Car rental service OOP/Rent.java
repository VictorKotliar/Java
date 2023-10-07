
/**
 * Write a description of class Rent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rent
{
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;

    /**
     * Creates a new Rent object
    The return date must be at least one day after the pickup date, otherwise set it to one day after the pick up date.

    @param name - the client's name
    @param car - the rented car
    @param pick - the pickup date
    @param ret - the return date
     */
    public Rent (String name, Car car , Date pick , Date ret){
        _name= name;
        _car = car;
        _pickDate = pick;
        if(ret.before(pick)){ //checks if the return date is after the pickdate else it sets one day foward
            _returnDate = _pickDate.tomorrow();
        }
        else _returnDate = ret;
    }

    /**
     * Copy constructor
     * @param other - the rent to be copied
     * 
     */

    public Rent (Rent other){
        this._name = other._name;
        this._car = other.getCar();
        this._pickDate = other.getPickDate();
        this._returnDate = other.getReturnDate();
    }

    /**
     * Gets the car
     * @return the car
     */
    public Car getCar(){
        return _car;
    }

    /**
     * Gets the name
     * @return the name
     */

    public String getName(){
        return _name;
    }

    /**
     * Gets the pick date
     * @return the pcik up date
     */
    public Date getPickDate(){
        return _pickDate;
    }

    /**
     * Returns the rent total price
     * @return the rent total price
     */
    public void setCar(Car car){
        Rent newRent = new Rent(this.getName() , car , this.getPickDate() , this.getReturnDate());
    }

    /**
     * Sets the client name
     * @param name - the client name (You can assume that the name is valid name)
     */
    public void setName(String name){
        Rent newRent = new Rent(name ,  this.getCar() , this.getPickDate() , this.getReturnDate());
    }

    /**
     * Gets the return date
     * @return the return date
     */
    public Date getReturnDate(){
        return _returnDate;
    }

    /**
     * Sets the pick up date
    The pick up date must be at least one day before the return date, otherwise - don't change the pick up date

    @param pickDate - the pick up date (You can assume that pick up date is not null)    */

    public void setPickDate(Date pickDate){
        Rent newRent = new Rent(this.getName() ,  this.getCar() , pickDate , this.getReturnDate());
    }

    /**
     * Sets the return date
    The return date must be at least one day after the pick up date, otherwise - don't change the return date
     * @param returnDate - the return date (You can assume that return date is not null)
     */

    public void setReturnDate(Date returnDate){
        if(_pickDate.before(returnDate)){
            _returnDate = returnDate;
        }else
            _returnDate = _pickDate.tomorrow();
    }

    /**
     * Returns the number of rent days
     * @return the number of rent days
     */

    public int howManyDays(){
        return this.getPickDate().difference(this.getReturnDate());}

    /**
     * Check if 2 rents are the same
     * @param other - the rent to compare this rent to
     * @return true if the rents are the same
     */
    public boolean equals(Rent other){
        if(this.getPickDate().equals(other.getPickDate())&& this.getReturnDate().equals(other.getReturnDate())&&this.getCar().equals(other.getCar())){
            return true;
        } return false;
    }

    /** Gets the return date
     * @return the return date
     */

    public int getPrice(){
        int weeks = this.howManyDays()/7;
        int days = this.howManyDays()%7;
        int price = 0;
        if(this._car.getType() == 'A'){
            if(weeks>=1){price = (this.howManyDays() * 100) - 70*weeks;}else price = (days*100);
        }
        if (this._car.getType() == 'B'){
            if(weeks>=1){price = (this.howManyDays() *150 ) - weeks*135;}else price = (days*150);
        }
        if (this._car.getType() == 'C'){
            if(weeks>=1){price = (this.howManyDays() * 180 ) - weeks*162;}else price = (days*180);
        }
        if (this._car.getType() == 'D'){
            if(weeks>=1){price = (this.howManyDays() * 240 ) - weeks* 216 ;}else price = (days*240);
        }
        return price;
    }

    /**
     * Try to upgrade the car to a better car
    If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost, otherwise - don't upgrade
    @param car - the car to upgrade to
    @return the upgrade cost
     */
    //comparing both and seeing if its worse and the using math abs to get the price the need to add
    public int upgrade (Car newCar){
        int oldPrice = this.getPrice();
        if (newCar.better(new Car (this._car))){
            this.setCar(new Car(newCar));
            int newPrice = this.getPrice();
            // the price to add is
            return Math.abs(oldPrice - newPrice);
        }
        else {
            return 0;
        }

    }

    /**
     * Returns a String that represents this rent
     * @overrides toString in class java.lang.Object
     * @return String that represents this rent in the following format:
    Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
     */

    public String toString(){
        Rent newRent = new Rent(this.getName() , _car , this.getPickDate() , this.getReturnDate());
        String str = "" ;
        return str = ("Name:" + newRent.getName() + " From:" + newRent.getPickDate() + " Type:" + newRent.getCar() + " Days:" + newRent.howManyDays() + " Price:" + newRent.getPrice());
    }

    /**
     * Check if there is a double listing of a rent for the same person and car with an overlap in the rental days
    If there is - return a new rent object with the unified dates, otherwise - return null.
    @param other - the other rent
    @return the unified rent or null
     */

    public Rent overlap (Rent other){
        Rent newRent = new Rent(this.getName() , _car , this.getPickDate() , this.getReturnDate());
        // checking if its the same
        if(newRent.equals(other)){
            return newRent;
        }

        if(this.getPickDate().after(other.getPickDate())&&(this.getReturnDate().before(other.getReturnDate()))){
            newRent.setReturnDate(other.getReturnDate());
            return newRent;
        }
        if(other.getPickDate().after(this.getPickDate())&&(other.getReturnDate().before(this.getReturnDate()))){
            newRent.setReturnDate(this.getReturnDate());
            return newRent;}

        if(this.getReturnDate().before(other.getPickDate())){return null;}

        if(other.getReturnDate().before(this.getPickDate())){return null;}

        if(this.getReturnDate().equals(other.getPickDate())){
            newRent.setReturnDate(other.getReturnDate());
            return newRent;}

        if(other.getReturnDate().equals(this.getPickDate())){
            newRent.setPickDate(other.getPickDate());
            return newRent;
        }

        if(this.getReturnDate().after(other.getReturnDate())){
            return newRent;
        }

        if(this.getReturnDate().after(other.getReturnDate())){
            return newRent;
        }

        if(other.getReturnDate().after(this.getPickDate()) && this.getReturnDate().before(other.getReturnDate())){
            newRent.setReturnDate(other.getReturnDate());
            return newRent;    
        }

        if(this.getPickDate().after(other.getPickDate()) && this.getReturnDate().equals(other.getPickDate())){
            newRent.setPickDate(other.getPickDate());
            return newRent;
        }

        return null;}
}
