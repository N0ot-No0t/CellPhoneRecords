import java.util.Scanner;

public class CellPhone {

    private long serialNum;
    private String brand;
    private int year;
    private double price;

    private static Scanner read = new Scanner(System.in);


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

    public CellPhone clone() {

        System.out.println("Please input new serial number for this copy");
        System.out.print("> ");

        long serial = read.nextLong();

        System.out.println(serial);

        return new CellPhone(this, serial);

    }


    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CellPhone cellPhone = (CellPhone) o;
        return (year == cellPhone.year &&
                price == cellPhone.getPrice() &&
                brand.equals(cellPhone.brand));
    }

//    @Override
//    public String toString() {
//        return "CellPhone" +
//                "\n Serial Number: " + serialNum +
//                "\n Brand: " + brand +
//                "\n Year: " + year +
//                "\n Price: " + price;
//    }

    @Override
    public String toString() {
        return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "]");
    }
}
