
/**
 * Set is a node making class which uses IntNode to make sure everyting is aliaised
 *Thanks for the course it was pretty challenging and it took a lot of practise 
 *I hope ill do great on the exam
 *
 * @author (Victor Aviv kotliar)
 * @version (1 )
 * @Tz (324133982)
 */
public class Set
{
    /**
     * Instance variables are _head and _tail
     * @param _head represents the head of the node
     * @param _tail represents the Tail of the node I have added the Tail just incase ill use it somtimes its free anyways
     * 
     */
    private IntNode _head,_tail;

    
  
    
    public IntNode getHead(){
        return _head;
    }


    

    /**
     * Public Set () is the empty constarctor for the set class
     */
    public Set() {
        _head = null;
        _tail = null;

    }
    /**
     * returns the Tail of the set node
     * @return _tail
     */
     public IntNode getTail()
    {
        return _tail;
    }
    /**
     * tailCheck is used to make the last 3 methods more efficent as it checks who is the last and thats why  you dont need to run the whole code to get to the end to add
     * time of (1)
     * space of (1)
     * 
     */
    
    
     private void tailCheck(Set list,int n)
    {

        IntNode newNode = new IntNode(n,null);
        if(list.isEmpty()==true) //if that's the first node added - he is the head.
        {
            list._head = newNode;
            list._tail = newNode;
        }
        else
        {
            list.getTail().setNext(newNode);        //adding a new node to the end
            list._tail = newNode;               //setting the tail pointer to the new node.
        }
    }
    
    /**
     * Time complexity of N when n is the number of nodes in the list (n)
     * space complexity (1)
     * add to set is the adding system for the node it sorts and checks 
     * 
     */

    public void addToSet (int numToAdd)
    {   

        IntNode newNodeToAdd = new IntNode(numToAdd,null);
        IntNode temp = _head;
        if ((numToAdd>0) && (numToAdd % 2 == 1)){
            if(isEmpty())       
            {

                _head = newNodeToAdd;
                _tail = newNodeToAdd;

            }   
            else
            {
                if(isMember(numToAdd)==false){

                    if(temp.getValue()>numToAdd)
                    {
                        newNodeToAdd.setNext(temp);
                        _head = newNodeToAdd;

                    }else{
                        while (temp.getNext()!=null && temp.getNext().getValue()<newNodeToAdd.getValue())
                            temp = temp.getNext();
                        // next is null or a node with a bigger value;
                        newNodeToAdd.setNext(temp.getNext());
                        temp.setNext(newNodeToAdd);
                        if(temp.getNext()==null){_tail = newNodeToAdd;}
                        
                        
                    }
                
                }
                
            }

        } 
    }
    /**
     * (1)time
     * (1)space
     * isempty checks if the set is empty set
     * @returns boolean true if its empty
     */

    public boolean isEmpty ()
    {
        if (_head==null)
            return true;
        else return false;
    }
    /**
     * Time(n) when n is the number of then of the nodes
     * Space(1) cause we dont make new sets
     * checks if the the number given by the user is inside the set 
     * @param int num  is the number given by the user
     * @return true or false if the number is inside the set
     */

    public boolean isMember (int num){

        if(isEmpty())
        {return false;}
        IntNode temp1 = _head;       
        while((temp1!= null)){ //running until it finds 
            if(num == temp1.getValue())
                return true;
            temp1= temp1.getNext();}

        return false;
    }
    /**
     * Time(N) when n is the number of nodes in the set
     * space(1) we dont use new space
     * 
     * Basic Equals method
     * @param other (the set that we are looking the compare)
     * @return true if equals fasle if not
     */

    public boolean equals (Set other)
    {
        IntNode temp = this._head;
        IntNode temp2 = other._head;

        if((temp == null && temp2 != null) || (temp != null && temp2 == null))
            return false;

        while(temp != null && temp2 != null)
        {
            if(temp.getValue() != temp2.getValue()) {
                return false;}            
            temp = temp.getNext();
            temp2 = temp2.getNext();}
        return true;}
/**
 * time o(n) its an counter it needs to run all the nodes (n when n is the number of nodes)
 * space o (1) no new space was used
 * 
 * basic counter method to track the number of elements in the nodes
 * @return int  counter the number of the nodes
 */
        
    public int numOfElements ()
    {   
        IntNode temp1 = _head;
        int counter=1;
        if(isEmpty())
            return 0;
        else
            while(temp1.getNext()!=null){
                temp1 = temp1.getNext();
                counter++;}
        return counter;

    }
/**
 * Time(n) when n is the number of elements in a 
 * space(1) no new space
 * 
 * Subset returns True if a is inside b (b can be bigger but the point is that it should fit inside ) but a cant 
 * @param the other set
 * @return true if a is sub set of b 
 * 
 * 
 */
    
    public boolean subSet (Set other)
    {
        IntNode temp1 = _head;
        IntNode temp2 = other._head;
        if(temp1 == null && temp2!=null){//
            return false;    
        }
        if(temp1 == null && temp2==null){//if both are empty it returns its indeed an subSet Because they are equaling
            return true;
        }

        while(temp1 != null && temp2 != null){
            if(temp1.getValue() == temp2.getValue()){
                temp1=temp1.getNext();
                temp2=temp2.getNext();}
            else if(temp1.getValue() > temp2.getValue())//if its true it means that temp 1 isnt inside temp 2 completly which is the definition of subSet in math
            {return false;}
            else temp1 = temp1.getNext(); // keeps the temp 1 going until its null
        }return true;    }
/**Time(n) when n is the number of nodes
 * Space(1) no new space
 * 
 *Remove from set removes the number given by the user
 *@param x the number the user wants to delete
 */
    public void removeFromSet (int x)
    {   
        IntNode temp = _head;
        IntNode prev = null;
        while (temp!=null) {
            if (temp.getValue()==x) {
                if (prev!= null)
                    prev.setNext(temp.getNext());
                else
                    _head = temp.getNext();
                return;
            }
            prev = temp;
            temp = temp.getNext();
        }
        return;
    }
/**
 * time(n) when n is then number of nodes
 * space(1)
 * basic toString method
 * @return nodeStr a string of all the node
 * 
 */
    public String toString()
    {
        String nodeStr = "{";
        IntNode temp = _head;
        String empty = "{}";
        if(isEmpty()){return empty;}
        if(temp != null) {
            nodeStr += temp.getValue();

            temp = temp.getNext();
            while(temp != null) {
                nodeStr +=  "," + temp.getValue() ;
                temp = temp.getNext();
            }
        }
        nodeStr += "}";
        return nodeStr;

    }
    /**
     * InterSection returns new set with the numbers that are the same in both sets
     * @param other (other set)
     * @return set inter which is the new set with the added numbers after intersection
     * Time(Temp+OtherTemp) when temp is the numbers of nodes in temp and other temp is the number of nodes in other temp
     * space(n) we added new set
     * 
     */

    public Set intersection (Set other)
    {
        IntNode temp = _head;
        IntNode otherTemp = other._head;
        Set inter= new Set();
        if(temp==null||otherTemp==null){return inter;}

        while(temp!=null&&otherTemp!=null){
            if(temp.getValue()==otherTemp.getValue()){
                inter.tailCheck(inter,temp.getValue());
                
                temp=temp.getNext();
                otherTemp=otherTemp.getNext();
            }
            else if(temp.getValue() < otherTemp.getValue()){ // found an value that isnt equals which means this value is not the right value
                temp= temp.getNext();// advancing only temp to check if this item might be the next one
            }
            else // if after temp was pushed foward and still not equal and found the oppsite we advance otherTemp
            {
                otherTemp = otherTemp.getNext();
            }

            
        }
        return inter;

    }
/**
 * Set union is a method that returns the collections of numbers (no duplicates)
 * @param Other set the set is compared to
 * @return uni the new set which contains both collections of numbers 
 * * Time(Temp+OtherTemp) when temp is the numbers of nodes in temp and other temp is the number of nodes in other temp
     * space(n) we added new set
 */
    
    public Set union (Set other)
    {
        IntNode temp = _head;
        IntNode otherTemp = other._head;

        Set uni = new Set();
        if(temp==null){ // Main list is empty
            while(otherTemp != null){
                uni.tailCheck(uni,otherTemp.getValue());
                otherTemp=otherTemp.getNext();}return uni;
        }
        if(otherTemp==null){// secondary list empty
            while(temp != null){
                uni.tailCheck(uni,temp.getValue());
                temp=temp.getNext();}
            return uni;

        }
        if(temp != null && otherTemp != null){ // both lists are empty
            while(temp!=null||otherTemp!=null){
                
                if(temp!=null&&otherTemp==null){ //checks if one is null and one not and adding the last memeber
                    uni.tailCheck(uni,temp.getValue());
                    return uni;
                }
                  if(temp==null&&otherTemp!=null){//checks if one is null and one not and adding the last memeber
                    uni.tailCheck(uni,otherTemp.getValue());
                    return uni;}
                
                if(temp.getValue()==otherTemp.getValue()){
                    uni.tailCheck(uni,temp.getValue());

                    temp=temp.getNext();

                    otherTemp=otherTemp.getNext();

                }
                else if(temp.getValue() > otherTemp.getValue()){                    
                    uni.tailCheck(uni,otherTemp.getValue());
                    otherTemp=otherTemp.getNext();
                }else{//when (temp.getValue() < otherTemp.getValue())
                    uni.tailCheck(uni,temp.getValue());
                    temp=temp.getNext();
                }

            }
        }

        return uni;
    }
    /**
     * checks the differnec between the sets
 *  Time(Temp+OtherTemp) when temp is the numbers of nodes in temp and other temp is the number of nodes in other temp
  * space(n) we added new set
  * @param other set is the other set which we compare the main one to
  * @return difference set whcih is new set that containts the difference
  * 
    **/
    public Set difference (Set other)
    {
        IntNode temp = _head;
        IntNode otherTemp = other._head;

        Set difference = new Set();
        if(temp==null){return difference;}
        while(temp != null)// because temp is the main set and othertemp is second set Which means it less importent cause it wants the diffrence between main and second not second and main its like temp-othertemp
        {
            if(otherTemp == null){// Because it null it means that temp - null is till temp it should return all the values of temp
                difference.tailCheck(difference,temp.getValue());
                temp=temp.getNext();
                // keeps the temp going beaucse it needs to run on top of everything                       
            }
            else if(temp.getValue()==otherTemp.getValue()){ // equaling is good but it doesnt add to difference so we are advancing the temps 
                temp = temp.getNext();
                otherTemp = otherTemp.getNext();
            }
            else if(temp.getValue() < otherTemp.getValue()){// Here we get the diffrence which means we need to add it to the Difference node !
                difference.tailCheck(difference,temp.getValue());// adding to the node
                temp = temp.getNext();//advancing
            }
            else
            {
                otherTemp = otherTemp.getNext();
            } // otherTemp needs to get advance in order to keep on going with the node
        }

        return difference;
    }
}

