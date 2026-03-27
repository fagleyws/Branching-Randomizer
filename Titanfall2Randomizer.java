import java.util.*;

public class Titanfall2Randomizer{
    private ArrayList<String> activeWeapons = new ArrayList<String>();
    private ArrayList<String> activeTitans = new ArrayList<String>();
    private final String[] weapons = {"G2", "Hemlok", "Flatline", "Mozambique", "RE-45", "P2016", "Alternator", "L-Star", "Devotion", "Kraber", "Double Take", "DMR", "EVA Auto", "Mastiff", "SMR", "EPG", "Softball", "Cold War", "Wingman Elite"};
    private final String[] titans = {"Ion", "Scorch", "Northstar", "Tone", "Legion", "Ronin", "Monarch"};

    public Titanfall2Randomizer() {
        addWeapons();
        addTitans();
    }

    public void activateProgram(boolean quit, Random rand, Scanner input) {
        while(quit == false){
            int trackWeapons = rand.nextInt(activeWeapons.size());
            String weapon = activeWeapons.get(trackWeapons);
            activeWeapons.remove(trackWeapons);

            int trackTitans = rand.nextInt(activeTitans.size());
            String titan = activeTitans.get(trackTitans);
            activeTitans.remove(trackTitans);

            boolean validInput = false;

            System.out.println("Your random loadout is:");
            System.out.println("Weapon: " + weapon);
            System.out.println("Titan: " + titan);

            while(!validInput){
                try{
                    System.out.println("Would you like another loadout? (y/n)");
                    input = new Scanner(System.in);
                    String response = input.nextLine();
                    switch (response) {
                        case "y":
                            validInput = true;
                            break;
                        case "n":
                            quit = true;
                            validInput = true;
                            break;
                        default:
                            throw new InvalidInputException("Invalid input. Please enter 'y' or 'n'.");
                    }
                } catch(InvalidInputException e){
                    System.out.println(e.getMessage());
                }
            }

            if(activeWeapons.size() == 0){
                System.out.println("All weapons have been used, Reloading weapon list...");
                addWeapons();
            }

            if(activeTitans.size() == 0){
                System.out.println("All titans have been used, Reloading titan list...");
                addTitans();
            }
        }
    }

    public ArrayList<String> getActiveWeapons() {
        return activeWeapons;
    }

    public String[] getTitans() {
        return titans;
    }

    public void addWeapons(){
        for(int i = 0; i < weapons.length; i++){
            activeWeapons.add(weapons[i]);
        }
    }

    public void addTitans(){
        for(int i = 0; i < titans.length; i++){
            activeTitans.add(titans[i]);
        }
    }
}