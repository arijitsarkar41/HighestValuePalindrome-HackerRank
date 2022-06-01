import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) 
    {//s=092282, n=6, k=3
    	
    	   char palin[] = s.toCharArray(); 
           String ans = ""; 
           // Iinitialize l and r by leftmost and  
           // rightmost ends  
           int l = 0; 
           int r = s.length() - 1; 
     
           // first try to make String palindrome  
           while (l < r) { 
               // Replace left and right character by  
               // maximum of both  
               if (s.charAt(l) != s.charAt(r)) { 
                   palin[l] = palin[r] = (char) Math.max(s.charAt(l), 
                                             s.charAt(r)); 
                   k--; 
               } 
               l++; 
               r--; 
           } 
     
           // If k is negative then we can't make  
           // String palindrome  
           if (k < 0) { 
               return "-1"; 
           } 
     
           l = 0; 
           r = s.length() - 1; 
     
           while (l <= r) { 
               // At mid character, if K>0 then change  
               // it to 9  
               if (l == r) { 
                   if (k > 0) { 
                       palin[l] = '9'; 
                   } 
               } 
     
               // If character at lth (same as rth) is  
               // less than 9  
               if (palin[l] < '9') { 
                   /* If none of them is changed in the  
               previous loop then subtract 2 from K  
               and convert both to 9 */
                   if (k >= 2 && palin[l] == s.charAt(l) 
                           && palin[r] == s.charAt(r)) { 
                       k -= 2; 
                       palin[l] = palin[r] = '9'; 
                   } /* If one of them is changed in the previous  
                   loop then subtract 1 from K (1 more is  
                   subtracted already) and make them 9 */ 
                  else if (k >= 1 && (palin[l] != s.charAt(l) 
                           || palin[r] != s.charAt(r))) { 
                       k--; 
                       palin[l] = palin[r] = '9'; 
                   } 
               } 
               l++; 
               r--; 
           } 
           for(int i = 0;i<palin.length;i++) 
               ans+=palin[i]; 
           return ans; 
       }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
