import java.util.*;

public class BranchingRandomizer{
    public static void main(String[] args) throws Exception {
        boolean quit = false;
        boolean validChoice = false;
        boolean keepGoing = true;
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("Pick a game from the options below:");
        System.out.println("1. Titanfall 2");           //Finished
        System.out.println("2. Dead by Daylight");      //Finished
        System.out.println("3. World of Warships");     //Finished
        System.out.println("4. Azur Lane");             //Finished
        System.out.println("5. Elden Ring");            //Under Construction, will softlock currently
        System.out.println("\nEnter the number corresponding to your choice:");
        int choice = input.nextInt();
        brancher(choice, validChoice, quit, rand, input);

        while(keepGoing){
            try{
                System.out.println("Would you like to try another randomizer for a different game? (y/n)");
                input = new Scanner(System.in);
                String response = input.nextLine();
                switch (response) {
                    case "y":
                        System.out.println("Pick a game from the options below:");
                        System.out.println("1. Titanfall 2");
                        System.out.println("2. Dead by Daylight");
                        System.out.println("3. World of Warships");
                        System.out.println("4. Azur Lane");
                        System.out.println("5. Elden Ring");
                        System.out.println("\nEnter the number corresponding to your choice:");
                        choice = input.nextInt();
                        brancher(choice, validChoice, quit, rand, input);
                        break;
                    case "n":
                        keepGoing = false;
                        break;
                    default:
                        throw new InvalidInputException("Invalid input. Please enter 'y' or 'n'.");
                }
            } catch(InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nHave a good Day!");
        input.close();
    }

    public static void brancher(int choice, boolean validChoice, boolean quit, Random rand, Scanner input){
        while(!validChoice){
            switch(choice) {
                case 1:
                    Titanfall2Randomizer active1 = new Titanfall2Randomizer();
                    active1.activateProgram(quit, rand, input);
                    validChoice = true;
                    break;
                case 2:
                    DeadByDaylightRandomizer active2 = new DeadByDaylightRandomizer();
                    active2.activateProgram(quit, rand, input);
                    validChoice = true;
                    break;
                case 3:
                    WorldOfWarshipsRandomizer active3 = new WorldOfWarshipsRandomizer();
                    active3.activateProgram(quit, rand, input);
                    validChoice = true;
                    break;
                case 4:
                    AzurLaneRandomizer active4 = new AzurLaneRandomizer();
                    active4.activateProgram(quit, rand, input);
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again with the 4 choices:");
                    System.out.println("1. Titanfall 2");
                    System.out.println("2. Dead by Daylight");
                    System.out.println("3. World of Warships");
                    System.out.println("4. Azur Lane");
                    System.out.println("5. Elden Ring");
                    System.out.println("\nEnter the number corresponding to your choice:");
                    choice = input.nextInt();
                }
            }
    }
}
