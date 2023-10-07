
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car
{
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual; 

    /**
     * Creates a new Car object
    id should be a 7 digits number, otherwise set it to 9999999
    type should be 'A','B','C' or 'D', otherwise set it to 'A'
    @param id - the id of the car (7 digits number)
    @param type - the type of the car ('A','B','C' or 'D')
    @param brand - the car's brand
    @param isManual - flag indicating if the car is manual

     */

    public Car(int id, char type, String brand, boolean isManual){
        if(id > 1000000 || id >= 9999999) _id = 9999999; // the allowed range
        else _id = id;
        if(type != 'D' ||type !=  'C' ||type !=  'B' ||type !=  'A') { //checking if its legal
            _type = 'A';   
        }else _type = type;
        _brand = brand;
        _isManual = isManual;
    }

    /**
     * Copy constructor
     * @param other - the car to be copied
     */

    public Car (Car other){ 
        other._id=_id;
        other._type=_type;
        other._brand= _brand;
        other._isManual =_isManual;
    }

    /**
     * Gets the brand
     * @return the brand
     */

    public int getId(){return _id;}

    /**
     * Sets the id (only if the given id is valid)
     * @param id - the id value to be set
     */

    public void setId(int  id){   
        if(id < 0 || id >= 9999999){ // checking validity
            id = 9999999;}else _id = id;
    }

    /**
     * Gets the type
     * @return the type
     */
    public char getType(){
        return _type;}

    /**
     * Sets the type (only if the given type is valid)
     * @param type - the type value to be set
     */
    public void setType(char type){
        if(type != 'D' ||type !=  'C' ||type !=  'B' ||type !=  'A') {
            type = 'A';   
        }else _type = type;}

    public String getBrand(){return _brand;}

    /**
     * Sets the brand of the car
     * @param brand - the brand value to be set
     */

    public void setBrand(String brand ) {
        _brand = brand;
    }

    /**
     * Gets the isManual flag
     * @return the isManual flag
     */
    public boolean isManual(){return _isManual;}

    /**
     * Sets the isManual flag of the car
     * @param isManual - the isManual flag to be set
     */
    public void setIsManual(boolean manual) {
        if(_isManual == true){_isManual = false;} //checking the status now
        else if (_isManual == false){_isManual = true;};}

    /**
     * Returns a String object that represents this car
     * @override toString in class java.lang.Object
     * @return String that represents this car in the following format:
    id:1234567 type:B brand:Toyota gear:manual (or auto)
     */
    public String toString(){
        String gear;
        if (_isManual == true ) gear = "manual";
        else gear = "auto"; //adding the gear as a new string to make it easy 
        String str1 = "id:" + _id + " type:"+_type+" brand:"+_brand+" gear:"+gear;
        return str1;
    }

    /**
     * Check if two cars are the same
    Cars are considered the same if they have the same type, brand and gear
    @param other - the car to compare this car to
    @return true if the cars are the same, otherwise false

     */

    public boolean equals (Car other) {
        if(_type == other._type && _brand == other._brand && _isManual == other._isManual){return true;}
        return false;
    }

    /**
     * Check if this car is better than the other car
    A car is considered better than another car if its type is higher.
    If both cars have the same type, an automated car is better than a manual car.
     * 
     * @param other - car to compare this car to
     * @return true if this car is better than the other car, otherwise false
     */

    public boolean better (Car other){
        if (other._type < _type){
            return true;
        } else if (other._type > _type){
            return false;
        }
        else {
            return other._isManual && !_isManual;

        }
    }

    /**
     * Check if this car is worse than the other car
     * @param other - car to compare this car to
     * @return true if this car is worse than the other car, otherwise false

     */
    public boolean worse (Car other ) {
        return other.better(this);
    }

}

