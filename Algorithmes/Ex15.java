/**
 * IntNode is a class that makes a node system which is linked by aliasing its responsable for everything and helps setclass
 *  * @author (Victor Aviv kotliar)
 * @version (1 )
 * @Tz (324133982)
 * 
 * Int _value the the value of the node
 * intNode next is the nextNode of Node
 */



public class IntNode
{
private int _value;
private IntNode _next;
/**
 * IntNode is a method that makes connection beween the Value the node and its Next
 * @param int V is the value of the node which we get when using getNext()
 * @param IntNode n is and Node type parametar which represents the Next node in line
 */
public IntNode(int v, IntNode n)
{
_value = v;
_next = n;
}
/**
 * Basic get method which returns Value
 * @return Value which is the value of then node
 */
public int getValue() {
return _value;
}
/**
 * basic get method which returns the Next node in line
 * @return the next linked node
 */
public IntNode getNext() {
return _next;
}
/**
 * a setter method which sets value of the certing node to be its param value
 * @param V is the value that the user inputed and wanted to change the value of the node
 */
public void setValue(int v) {
_value = v;
}
/**
 * a setter method which sets the next node in line after the node given by the input of the user
 * @param IntNode n is the next node to the one this method used on
 */
public void setNext(IntNode n) {
_next = n;
}
}