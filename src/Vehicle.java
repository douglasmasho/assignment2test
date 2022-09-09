
public abstract class Vehicle {
    private String color;
    private String vinNumber;
    private String model;
    private int year;
    protected double price;
    private double volume;

    public Vehicle(String color, String vinNumber, String model, int year, double volume) {
        this.color = color;
        this.vinNumber = vinNumber;
        this.model = model;
        this.year = year;
        this.volume = volume;
    }
    public abstract double GetPrice(CustomerSlip slip);
    public String getColor() {
        return color;
    }
    public String getVin() {
        return vinNumber;
    }
    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
    public double getVolume() {
        return volume;
    }
}
