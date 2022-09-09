import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalsDept {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<CustomerSlip> slips;


    public RentalsDept() {
        this.vehicles = new ArrayList<>();
        this.slips = new ArrayList<>();
    }

    public void PrintAllVehicles(){
        for(int i = 0; i < vehicles.size(); i++){
            System.out.println(vehicles.get(i).getModel() + " " + vehicles.get(i).getVin());
        }
    }

    public void AddVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle GetVehicle(String vin) {
        System.out.println("Vin entered" + " " + vin);
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getVin().equals(vin)) {
                return vehicles.get(i);
            }
        }
        return null;
    }

    public void AddSlip(CustomerSlip slip) {
        slips.add(slip);
    }

    public int HowManySedansOfColor(String color) {
        int count = 0;
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Sedan && vehicles.get(i).getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }
    public int HowManyBakkiesOfColor(String color) {
        int count = 0;
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Bakkie && vehicles.get(i).getColor().equals(color)) {
                count++;
            }
        }
        return count;
    }
    public int HowManyBakkiesinYear(int year) {
        int count = 0;
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Bakkie && vehicles.get(i).getYear() == year) {
                count++;
            }
        }
        return count;
    }

    public String GetBiggestBakkie() {
        //since the first element in the array can be either a bakkie or a sedan, we will have to use the smallest number possible instead of using the first vehicle's volume
        String biggestBakkie = "No Bakkie found";
        double biggestBakkieVolume = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Bakkie && vehicles.get(i).getVolume() > biggestBakkieVolume) {
                biggestBakkie = vehicles.get(i).getModel() + " " +vehicles.get(i).getVin();
                biggestBakkieVolume = vehicles.get(i).getVolume();
            }
        }
        return biggestBakkie;
    }

    public String GetBiggestBoot() {
        //since the first element in the array can be either a bakkie or a sedan, we will have to use the smallest number possible instead of using the first vehicle's volume
        String biggestBoot = "No Sedan found";
        double biggestBootVolume = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Sedan && vehicles.get(i).getVolume() > biggestBootVolume) {
                biggestBoot = vehicles.get(i).getModel() + " " +vehicles.get(i).getVin();
                biggestBootVolume = vehicles.get(i).getVolume();
            }
        }
        return biggestBoot;
    }

    public double GetAverageKilometers() {
        double sum = 0;
        for(int i = 0; i < slips.size(); i++) {
            sum += slips.get(i).GetKilometres();
        }
        return sum / slips.size();
    }

    public double GetAverageHours() {
        double sum = 0;
        for(int i =0; i<slips.size(); i++) {
            sum+=slips.get(i).GetHours();
        }
        return sum / slips.size();
    }

    public ArrayList<String> GetCarsWithTwoAs(){
        ArrayList<String> names = new ArrayList<String>();

        for (Vehicle vehicle : vehicles) {
            if(vehicle.getModel().toLowerCase().chars().filter(letter->letter=='a').count() == 2){
                names.add(vehicle.getModel());
            }
        }
        return names;
    }


    public void AddDetailsToFile(String fileName, String vinNumber) throws IOException{
        File f;
        PrintWriter pw = null;
        try{
            f = new File(fileName);
            pw = new PrintWriter(f);
            for (Vehicle vehicle:vehicles) {
                if(vehicle.getVin().equals(vinNumber)){
                    pw.println("Vin Number: " + vehicle.getVin());
                    pw.println("Model name: " + vehicle.getModel());
                    pw.println("Color: " + vehicle.getColor());
                    pw.println("Year: " + vehicle.getYear());
                    pw.println("Volume: " + vehicle.getVolume());
                }
            }
        }catch(Exception e){
            throw new IOException("The file does not exist");
        }finally {
            pw.close();
        }
    }

    public List<String> ReadFromFile(String filename) throws Exception
    {
        File file;
        Scanner scan;
        List<String> lines;

        try
        {
            lines = new ArrayList<>();
            file = new File(filename);
            scan = new Scanner(file);

            while(scan.hasNext())
            {
                lines.add(scan.nextLine());
            }
            return lines;
        }
        catch(Exception e)
        {
            throw new IOException("The file does not exist");
        }
    }

}
