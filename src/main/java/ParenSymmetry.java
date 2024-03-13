package src.main.java;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ParenSymmetry {


    public Boolean isBalanced(String stringToTest) {
        // implement this method
        int openBraceCounter = 0;
        int closedBraceCounter = 0;
        char openBrace = '(';
        char closingBrace= ')';

        char[] chararray = stringToTest.toCharArray();

        for (int i = 0; i < chararray.length; i++){
            if (chararray[i] == openBrace){
                openBraceCounter++;

            } else if (chararray[i] == closingBrace) {
                closedBraceCounter++;
            }

        }if (openBraceCounter == closedBraceCounter){
            return true;
        }else{
        return false;
        }
    }

    private void checkFile(String filename) throws IOException {
        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced

       BufferedReader br = new BufferedReader(new FileReader(filename));
       String line;
       while((line = br.readLine()) != null){
           isBalanced(line);
           System.out.println(line);
       }
       br.close();

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
