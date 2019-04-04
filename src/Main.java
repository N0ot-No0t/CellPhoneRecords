
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CellList cl1 = new CellList(), cl2 = new CellList(), cl3 = new CellList();
        Scanner sc = null;
        int nbOfInputs;
        Scanner userInput = new Scanner(System.in);

        //LinkedList<Integer> test = new LinkedList<>(); just for testing, makes it quick to go to the LinkedList java libraries

        try {

            sc = new Scanner(new FileInputStream("resources/Cell_Info.txt"));

            while (sc.hasNextLine()) {

                long serialNum = sc.nextLong();
                String brand = sc.next();
                double price = sc.nextDouble();
                int year = sc.nextInt();

                cl1.addToStart(new CellPhone(serialNum, brand, year, price));

            }

        } catch (FileNotFoundException fnfe) {

            System.out.println("Could not open file. Shutting down ....");
            System.exit(-1);

        }

        sc.close();

        System.out.println("***CL1 - Before***");
        cl1.showContents();

        System.out.println("***CL2 - Before***");
        cl2 = cl1.clone();
        cl2.showContents();

        System.out.println("***See if CL1 is equal to CL2: " + cl1.equals(cl2) + "***\n");

        System.out.println("***CL1 - After Insertion at Index ***");
        cl1.insertAtIndex(new CellPhone(123456, "TestCoInsert", 2019, 100), 25);
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
        cl2.deleteFromIndex(24);
        cl2.showContents();

        System.out.println("*** CL3 - Deletion of its only element");
        cl3.deleteFromStart();
        cl3.showContents();

        cl3.deleteFromStart();

        CellPhone cp1 = new CellPhone(123456, "TestCo1", 2010, 500);
        CellPhone cp2 = new CellPhone(cp1, 12312421);
        //cp2.clone();

        System.out.println(cp2);


        System.out.println("Enter a serial number to be searched in the list");

        System.out.println(cl1.find(userInput.nextLong()).getCellPhone());

    }
}
