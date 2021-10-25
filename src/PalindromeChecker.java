
import java.util.Scanner;

public class PalindromeChecker {
    
    public PalindromeChecker(){
        
    }


    public static boolean isPalindromeR(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length() - 1)){
            return isPalindromeR(s.substring(1, s.length() - 1));
        }
        return false;
    }
    
    public static boolean isPalindromeL(String s){

        if(s.length() == 0){
            return true;
        }
        int headIndex = 0;
        int tailIndex = s.length() - 1;

        while(headIndex > tailIndex){
            if(s.charAt(headIndex) != s.charAt(tailIndex)){
                return false;
            }
        }

        return true;

    }
}