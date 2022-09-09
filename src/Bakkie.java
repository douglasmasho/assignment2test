public class Bakkie extends Vehicle{
    public Bakkie(String color, String vinNumber, String model, int year, double volume) {
        super(color, vinNumber, model, year, volume);
        this.price = 150;
    }


    @Override
    public double GetPrice(CustomerSlip slip) {
        return this.price * slip.GetKilometres();
    }
}
