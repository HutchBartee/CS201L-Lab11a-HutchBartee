import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//comment name, lecture & lab section
//Hutch Bartee

class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

        System.out.println("Starting Recursion Program");
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter outWriter = new PrintWriter(new FileWriter(outputFile));
            PrintWriter errWriter = new PrintWriter(new FileWriter(errorFile))){
            // read lines
            String l;
            while((l = reader.readLine()) != null){
                // split string
                String[] tokens = l.split(",");
                String funInp = tokens[0];
                String valInp = tokens[1];
                boolean digitCheck = false;
                ArrayList<Integer> sumInts = new ArrayList<Integer>();
                // check if input is single digits
                if(funInp.equalsIgnoreCase("factorialR") || funInp.equalsIgnoreCase("isPrimeR")){
                    digitCheck = isDigits(valInp);
                    if(digitCheck){
                        if(funInp.equalsIgnoreCase("factorialR")){
                            outWriter.print("The factorial of " + valInp + " is ");
                            outWriter.println(Recursion.factorialR(Integer.parseInt(valInp)) + "\n");
                        }
                        else if(funInp.equalsIgnoreCase("isPrimeR")){
                            boolean isPrime = Recursion.isPrimeR(Integer.parseInt(valInp),2);
                            outWriter.print("The value " + valInp + " is ");
                            if(isPrime) outWriter.println("prime\n");
                            else outWriter.println("not prime\n");
                        }
                        else{
                            System.out.println("How did this even happen?");
                        }
                    }
                    else errWriter.println(l + " Error: Value input " + valInp + " is not an integer.\n");
                }
                else if(funInp.equalsIgnoreCase("sumR")){
                    boolean isAllDigits = true;
                    for(int i = 1; i < tokens.length; i++){
                        digitCheck = isDigits(tokens[i]);
                        if(digitCheck){
                            sumInts.add(Integer.parseInt(tokens[i]));
                        }
                        else{
                            errWriter.println(l + " Error: " + tokens[i] + " is not an integer.\n");
                            isAllDigits = false;
                        }
                    }
                    if(isAllDigits){
                        outWriter.print("The sum of values: ");
                        for(int j : sumInts) outWriter.print(j + " ");
                        outWriter.print("is ");
                        outWriter.println(Recursion.sumR(outWriter, sumInts, 0) + "\n");
                    }
                }
                else if(funInp.equalsIgnoreCase("palindromeR")){
                    boolean isPal = Recursion.palindromeR(valInp, 0, (valInp.length() - 1));
                    outWriter.print("The string " + valInp + " is ");
                    if(isPal) outWriter.println("a palindrome\n");
                    else outWriter.println("not a palindrome\n");
                }
                else if(funInp.equalsIgnoreCase("reverseStringR")){
                    outWriter.print("The string " + valInp + " in reverse is: ");
                    Recursion.reverseStringR(outWriter, valInp);
                    outWriter.print("\n\n");
                }
                else errWriter.println(l + " Error: Invalid function input.\n");
            }
            System.out.println("Recursion complete!");
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean isDigits(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
