import org.junit.Test;

import static org.junit.Assert.*;

public class RentalsDeptTest {

    @Test
    public void AddVehicleTest(){
        RentalsDept rentalsDept = new RentalsDept();
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        rentalsDept.AddVehicle(sedan);
        Vehicle newVehicle = rentalsDept.GetVehicle("kr234fep9");

        //we want to assert that when fetching a vehicle with the vin
        assert(newVehicle.getModel() == "Subaru BRZ");
    }

    @Test
    public void AddSlipTest(){
        RentalsDept rentalsDept = new RentalsDept();
        CustomerSlip slip = new CustomerSlip("Benjamen Salomo", "kr234fep9", 20, 200,203);
        rentalsDept.AddSlip(slip);

        //we only added one slip with 20 hours, so to make sure it is there, the average hours should be 20
        double average = rentalsDept.GetAverageHours();

        assert(average == 20);
    }

    @Test
    public void HowManySedansOfColorTest(){
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        Sedan sedan2 = new Sedan("blue", "kr2suhius", "VW Jetta", 2021, 20);
        Bakkie bakkie = new Bakkie("blue", "oijoi2676", "Toyota Hilux", 2015, 400);
        Bakkie bakkie2 = new Bakkie("blue", "oijoiu76", "VW Amarok", 2016, 500);

        RentalsDept rentalsDept = new RentalsDept();
        rentalsDept.AddVehicle(sedan);
        rentalsDept.AddVehicle(sedan2);
        rentalsDept.AddVehicle(bakkie);
        rentalsDept.AddVehicle(bakkie2);

        int howMany = rentalsDept.HowManySedansOfColor("blue");

        //we only added 2 blue sedans, so, we must assert that howMany is 2
        assert(howMany == 2);
    }

    @Test
    public void HowManyBakkiesOfColorTest(){
        Sedan sedan = new Sedan("silver", "kr234fep9", "Subaru BRZ", 2020, 20);
        Sedan sedan2 = new Sedan("silver", "kr2suhius", "VW Jetta", 2021, 20);
        Bakkie bakkie = new Bakkie("silver", "oijoi2676", "Toyota Hilux", 2015, 400);
        Bakkie bakkie2 = new Bakkie("silver", "oijoiu76", "VW Amarok", 2016, 500);

        RentalsDept rentalsDept = new RentalsDept();
        rentalsDept.AddVehicle(sedan);
        rentalsDept.AddVehicle(sedan2);
        rentalsDept.AddVehicle(bakkie);
        rentalsDept.AddVehicle(bakkie2);

        int howMany = rentalsDept.HowManyBakkiesOfColor("silver");

        //we only added 2 silver bakkies, so, we must assert that howMany is 2
        assert(howMany == 2);
    }

    @Test
    public void HowManyBakkiesInYearTest(){
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        Sedan sedan2 = new Sedan("blue", "kr2suhius", "VW Jetta", 2020, 20);
        Bakkie bakkie = new Bakkie("silver", "oijoi2676", "Toyota Hilux", 2020, 400);
        Bakkie bakkie2 = new Bakkie("silver", "oijoiu76", "VW Amarok", 2020, 500);

        RentalsDept rentalsDept = new RentalsDept();
        rentalsDept.AddVehicle(sedan);
        rentalsDept.AddVehicle(sedan2);
        rentalsDept.AddVehicle(bakkie);
        rentalsDept.AddVehicle(bakkie2);

        int howManyIn2020 = rentalsDept.HowManyBakkiesinYear(2020);

        //since we added only 2 bakkies made in 2020, then we must assert that howManyIn2020 is 2
        assert(howManyIn2020 == 2);
    }

    @Test
    public void BiggestBakkieTest(){
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        Sedan sedan2 = new Sedan("blue", "kr2suhius", "VW Jetta", 2020, 30);
        Bakkie bakkie = new Bakkie("silver", "oijoi2676", "Toyota Hilux", 2020, 400);
        Bakkie bakkie2 = new Bakkie("silver", "oijoiu76", "VW Amarok", 2020, 500);

        RentalsDept rentalsDept = new RentalsDept();
        rentalsDept.AddVehicle(sedan);
        rentalsDept.AddVehicle(sedan2);
        rentalsDept.AddVehicle(bakkie);
        rentalsDept.AddVehicle(bakkie2);

        String biggestBakkie = rentalsDept.GetBiggestBakkie();

        //the VW Amarok with vin oijoiu76 is the bakkie with the highest trunk volume
        assertEquals(biggestBakkie, "VW Amarok oijoiu76");
    }

    @Test
    public void BiggestBootTest(){
        Sedan sedan = new Sedan("blue", "kr234fep9", "Subaru BRZ", 2020, 20);
        Sedan sedan2 = new Sedan("blue", "kr2suhius", "VW Jetta", 2020, 30);
        Bakkie bakkie = new Bakkie("silver", "oijoi2676", "Toyota Hilux", 2020, 400);
        Bakkie bakkie2 = new Bakkie("silver", "oijoiu76", "VW Amarok", 2020, 500);

        RentalsDept rentalsDept = new RentalsDept();
        rentalsDept.AddVehicle(sedan);
        rentalsDept.AddVehicle(sedan2);
        rentalsDept.AddVehicle(bakkie);
        rentalsDept.AddVehicle(bakkie2);

        String biggestBoot = rentalsDept.GetBiggestBoot();

        //the VW Jetta with vin kr2suhius is the sedan with the highest boot volume
        assertEquals(biggestBoot, "VW Jetta kr2suhius");
    }
    public static double roundOff(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @Test
    public void GetAverageKilometersTest(){
        RentalsDept rentalsDept = new RentalsDept();
        CustomerSlip slip = new CustomerSlip("Benjamen Salomo", "kr234fep9", 20, 200,203);
        CustomerSlip slip2 = new CustomerSlip("Douglas Mashonganyika", "kj24mmio45", 30, 300,204);
        CustomerSlip slip3 = new CustomerSlip("Gabriel Ndimulunde", "kj24mkli38", 40, 350,205);

        rentalsDept.AddSlip(slip);
        rentalsDept.AddSlip(slip2);
        rentalsDept.AddSlip(slip3);

        //we added slips with the kilometers 200,300 and 350, so the average has to be 283.33 rounded to 2 d.p
        double average = rentalsDept.GetAverageKilometers();

        assert(283.33 ==  roundOff(average,2));
    }

    @Test
    public void GetAverageHoursTest(){
        RentalsDept rentalsDept = new RentalsDept();
        CustomerSlip slip = new CustomerSlip("Benjamen Salomo", "kr234fep9", 20, 200,203);
        CustomerSlip slip2 = new CustomerSlip("Douglas Mashonganyika", "kj24mmio45", 30, 300,204);
        CustomerSlip slip3 = new CustomerSlip("Gabriel Ndimulunde", "kj24mkli38", 40, 350,205);

        rentalsDept.AddSlip(slip);
        rentalsDept.AddSlip(slip2);
        rentalsDept.AddSlip(slip3);

        //we added slips with the hours 20,30 and 40, so the average has to be 30
        assert(30 ==  rentalsDept.GetAverageHours());
    }
}