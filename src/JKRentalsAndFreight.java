import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JKRentalsAndFreight {
    public static void main(String[] args) {
        RentalsDept rentals = new RentalsDept();
        Vehicle vehicle1 = new Sedan("yellow","40cv94mz87", "Audi A5", 2016, 150);
        Vehicle vehicle2 = new Bakkie("red","31ug37sd87", "Toyota Hilux", 2016, 600);
        Vehicle vehicle3 = new Sedan("blue","12on48mk90", "Toyota Corolla", 2015, 200);
        Vehicle vehicle4 = new Bakkie("white","14on48ck90", "Chevrolet Cruze", 2015, 400);
        Vehicle vehicle5 = new Bakkie("green","22on4pn1", "VW Amarok", 2019, 500);
        Vehicle vehicle6 = new Sedan("orange","67fc93ag04", "Dodge charger", 2019, 230);

        CustomerSlip slip1 =  new CustomerSlip("Coby Macdonald", "40cv94mz87", 12, 200, 123);
        CustomerSlip slip2 =  new CustomerSlip("Gaven Velazquez", "31ug37sd87", 20, 250, 124);
        CustomerSlip slip3 =  new CustomerSlip("Delaney Huffman", "12on48mk90", 15, 300, 125);
        CustomerSlip slip4 =  new CustomerSlip("Ashanti Chen", "14on48ck90", 10, 150, 126);
        CustomerSlip slip5 =  new CustomerSlip("Kevin Cohen", "22on4pn1", 34, 310, 127);
        CustomerSlip slip6 =  new CustomerSlip("Madyson Lynch", "67fc93ag04", 11, 100, 128);


        rentals.AddVehicle(vehicle1);
        rentals.AddVehicle(vehicle2);
        rentals.AddVehicle(vehicle3);
        rentals.AddVehicle(vehicle4);
        rentals.AddVehicle(vehicle5);
        rentals.AddVehicle(vehicle6);

        rentals.AddSlip(slip1);
        rentals.AddSlip(slip2);
        rentals.AddSlip(slip3);
        rentals.AddSlip(slip4);
        rentals.AddSlip(slip5);
        rentals.AddSlip(slip6);

        String name = "Amarok";
        int count = (int)name.toLowerCase().chars().filter(letter->letter=='a').count();
        System.out.println(count);

        //testing the GetPrice methods:
        System.out.println("Price of slip 1:" + vehicle1.GetPrice(slip1));
        System.out.println("Price of slip 2:" + vehicle1.GetPrice(slip2));
        System.out.println("Price of slip 3:" + vehicle1.GetPrice(slip3));
        System.out.println("Price of slip 4:" + vehicle1.GetPrice(slip4));
        System.out.println("Price of slip 5:" + vehicle1.GetPrice(slip5));
        System.out.println("Price of slip 6:" + vehicle1.GetPrice(slip6));
        System.out.println("******************************************");
        boolean showMenu = true;
        while(showMenu){
            showMenu = menu(rentals);
        }
    }
    public static boolean shouldContinue(Scanner scanner){
        System.out.print("Do you want to continue? (T/F): ");
        return (scanner.nextLine().toUpperCase().equals("T")) ? true : false;
    }
    public static boolean menu(RentalsDept rentals) {
        System.out.println("Welcome to J+K Rentals And Freight Services. You are using our new rentals department app!");
        System.out.println("To start, please select an option from the list below:");
        System.out.println("(1) View our available vehicles");
        System.out.println("(2) Find a vehicle with a VIN number");
        System.out.println("(3) Find how many Sendans of a given color are available");
        System.out.println("(4) Find how many Bakkies of a given color are available");
        System.out.println("(5) Find how many Bakkies were made in a specific year");
        System.out.println("(6) Get Details of the Bakkie with the biggest trailer");
        System.out.println("(7) Get Details of the Sedan with the biggest boot");
        System.out.println("(8) See average hours rented of our vehicles");
        System.out.println("(9) See average kilometers travelled of our vehicles");
        System.out.println("(10) See all the vehicles with two a's in their name");
        System.out.println("(11) Save details of a vehicle into a file");
        System.out.println("(12) Read details of a vehicle from file");
        System.out.println("q) quit the program");



        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()){
            case "1":
                rentals.PrintAllVehicles();
                return shouldContinue(scanner);
            case "2":
                System.out.println("Please enter the vin number");
                System.out.println(rentals.GetVehicle(scanner.nextLine()).getModel());
                return shouldContinue(scanner);
            case "3":
                System.out.println("Please enter the color you are looking for in lowercase e.g(blue)");
                System.out.println(rentals.HowManySedansOfColor(scanner.nextLine()));
                return shouldContinue(scanner);
            case "4":
                System.out.println("Please enter the color you are looking for in lowercase e.g(blue)");
                System.out.println(rentals.HowManyBakkiesOfColor(scanner.nextLine()));
                return shouldContinue(scanner);
            case "5":
                System.out.println("Please enter the year you are looking for eg(2005)");
                System.out.println(rentals.HowManyBakkiesinYear(Integer.parseInt(scanner.nextLine())));
                return shouldContinue(scanner);
            case "6":
                System.out.println(rentals.GetBiggestBakkie());
                return shouldContinue(scanner);
            case "7":
                System.out.println(rentals.GetBiggestBoot());
                return shouldContinue(scanner);
            case "8":
                System.out.println(roundOff(rentals.GetAverageHours(),2) + " hours");
                return shouldContinue(scanner);
            case "9":
                System.out.println(roundOff(rentals.GetAverageKilometers(), 2) + " Kilometers");
                return shouldContinue(scanner);
            case "10":
                ArrayList<String> names = rentals.GetCarsWithTwoAs();
                for (String name: names) {
                    System.out.println(name);
                }
                return shouldContinue(scanner);
            case "11":
                System.out.println("Please enter the vin number of the vehicle");
                try{
                    rentals.AddDetailsToFile("NewCar.txt", scanner.nextLine());
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return shouldContinue(scanner);
            case "12":
                try{
                    List<String> details = rentals.ReadFromFile("NewCar.txt");
                    String detailsString = details.toString();
                    System.out.println(detailsString);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return shouldContinue(scanner);
            case "q":
                return false;
            default:
                System.out.println("You pressed an unavailable option");
                return shouldContinue(scanner);
        }
    }

    public static double roundOff(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
