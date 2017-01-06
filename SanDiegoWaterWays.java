/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandiegowaterways;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author RPTA_Research
 */
public class SanDiegoWaterWays {

    private static Formatter output;
    private static Scanner input;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readWaterWayFile("NorthCoast.txt");
        createEnumFile("NorthCoast.java");
        closeWaterWayFile();
        closeFile();
    }

    // open file
    public static void openFile(String fName) {
        try {
            output = new Formatter(fName);
        } catch (SecurityException se) {
            System.err.println("File is write protected. Exiting program.");
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println("File not found. Exiting");
            System.exit(1);
        }
    }

    // close output file
    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }
    
    // precondition: file must be open
    // postcondition: writes common variables into the file
    public static void writeCommonVariables() {
        for(CommonVariables var : CommonVariables.values()) {
            output.format("%s%n", var);
        }
    }
    
    // Open a file containing the names and nummerical values of the water ways
    // precondition: the file exists
    public static void readWaterWayFile(String waterWayFile) {
        try {
            input = new Scanner(Paths.get(waterWayFile));
        } catch (IOException ioe) {
            System.err.println("Error opening file. Exiting.");
            System.exit(1);
        }
    }
    
    /* Create water enummeration file
     * precondition: 1) water way file is open
     *               2) output file is open
     * postcondition: water way file and ouput file needs to be closed
     */
    public static void createEnumFile(String fName) {
        openFile(fName);
        
        // Get the enum name from the file name
        int index = fName.indexOf(".");
        String enumName = fName.substring(0,index);
        
        output.format("%s%s%s%n", "public enum ", enumName, " {");
        try {
            while(input.hasNext()) {
                String strToWrite = parseString(input.nextLine());
                output.format("%s,%n", strToWrite);
            }
        } catch (IllegalStateException ise) {
            System.err.println("Error reading file. Exiting.");
            System.exit(1);
        }
        output.format("%s%s%n", enumName, "() {}");
        output.format("%s%n", "}");
    }
    
    // parse the string from from "String String (Num)" into "STRING_STRING (num)"
    public static String parseString(String str) {
        String strToReturn = str.replace(' ', '_');

        return strToReturn.toUpperCase();
    }

    // Close a waterway file
    // precondition: All the data has been read
    public static void closeWaterWayFile() {
        if(input != null) {
            input.close();
        }
    }
}
