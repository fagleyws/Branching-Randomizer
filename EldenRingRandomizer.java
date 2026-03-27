import java.util.*;

public class EldenRingRandomizer {
    private final String[] helmet = {};
    private final String[] chestplate = {};
    private final String[] leggings = {};
    private final String[] gloves = {};
    private final String[] talismans = {};
    private final String[] weapons = {};
    private final String[][] spells = {};

    private final int spellSlots = 10;
    int activeSpellSlots = spellSlots;

    ArrayList<String> activeHelmets = new ArrayList<>();
    ArrayList<String> activeChestplates = new ArrayList<>();
    ArrayList<String> activeLeggings = new ArrayList<>();
    ArrayList<String> activeGloves = new ArrayList<>();
    ArrayList<String> activeTalismans = new ArrayList<>();
    ArrayList<String> activeWeapons = new ArrayList<>();
    ArrayList<String[]> activeSpells = new ArrayList<>();

    public EldenRingRandomizer(){
        addHelmets();
        addChestplates();
        addLeggings();
        addGloves();
        addTalismans();
        addWeapons();
        addSpells();
    }

    public void activateProgram(boolean quit, Random rand, Scanner input) {
        while(quit == false){
            //Give randomized loadout
            int tracker = rand.nextInt(activeHelmets.size());
            String determinedHelmet = activeHelmets.get(tracker);
            activeHelmets.remove(tracker);

            tracker = rand.nextInt(activeChestplates.size());
            String determinedChestplate = activeChestplates.get(tracker);
            activeChestplates.remove(tracker);

            boolean validInput = false;

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
        }
    }

    public void addHelmets(){
        for(int i = 0; i < helmet.length; i++){
            activeHelmets.add(helmet[i]);
        }
    }

    public void addChestplates(){
        for(int i = 0; i < chestplate.length; i++){
            activeChestplates.add(chestplate[i]);
        }
    }

    public void addLeggings(){
        for(int i = 0; i < leggings.length; i++){
            activeLeggings.add(leggings[i]);
        }
    }

    public void addGloves(){
        for(int i = 0; i < gloves.length; i++){
            activeGloves.add(gloves[i]);
        }
    }

    public void addTalismans(){
        for(int i = 0; i < talismans.length; i++){
            activeTalismans.add(talismans[i]);
        }
    }

    public void addWeapons(){
        for(int i = 0; i < weapons.length; i++){
            activeWeapons.add(weapons[i]);
        }
    }

    public void addSpells(){
        for(int i = 0; i < spells.length; i++){
            activeSpells.add(spells[i]);
        }
    }
}