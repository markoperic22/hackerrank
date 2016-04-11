import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheMaximumSubArray {
   /**
	 * Main metoda koja čita input i za svaki array poziva metodu calculate(arr)
     *
	 */
   public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        
        for (int i=0;i<testCaseNum;i++) {
            int size = sc.nextInt();
            
            int[] arr = new int[size];
            for(int j=0;j<size;j++) {
                arr[j] = sc.nextInt();
            }
            calculate(arr);
        }
                
    }
    
    /**
     * Metoda riješava problem prema Kadanovom algoritmu. Radi se jedan prolaz kroz dobiveno polje 
     * u kojem tražimo subarray sa najvećom sumom. 
     * Postavio sam pretpostavku da nema pozitivnih brojeva kako bi se u takvom slučaju
     * mogao naći najveći negativni broj. U slučaju da se naiđe na pozitivni broj, stanje zastavice će se
     * promijeniti i preskočiti će se izvršenje koda za negativne brojeve.
     *
	 */
    public static void calculate(int[] arr) {
        int cumSum = 0;
        int conMax = 0;
        int nonConMax = 0;
        
        int startIndex = 0;
        int endIndex = 0;        
        boolean hasPositives = false;
        int maxNegative = -10000;
        
        for (int i=0; i < arr.length; i++) {            
            cumSum += arr[i];
            if (arr[i] >= 0) {
                nonConMax += arr[i];
                hasPositives = true;
            } else if (arr[i] > maxNegative) {
                maxNegative = arr[i];
            }
            
            if (cumSum > conMax) {
                conMax = cumSum;
                endIndex = i;                
            } else if (cumSum < 0){
                startIndex = i+1;
                cumSum = 0;
            }
            
        }
        
         if (!hasPositives) {
            conMax = maxNegative;
            nonConMax = maxNegative;
         }
        
       System.out.println(conMax + " " + nonConMax);
        
    }
}