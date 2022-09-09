import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest {
    @Test
    public void SedanPriceTest(){
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        CustomerSlip slip = new CustomerSlip("Benjamen Salomo", "kr234fep9", 20, 200,203);

        double newPrice = sedan.GetPrice(slip);
        assert (2000 == newPrice);
    }

    @Test
    public void BakkiePriceTest(){
        Bakkie bakkie = new Bakkie("red", "lq145efq8", "Toyoat 86", 2020, 20);
        CustomerSlip slip = new CustomerSlip("Benjamen Salomo", "kr234fep9", 20, 200,203);

        double newPrice = bakkie.GetPrice(slip);
        assert (30000 == newPrice);
    }
}