import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PseudoIsomorphicSubstrings {

    /**
     * Main metoda koja prima string iz inputa, kreira sve prefikse tog stringa i za svaki prefiks definira set znakova,
     * npr za prefiks 'ab' set znakova {a,ab,b} (linija 25-27). Zatim, za svaki znak iz seta provjera je li izomorfan
     * sa nekim od već dodanih elemenata. Ukoliko nije, dodaje znak u listu. Na kraju izvršavanja ispisuje broj elemenata u listi.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
                
        boolean ok;
        String line = "";
        List<String> list = new ArrayList<>();
        
        for(int m=1; m <= word.length();m++) {
            line = word.substring(0, m);
        
            for (int i=0; i<= line.length(); i++) {
                for (int j=i+1; j <= line.length(); j++) {
                    String item = line.substring(i,j);
                    
                    if (list.isEmpty()) {
                        list.add(item);
                    } else {
                        ok = true;
                        for(String s : list) {                        
                            if(isIsomorphic(s, item)) {
                                ok = false;
                                break;
                            }                        
                        }
                        if (ok == true) {                        
                            list.add(item);
                        } 
                    }
                }  
            }
            System.out.println(list.size());
            
        }
        
   }
                
    /**
     * Metoda koja prima dva parametra, prebacuje ih u polje znakova (zbog bržeg pretraživanja nego string.charAt(i)).
     * Ukoliko duljina stringova nije ista, prekida se petlja. Dvije mape drže mapiranja znakova za svaki od stringova.
     * Npr. ako je trenutno samo znak 'a' u listi i pokušavamo ubaciti slovo 'b', na slovo 'a' ćemo mapirati slovo 'b'.
     * Dva slova ne mogu biti mapirana na isto slovo jer su tada stringovi izomorfni. Metoda vraća ishod analize, true ili false.
     * @param target - već dodani string unutar liste
     * @param current - kandidat za listu
     * @return - true ili false
     */
    public static boolean isIsomorphic(String target, String current) {
        char[] t = target.toCharArray();
        char[] c = current.toCharArray();
        
        if (target.length() != current.length()) {
            return false;
        } 
        
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        
        for (int i=0;i<t.length;i++) {
                        
            if (map1.containsKey(t[i])) {
                if (map1.get(t[i]) != c[i]) {
                    return false;
                }
            } else {
                map1.put(t[i], c[i]);
            }
            
            if (map2.containsKey(c[i])) {
                if (map2.get(c[i]) != t[i]) {
                    return false;
                }
            } else {
                map2.put(c[i], t[i]);
            }
            
        }
        return true;
                
        
    }
    
}