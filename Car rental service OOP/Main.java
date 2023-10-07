
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
  public static void main(String[] args) {
   Rent rt5 = new Rent("Bob", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));
   Rent rt6 = new Rent("Bob", new Car (1234567, 'A', "Opel", false), new Date(4,2,2020), new Date(8,2,2020));
   System.out.println("\ntesting accuracy of overlap method");
   rt6.setPickDate(new Date(1,2,2020));
   Rent rt7 = rt6.overlap(rt5);
   System.out.println("\t" +rt7);
   System.out.println("\t^ this should be: Name:Bob From:01/02/2020 To:08/02/2020 Type:A Days:7 Price:630");
   rt5.setReturnDate(new Date(7,2,2020));
   rt5.setPickDate(new Date(5,2,2020));
   rt7 = rt6.overlap(rt5);
   System.out.println("\t" + rt7);
   System.out.println("\t^ this should be: Name:Bob From:01/02/2020 To:08/02/2020 Type:A Days:7 Price:630");

   System.out.println("\n********** Test Rent - Finished **********\n");


}


}
