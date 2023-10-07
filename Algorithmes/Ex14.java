class Ex14{

    // answers for question number oneis 3,5

    /**
     * @param m the arry given by the user which returns true in What
     * @param val the goal of the search
     * @return either true or false based if its found the val
     */

    public static boolean findValWhat (int [][] m, int val) //O(n) because I cut the arry in 2 halfs backside and front side . time complexity of (1_
    {
        int r = 0; // r means Row
        int c = m[r].length-1; // C means Collum it starts with .length-- because arrys starts from [0]
        while (r < m.length && c >= 0) {
            if (m[r][c]==(val)) {
                return true;
            }
            //checks if the numbe val is infront
            if (m[r][c] < val) {
                r++;
            }
            // else its either on the backside or its not in the arry
            else {
                c--;
            }
        }
        return false;
    }

    /**
     * @param m the arry given by the user which returns true in test
     * @param val the goal of the search
     * @return either true or false based if its found the val
     */

         public static boolean findValTest (int [][] m, int val){  //O(n) and time complxity of (1) 
        int row = m.length-1; // represnts the row and starts at the top(or the bottom depends on how u look on it)
        int col = 0;// represnets the col and goes foward
        while (m[row][col]>val)
        {row--;
        if(row==-1){return false;}// makes sure to not get out of bounds
        
    }
        while(m[row][col]<val)
        {col++;
        
        if(col>m.length-1)
            return false;} // makes sure not to get out of bounds
        
        if(m[row][col] == val) // checks if its the value if its not it will return false
        return true;
    return false;
    }
        
        
    
    
 
    /**
     *
     * @param arr array that is being checked
     * @return return length of biggest subarray that is a flat squence
     */
    public static int longestFlatSequence (int[] arr){
        return lengthFlat(arr,0,1);// launches the recursion starts at 0 with counter of 1
    }

    /**
     * recursion method for the longestflatsequnce checks for the 3 recursion up down and just counting the numbers
     * @param arr array that is being checked
     * @param i the index of the arry while checking
     * @param counter The number of the sub arry
     * @return return length of biggest subarray that is a flat squence
     */
    public static int lengthFlat (int [] arr, int i,int counter){
        if(i==arr.length-1){ //checks if still in bounds (recursion stoping if end of array)
            return counter;
        }

        int up =lengthFlat(arr,i,arr[i],arr[i]+1); //checks if arr[i] and arr[i]+1
        int down = lengthFlat(arr,i,arr[i],arr[i]-1); //checks if arr[i] and arr[i]-1
        counter = Math.max(counter,Math.max(up,down));// decides between above under and counter

        return lengthFlat(arr,i+1,counter);
    }

    /**
     * the method returns the biggest counter if just going stright while up checks if the sub arry goes 123 and the down checks for sub arry 321
     * @param arr  checked array
     * @param index the arry at the moment
     * @param num first number arr[i]
     * @param num2 second number arr[i]
     * @return length of flat squence
     */
    private  static int lengthFlat(int[]arr,int i,int num,int num2){
        if(i==arr.length-1){ //its the stop if (if 
            return 1;//
        }
        if((arr[i]==num||arr[i]==num2)&&(arr[i+1]==num||arr[i+1]==num2)){ // the if checks if i and num1 or num 2 equals and also if i++ and num or num 2 are equals aswell
            return 1+lengthFlat(arr,i+1,num,num2);// launches the recursion again but now with I++
        }
        else{
            return 1; 
        }
    }

    
 
    /**
     * The method checks for the a sequnces of numbers in a row that are increasing 
     * @param a is the arry of the given method which checks if its increasing
     * @returns int the total count of numbers in a row that are increasing if the its 2 it will returns 2
     */

    public static int strictlyIncreasing (int[] a) // O(N) time of (1) when n is the arry size
    {
        int count = 0; // counts how much time 
        int total=0; // counts the total since it needs to be in a row if it gets intrupted it doesnt count
        for(int i = 1; i< a.length;i++){
            if (a[i] > a[i-1])
            {
                count++;
                total+=count;
            }
            else count=0;
        }return total;
    }

    /**
     * findMaximum checks the maximum path of 1s it can reach in given arry if it gets the -1 its game over if gets to 0 no points given
     * @param mat (the double arry given by the user)
     * @returns the maximum between both recursions
     * its and recursion method
     */

    public static int findMaximum(int[][] mat)
    {
        return findMaximum(mat,0,0);
    }

    /**
     * findMaximum the recursion 
     * @param mat the double arry given by the user
     * @param i is the y
     * @param j is the x
     * @returns in int the longest sequence of 1s by number
     * i can only go down
     * x can go side ways 
     * checks for the longest sequnce of 1s avoids -1s and gets zero points for 0s
     * returns -1 if the first number in the arry is -1
     * uses method mMax which checks which number is maximum like math.max
     * 
     */

    private static int findMaximum(int[][]mat,int i,int j)
    {
        if(mat[0][0] == -1)
            return -1;
        if(i== mat.length ||j<0||j>=mat[i].length||mat[i][j]==-1){// checks for out of bound plus it checks to make sure we dont land on -1 which is a trap
            return 0;}
        if(mat[i][j]== -1){return -1;}
        int recursion1=findMaximum(mat,i+1,j); // goes down
        int recursion2; // goes sideways depends on the next if its an odd number
        if(i%2==0)
        {recursion2=findMaximum(mat,i,j+1);}
        else{recursion2=findMaximum(mat,i,j-1);}
        return mMax(recursion1,recursion2)+mat[i][j];}

    /**
     * checks for the maximum like Math.max
     * @param a first number
     * @param b second number
     * @return int which one is bigger
     * 
     */
    private static int mMax(int a,int b)
    {
        if(a>b)
            return a;
        return b;
    }

}

