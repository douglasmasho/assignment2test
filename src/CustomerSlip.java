public class CustomerSlip {
    private String customerName;
    private String vin;
    private int hours;
    private double kilometres;
    private long slipNo;


    public CustomerSlip(String customerName, String vin, int hours, double kilometres, long slipNo) {
        this.customerName = customerName;
        this.vin = vin;
        this.hours = hours;
        this.kilometres = kilometres;
        this.slipNo = slipNo;
    }

    public long GetSlipNo(){
        return slipNo;
    }

    public int GetHours() {
        return hours;
    }


    public double GetKilometres() {
        return kilometres;
    }

}
