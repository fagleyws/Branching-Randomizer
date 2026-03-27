import java.util.*;

public class AzurLaneRandomizer{
    //Characters sorted by rarity and position
    private final String[] ultraBackliners = {"Musashi", "Shinano", "Amagi(CV)", "Bismark Zwei", "Fritz Rumey", "Mecklenburg", "Hakuhou", "New Jersey", "Yorktown II", "Kearsarge", "Warspite (Retrofit)", "Vanguard", "Lion", "Implacable", "Hakuryuu", "Ulrich Von Hutten", "Friedrich der Große", "Raffaello", "Sovetsky Soyuz", "Admiral Nakhimov", "Alsace", "Lexington II"};
    private final String[] superBackliners = {"Volga", "Flandre", "Indiana", "Ryuuhou", "Enterprise", "Massachusetts", "Formidable", "Seydlitz", "Tirpitz", "Gascogne", "Hornet II", "North Carolina", "Washington", "Intrepid", "Independence", "Kansas", "Hood", "King George V", "Duke of York", "Perseus", "Monarch", "Amagi", "Nagato", "Tosa", "Kii", "Owari", "Suruga", "Akagi", "Shoukaku", "Zuikaku", "Taihou", "Katsuragi", "Izumo", "Daisen", "Lützow", "Graf Zepplin", "Odin", "August Von Parseval", "Prinz Rupprecht", "Vittorio Veneto", "Marco Polo", "Sovetskaya Belorussiya", "Sovetskaya Rossiya", "Chkalov", "Richelieu", "Jean Bart", "Joffre", "Constellation", "Ticonderoga", "Georgia", "Illustious", "Kaga", "Peter Strasser", "Champagne", "Akashi", "Franklin", "Aquila", "Kazan", "Chang Chun (Retrofit)", "Littorio", "Gascogne µ", "Prince of Wales", "Impero", "Kaga(BB)", "Brünhilde", "Painlevé", "Indomitable", "Strasbourg", "Alvitr", "Albion", "Oumi", "Clemenceau", "South Dakota", "Cowpens", "Victorious", "Formidable µ", "Bismarck", "Roma", "Alabama", "Howe", "Royal Oak", "Centaur", "Theseus", "Illustrious µ", "Mikasa", "Zuihou", "Admiral Zenker", "Huan Ch'ang", "Sao Martinho", "Ganj-i-Sawai", "Essex", "Shangri-La", "Akagi µ", "Taihou µ", "Francesco Caracciolo", "Masséna", "Bois Belleau", "Queen Anne's Revenge", "Pearl", "Unryuu"};
    private final String[] ultraFrontliners = {"Laffey II", "Plymouth", "Unzen", "Hindenburg", "Napoli", "Brest", "Trafalgar", "Gouden Leeuw", "San Diego (Retrofit)", "Guam", "Drake", "Shimakaze", "Yuudachi (Retrofit)", "Azuma", "Z52", "Ägir", "Kronshtadt", "Mogador", "Moskva", "William D. Porter"};
    private final String[] superFrontliners = {"Wakatsuki", "Jervis", "Avrora", "Halford", "Otto Von Alvensleben", "Dmitri Donskoi", "Vittrio Cuniberti", "Eldridge", "Allen M. Sumner", "Monteplier", "San Francisco", "Baltimore", "Anchorage", "Belfast", "Swiftsure", "Scylla", "Neptune", "Cheshire", "Yukikaze", "Suzutsuki", "Kazagumo", "Noshiro", "Chikuma", "Takao", "Atago", "Ibuki", "Kitakaze", "Shimanto", "Z23 (Retrofit)", "Z46", "Magdeburg", "Regensburg", "Prinz Eugen", "Roon µ", "Prinz Heinrich", "Prinz Adalbert", "Friedrich Carl", "Roon", "Felix Schultz", "Ning Hai (Retrofit)", "An Shan (Retrofit)", "Harbin", "Pompeo Magno", "Pola", "Tashkent", "Kiev", "Kuybyshev", "Voroshilov", "Tallin", "Kursk", "Le Terrible", "Saint Louis", "Bayard", "Algérie", "Sakawa", "Seattle", "Dido µ", "Emden", "Mainz", "Gorizia", "Jeanne d'Arc", "L'Indomptable", "Marseillaise", "Duca degli Abruzzi", "Bremerton", "Zara", "Yat Sen (Retrofit)", "Kawakaze", "Duisburg", "Giuseppe Garibaldi", "Attilio Regolo", "De Zeven Provinciën", "Chapayev", "Blücher", "Z47", "Maya", "Janus", "Prinz Eugen µ", "Ingraham", "Le Malin µ", "Reno", "Fargo", "Charybdis", "Ognevoy", "Guichen", "Pittsburgh", "Dido", "Tashkent µ", "Sirius", "Santa Fe", "Northampton II", "Fancy", "Bristol", "Nubiam", "Hermione", "Cleopatra", "Hatsuzuki", "Noshiro µ", "Watarse", "Chien Wu", "Ozornoy", "Kirov", "Brennus", "L'Audacieux", "Golden Hind", "Minneapolis", "Asama", "Chang Wu", "Le Triophant", "Le Hardi", "Le Malin", "Lyme"};

    //Chance of getting an Ultra rarity ship
    private final int[] chanceOfUltraShips = {0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6};

    //active character arrays
    private ArrayList<String> activeUltraBackliners = new ArrayList<>();
    private ArrayList<String> activeUltraFrontliners = new ArrayList<>();
    private ArrayList<String> activeSuperBackliners = new ArrayList<>();
    private ArrayList<String> activeSuperFrontliners = new ArrayList<>();

    public AzurLaneRandomizer(){
        addUltraBackliners();
        addUltraFrontliners();
        addSuperBackliners();
        addSuperFrontliners();
    }

    public void activateProgram(boolean quit, Random rand, Scanner input){
        while(quit == false){
            int numOfUltraShips = chanceOfUltraShips[rand.nextInt(chanceOfUltraShips.length)];
            int numOfUltraBackliners = 0;
            int numOfUltraFrontliners = 0;
            int numOfSuperBackliners = 0;
            int numOfSuperFrontliners = 0;
            int shipsDetermined = 0;
            int shipTracker = 0;

            //Defines how many characters from rarity will be on each position
            if(numOfUltraShips > 0){
                numOfUltraBackliners = rand.nextInt(numOfUltraShips);
                if(numOfUltraBackliners > 3){
                    numOfUltraBackliners = 3;
                }
                numOfUltraFrontliners = numOfUltraShips - numOfUltraBackliners;
                numOfSuperBackliners = 3 - numOfUltraBackliners;
                numOfSuperFrontliners = 3 - numOfUltraFrontliners;
            }
            else{
                numOfSuperBackliners = 3;
                numOfSuperFrontliners = 3;
            }

            //Ships that will be determined
            String ship1 = "";
            String ship2 = "";
            String ship3 = "";
            String ship4 = "";
            String ship5 = "";
            String ship6 = "";

            //Gets ultra rarity backliners
            while(numOfUltraBackliners > 0){
                if(activeUltraBackliners.size() == 0){
                    System.out.println("Reloading Ultra Rare Backliners...");
                    addUltraBackliners();
                }

                shipTracker = rand.nextInt(activeUltraBackliners.size());
                String ship = activeUltraBackliners.get(shipTracker);

                if(shipsDetermined == 0){
                    ship1 = ship;
                    shipsDetermined++;
                    numOfUltraBackliners--;
                }
                else if(shipsDetermined == 1){
                    ship2 = ship;
                    shipsDetermined++;
                    numOfUltraBackliners--;
                }
                else{
                    ship3 = ship;
                    shipsDetermined++;
                    numOfUltraBackliners--;
                }

                activeUltraBackliners.remove(shipTracker);
            }
            
            //Get super rarity backliners
            while(numOfSuperBackliners > 0){
                if(activeSuperBackliners.size() == 0){
                    System.out.println("Reloading Super Rare Backliners...");
                    addSuperBackliners();
                }

                shipTracker = rand.nextInt(activeSuperBackliners.size());
                String ship = activeSuperBackliners.get(shipTracker);

                if(shipsDetermined == 0){
                    ship1 = ship;
                    shipsDetermined++;
                    numOfSuperBackliners--;
                }
                else if(shipsDetermined == 1){
                    ship2 = ship;
                    shipsDetermined++;
                    numOfSuperBackliners--;
                }
                else{
                    ship3 = ship;
                    shipsDetermined++;
                    numOfSuperBackliners--;
                }

                activeSuperBackliners.remove(shipTracker);
            }
            
            //Get ultra rarity front liners
            while(numOfUltraFrontliners > 0){
                if(activeUltraFrontliners.size() == 0){
                    System.out.println("Reloading Ultra Rare Frontliners...");
                    addUltraFrontliners();
                }

                shipTracker = rand.nextInt(activeUltraFrontliners.size());
                String ship = activeUltraFrontliners.get(shipTracker);

                if(shipsDetermined == 3){
                    ship4 = ship;
                    shipsDetermined++;
                    numOfUltraFrontliners--;
                }
                else if(shipsDetermined == 4){
                    ship5 = ship;
                    shipsDetermined++;
                    numOfUltraFrontliners--;
                }
                else{
                    ship6 = ship;
                    shipsDetermined++;
                    numOfUltraFrontliners--;
                }

                activeUltraFrontliners.remove(shipTracker);
            }
            
            //Get super rarity frontliners
            while(numOfSuperFrontliners > 0){
                if(activeSuperFrontliners.size() == 0){
                    System.out.println("Reloading Super Rare Frontliners...");
                    addSuperFrontliners();
                }

                shipTracker = rand.nextInt(activeSuperFrontliners.size());
                String ship = activeSuperFrontliners.get(shipTracker);

                if(shipsDetermined == 3){
                    ship4 = ship;
                    shipsDetermined++;
                    numOfSuperFrontliners--;
                }
                else if(shipsDetermined == 4){
                    ship5 = ship;
                    shipsDetermined++;
                    numOfSuperFrontliners--;
                }
                else{
                    ship6 = ship;
                    shipsDetermined++;
                    numOfSuperFrontliners--;
                }

                activeSuperFrontliners.remove(shipTracker);
            }
            
            boolean validInput = false;

            System.out.println("Your Backline is: " + ship1 + ", " + ship2 + ", " + ship3);
            System.out.println("Your Frontline is: " + ship4 + ", " + ship5 + ", " + ship6);

            while(!validInput){
                try{
                    System.out.println("Would you like another fleet? (y/n)");
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

    //Methods to reload arrays
    public void addUltraBackliners(){
        for(int i = 0; i < ultraBackliners.length; i++){
            activeUltraBackliners.add(ultraBackliners[i]);
        }
    }

    public void addUltraFrontliners(){
        for(int i = 0; i < ultraFrontliners.length; i++){
            activeUltraFrontliners.add(ultraFrontliners[i]);
        }
    }

    public void addSuperBackliners(){
        for(int i = 0; i < superBackliners.length; i++){
            activeSuperBackliners.add(superBackliners[i]);
        }
    }

    public void addSuperFrontliners(){
        for(int i = 0; i < superFrontliners.length; i++){
            activeSuperFrontliners.add(superFrontliners[i]);
        }
    }
}