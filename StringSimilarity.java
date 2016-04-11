import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringSimilarity {
	
    static int count; 
    /**
     * Metoda koja dobiveni string pretvara u polje znakova i za svaki sufiks, uspoređuje ga
     * slovo po slovo sa originalom. Sve dok su slova u originalu i sufiksu ista, brojač se povećava, a 
     * u suprotnome petlja se prekida i proces se ponavlja za sljedeći sufiks. Rješenje je iz prve
	 * prošlo 50 posto testova, a nakon toga sam prebacio string u polje char-ova i promijenio na i=1 
	 * kako bi ignorirali prvi prolazak kroz petlju jer za njega uvijek znamo da će proći jer je 
	 * prvi sufiks uvijek jednak cijelom stringu, prema tome mogu definirati count = arr.length; odmah na početku.
	 * Nakon dodatnih promjena rješenje je prošlo 10/12 testova u vremenskom roku, zadnja 2 nisam uspio svladati (timeout).
     * @param word - string dobiven preko inputa
     */
    static void countSimilarities(String word){    
       
        char[] arr = word.toCharArray();  
        count = arr.length;
        for(int i=1;i<word.length();i++){
            for(int j=i;j<word.length();j++){
                if(arr[j-i] != arr[j]) {
                    break;
                } else {
                    count++;
                }
                    
            }
        }
        System.out.println(count);
    
}
        
    /**
     *	Metoda čita input i za svaki test case (string) poziva metodu stringSimilarity 
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int testCaseNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i<testCaseNum; i++) {
            String a = in.nextLine();
            countSimilarities(a);            
        }
    }
}
