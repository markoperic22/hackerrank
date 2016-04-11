import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    /**
     * Main metoda koja čita stringove i poziva metodu checkString(item)
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); 
        
        while (sc.hasNextLine()) {  
            String item = sc.nextLine();
            if (!item.isEmpty()) {
                //System.out.println("ITEM:" + item);
                checkString(item);
            }            
        }        
    }
    
     /**
      * Metoda prima uneseni string, radi reverzni string od originala. For petljom se pomičemo po stringu i uspoređujemo razliku 
      * susjedna dva elementa u originalnom i reverznom stringu. Pretpostavka je na početku da je razlika ista, tj "Funny",
      * pa čim naiđemo na prvi slučaj da to nije tako, prekidamo petlju. Na kraju radimo provjeru zastavice je li true ili false i
      * prema tome ispisujemo prigodnu poruku.
      * @param s 
      */
    public static void checkString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String rev = sb.reverse().toString();
        boolean isFunny = true;
        
        for (int i=0; i < s.length()-1; i++) {
            if(Math.abs((int)s.charAt(i) - (int)s.charAt(i+1)) != Math.abs((int)rev.charAt(i) - (int)rev.charAt(i+1))) {
                isFunny = false;
                break;
            }
        }
        
        if (isFunny) {
            System.out.println("Funny");
        } else {
            System.out.println("Not Funny");
        }
    }
    
}
