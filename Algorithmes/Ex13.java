
/**
 * Write a description of class alternating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex13
{
    // instance variables - replace the example below with your own
    public static int alternating (String s){
        int alternatives=0; 
        for(int i =0 ; i>s.length()-1;i++){
        if(s.charAt(i) == 0 && s.charAt(i++) == 0)
        alternatives++;
        if(s.charAt(i) == 1 && s.charAt(i++) == 1)
        alternatives++;
        }
        
        
        
        
        return alternatives;
    }

    private static int f (int[]a, int low, int high){
        int res = 0;
        for (int i=low; i<=high; i++) // runs on the lowest number untill the highest number edds every a with the index of I to the res
            res += a[i];
        return res;

    }

    public static int what (int []a){
        int temp = 0;
        for (int i = 0; i<a.length;i++){ // runs on i
            for (int j=i; j<a.length; j++){ // runs on j
                int c = f(a,i,j); // runs on f
                if(c%2 == 0) //checks if its even number
                {
                    if (j-i+1> temp){
                        temp = j-i+1;
                    }

                }

            }
        }
        return temp;
    }

    public static boolean isWay(int[] a){
        int i = 0;
        return isWay(a,i);
    }

    private static boolean isWay(int[] a ,int i){
        int temp;
        if(i == a.length-1){return true;}
        if(i % 2 == 0){
            if(i+a[i] < a.length-1){        
                temp = a[i];
                a[i] = 0;
                return isWay(a,i+temp);}
            else if(i+a[i] > a.length-1){return false;}
        }else if (i % 2 == 1){
            if(i-a[i] < a.length-1 && i-a[i] >0){
                temp = a[i];
                a[i] = 0;    
                return isWay(a,i-a[i]);}
        }
        return false;} 

    public static int prince(int[][] drm, int i, int j){
        return prince(drm,0,0,0,0);
    }
    private static int prince(int[][] drm, int i, int j, int count , int lowScore){
        return 0;
    
    }
}
