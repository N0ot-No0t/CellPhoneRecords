public class CellPhone {

    long serialNum;
    String brand;
    int year;
    double price;


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

    public CellPhone(CellPhone cellPhone, long serialNum){

        this.serialNum = serialNum;
        this.brand = cellPhone.brand;
        this.year = cellPhone.year;
        this.price = cellPhone.price;

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
}
