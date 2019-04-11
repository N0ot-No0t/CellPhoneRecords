import java.util.Random;
import java.util.Scanner;

public class CellPhone {

    private long serialNum; //serial number of the cell phone
    private String brand; //cell phone brand
    private int year; //year of fabrication of the cell phone
    private double price; //price of the cell phone on the market

    private static Scanner read = new Scanner(System.in);

    private Random r = new Random();


    /**
     * Parameterized Constructor
     * @param serialNum cell phone serial number
     * @param brand the brand of the cell phone
     * @param year the year the cell phone was produces
     * @param price the price of the cell phone
     */
    public CellPhone(long serialNum, String brand, int year, double price){

        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;

    }

    /**
     * Default Constructor
     */
    public CellPhone(){

        this.serialNum = 0;
        this.brand = "";
        this.year = 0;
        this.price = 0;

    }

    /**
     * Copy Constructor
     *
     * @param cellPhone the cell phone object the copy will derive from
     * @param serialNum new serial number that will be given by the user
     */
    public CellPhone(CellPhone cellPhone, long serialNum){

        this.serialNum = serialNum;
        this.brand = cellPhone.brand;
        this.year = cellPhone.year;
        this.price = cellPhone.price;

    }

    /**
     * clone method that will replicate an existing cell phone with a new one and with another serial number given by the user.
     * <p>
     * But this method will be modified to give random 7 digit serial numbers to cell phones
     *
     * @return the copy of the cell phone
     */
    public CellPhone clone() {

        //System.out.println("Please input new serial number for this copy");
        //System.out.print("> ");

        //long serial = read.nextLong();

        //1000000 to 9999999

        return new CellPhone(this, r.nextInt(8999999) + 1000000);

    }

    /**
     * Accessor method for the serial number of the cell phone
     * @return the serial number
     */
    public long getSerialNum() {
        return serialNum;
    }

    /**
     * Mutator method for the serial number of the cell phone
     * @param serialNum serial number of the cell phone
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * Accessor method for the brand name of the cell phone
     * @return the brand name of the cell phone
     */
    public String getBrand() {
        return brand;
    }

    /**
     *  Mutator method for the brand name of the cell phone
     * @param brand the brand name of the cell phone
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Accessor method for the year of fabrication of the cell phone
     * @return the year of fabrication of the cell phone
     */
    public int getYear() {
        return year;
    }

    /**
     * Mutator method for the year of fabrication of the cell phone
     * @param year the year of fabrication of the cell phone
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Accessor method for the price of the cell phone
     * @return the price of the cell phone
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mutator method for the price of the cell phone
     * @param price the price of the cell phone
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * equals method to compare 2 cell phone and see if they have the same year of fabrication, same price on the market and same brand name
     * @param o object that will be later cast into a cell phone if it is one
     * @return true if the 2 objects are the same or false if they're not
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CellPhone cellPhone = (CellPhone) o;
        return (year == cellPhone.year &&
                price == cellPhone.getPrice() &&
                brand.equals(cellPhone.brand));
    }

    /**
     * toString method to display a CellPhone object
     * @return all the attributes of the specified object
     */
    @Override
    public String toString() {
        return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "]");
    }
}
