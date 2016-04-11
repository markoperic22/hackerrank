import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class ArrayAndSimpleQueries {

    /**
     * Main metoda koja prima inpute i na temelju njih zove metodu shiftItems() prosljeđujući joj parametre.
     * @param args 
     */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        List<Integer> l = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i=0;i<N;i++) {
           l.add(sc.nextInt());                      
        }
        
        for (int i=0;i<M; i++) {
            int type = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();            
            list = shiftSubstrings(l, type, start, end);
            
        } 
        
        System.out.println(Math.abs(list.get(0) - list.get(list.size()-1)));
        
        for(int li : list) {
            System.out.print(li + " ");
        }
        
    }
    
    /**
     * Metoda koja prima 4 parametra i na temelju njih vrši izmjenu pozicija unutar liste. Koristim privremenu listu u koju
     * spremam definirani skup brojeva, zatim ga obrišem iz originala i ovisno o tipu prebacim sadržaj privremene liste na početak ili kraj 
     * originalne liste. Svjestan sam da ovo nije ni približno idealno rješenje i preporuka je koristiti stablo, međutim nisam stigao
     * implementirati rješenje na taj način. Ovo je ujedno i moj najlošiji zadatak koji sam ostavio za kraj i nisam ga uspio riješiti kako treba.
     * 
     * @param all - lista brojeva (integera)
     * @param type - tip 1 ili 2 (početak ili kraj liste)
     * @param start - početna pozicija skupa kojeg treba prebaciti
     * @param end - završni pozicija skupa kojeg treba prebaciti
     * @return - nova lista
     */
    public static List<Integer> shiftSubstrings(List<Integer> all, int type, int start, int end) {
        int[] temp = new int[end - start + 1];
        List<Integer> tmp = new ArrayList<Integer>();
        ListIterator<Integer> iter = all.listIterator();
        
        int i = 0; 
        while(iter.hasNext()) {
            int num = iter.next();
            i++;
            if (i>=start && i<=end) {
                tmp.add(num);                
            }
        }        
        all.removeAll(tmp);
        
        if (type == 1) {
            all.addAll(0, tmp);
            return all;
        } else {
            all.addAll(all.size(), tmp);
            return all;
        }
        
    }
}