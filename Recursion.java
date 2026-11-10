import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion{

    public static long factorialR(long value){
        // 0! = 1
        if(value == 0) return 1;
        // multiplies the value by the factorial of the value - 1 (value - 1 * (value - 2)!, etc.)
        return value * factorialR((value - 1));
    }
    
    public static boolean palindromeR(String str, int start, int end){
        // 1-char strings are always palindromes
        if(str.length() <= 1) return true;
        // checks if the characters at opposite values are equal
        if(str.charAt(start) != str.charAt(end)) return false;
        // checks if the start and end indexes are equal (in case of odd-numbered strings)
        // OR if the start and one over from the end indexes are equal (in case of even-numbered strings)
        if(((start == end) || (start == (end - 1))) && (str.charAt(start) == str.charAt(end))) return true;
        // iterates and sets values over
        return palindromeR(str, (start + 1), (end - 1));
    }

    public static void reverseStringR(PrintWriter outputWriter, String str){
        // prints single characters
        if(str.length() < 1) outputWriter.print(str);
        else{
            reverseStringR(outputWriter, str.substring(1));
            outputWriter.print(str.charAt(0));
        }
    }

    public static boolean isPrimeR(int value, int n){
        if(value % n == 0) return false;
        if(n * n > value) return true;
        else return isPrimeR(value, (n + 1));
    }
 
    public static int sumR(PrintWriter outputWriter, ArrayList<Integer> nums, int pos){
        if(nums.size() != pos) return sumR(outputWriter, nums, pos + 1) + nums.get(pos);
        return 0;
    }
}

   