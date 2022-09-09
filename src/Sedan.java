public class Sedan extends Vehicle{

    public Sedan(String color, String vinNumber, String model, int year, double volume) {
        super(color, vinNumber, model, year, volume);
        this.price = 100;
    }

    @Override
    public double GetPrice(CustomerSlip slip) {
        return this.price * slip.GetHours();
    }
}




