
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CellListUtilization {

    public static void main(String[] args) {

        CellList cl1 = new CellList(), cl2, cl3 = new CellList(); //3 cell lists used for testing (2 will be a deep copy of 1 and 3 will test functions on an empty list)
        CellList testcl2 = null;
        Scanner sc = null;
        Scanner userInput = new Scanner(System.in);


        try {

            sc = new Scanner(new FileInputStream("resources/Cell_Info.txt")); //path to the file

            while (sc.hasNextLine()) { //this loop goes through the cell phones file and adds them all to the cell list

                long serialNum = sc.nextLong();
                String brand = sc.next();
                double price = sc.nextDouble();
                int year = sc.nextInt();

                if (!cl1.contains(serialNum)) {  //checks if a cell phone with the same serial number doesn't already exist
                    cl1.addToStart(new CellPhone(serialNum, brand, year, price));
                }


            }

        } catch (FileNotFoundException fnfe) {

            System.out.println("Could not open file. Shutting down ...."); //verifies the file can be opened, shuts down otherwise
            System.exit(-1);

        }

        sc.close(); //scanner is closed

        System.out.println("***CL1 - Before***");
        cl1.showContents();

        System.out.println("***CL2 - Before***");
        cl2 = cl1.clone();
        cl2.showContents();

        System.out.println("***See if CL1 is equal to CL2: " + cl1.equals(testcl2) + "***\n");

        System.out.println("***CL1 - After Insertion at Index ***");
        cl1.insertAtIndex(new CellPhone(123456, "TestCoInsert", 2019, 100), 21);
        cl1.showContents();

        System.out.println("***CL2 - After changing CL1 (should remain the same as it is a deep copy)***");
        //cl2 = cl1.clone();
        cl2.showContents();

        System.out.println("***CL3 - After adding to start***");
        cl3.addToStart(new CellPhone(123456, "TestCoStart", 2019, 100));
        cl3.showContents();

        System.out.println("***CL2 - After Replacing***");
        cl2.replaceAtIndex(new CellPhone(999999, "TestCoReplace", 2000, 999), 0);
        cl2.showContents();

        System.out.println("***CL2 - After Deletion From Start***");
        cl2.deleteFromStart();
        cl2.showContents();

        System.out.println("***CL2 - After Deletion At Index ***");
        cl2.deleteFromIndex(21);
        cl2.showContents();

        System.out.println("*** CL3 - Deletion of its only element ***");
        cl3.deleteFromStart();
        cl3.showContents();

        cl3.deleteFromStart(); //should trigger the special case of an empty list

        CellPhone cp1 = new CellPhone(123456, "TestCo1", 2010, 500);
        CellPhone cp2; //testing the clone method for a single cell phone
        cp2 = cp1.clone();

        System.out.println(cp2);


        System.out.println("Enter a serial number to be searched in the list"); //testing the find method

        System.out.println(cl1.find(userInput.nextLong()).getCellPhone());

    }
}
