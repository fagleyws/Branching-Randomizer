import java.util.*;

public class WorldOfWarshipsRandomizer {
    //Ship Types and their general tiers
    private final String[] shipTypes = {"Cruiser", "Destroyer", "Battleship", "Aircraft Carrier"};
    private final String[] CruiserTiers = {"1", "2", "3", "4", "5", "6", "7", "8", "Legendary"};
    private final String[] DestroyerTiers = {"2", "3", "4", "5", "6", "7", "8", "Legendary"};
    private final String[] BattleshipTiers = {"3", "4", "5", "6", "7", "8", "Legendary"};
    private final String[] AircraftCarrierTiers = {"3", "5", "7", "Legendary"};

    //Cruisers
    private final String[] Cruisers1 = {"Albany", "Chikuma", "Weymouth", "Dresden", "Jurien", "Novik", "Nino Bixio", "Gryf", "Shi An", "Gelderland", "Jupiter"};
    private final String[] Cruisers2 = {"Saint Louis", "Tenryu", "Caledon", "Kolberg", "Friant", "Bogatyr", "Taranto", "Java", "Navarra"};
    private final String[] Cruisers3 = {"Phoenix", "Kuma", "Danae", "Karlsruhe", "Duguay Trouin", "Svietlana", "Giussano", "De Ruyter", "Almte. Cervera"};
    private final String[] Cruisers4 = {"Omaha", "Furutaka", "Agano", "Emerald", "Hawkins", "Konigsberg", "Emile Bertin", "Kirov", "Kotovsky", "Montecuccoli", "Chungking", "Celebes", "Galicia"};
    private final String[] Cruisers5 = {"Pensacola", "Dalls", "Aoba", "Gokase", "Leander", "Devonshire", "Nurnberg", "La Galissonniere", "Budyonny", "Gorky", "Trento", "Rahmat", "Kijkduin", "Baleares"};
    private final String[] Cruisers6 = {"New Orleans", "Helena", "Myoko", "Omono", "Fiji", "Surrey", "Yorck", "Algerie", "Toulon", "Schors", "Tallin", "Zara", "Chumphon", "Eendracht", "Asturias"};
    private final String[] Cruisers7 = {"Baltimore", "Cleveland", "Mogami", "Shimanto", "Endinburgh", "Albemarle", "Hipper", "Charles Martel", "Cherbourg", "Chapayev", "Riga", "Amalfi", "Harbin", "Haarlem", "Cataluna"};
    private final String[] Cruisers8 = {"Buffalo", "Seattle", "Ibuki", "Takahashi", "Neptune", "Drake", "Roon", "Saint Louis", "Brest", "Dm. Donskoi", "Petropavlovsk", "Brindisi", "Sejong", "Johan De Witt", "Andalucia"};
    private final String[] CruisersStar = {"Des Moines", "Worcester", "Minotaur", "Henri IV", "Venezia", "Jinan", "Gouden Leeuw", "Castilla"};

    //Destroyers
    private final String[] Destroyers2 = {"Wickes", "Wakatake", "Valkyrie", "V-25", "Fusilier", "Derzki", "N. Sauro", "Romulus", "Phra Ruang"};
    private final String[] Destroyers3 = {"Clemson", "Isokaze", "Wakegul", "V-170", "Bourrasque", "Izyaslav", "Turbine", "Klas Horn", "Shenyang"};
    private final String[] Destroyers4 = {"Farragut", "Mutsuki", "Minekaze", "Acasta", "T-22", "Jaguar", "L'Adroit", "Podvoisky", "Soobrazitelny", "Maestrale", "Visby", "Muavenet", "Jianwei"};
    private final String[] Destroyers5 = {"Mahan", "Fubuki", "Hatsuharu", "Icarus", "Gaede", "Guepard", "Duchaffault", "Gnevny", "Boevoi", "Aviere", "Stord", "Vasteras", "Fushun"};
    private final String[] Destroyers6 = {"Benson", "Akatsuki", "Shiratsuyu", "Jervis", "Maass", "Z-31", "Vauquelin", "Le Hardi", "Minsk", "Kiev", "L. Tarigo", "Grom", "Skane", "Gadjah Mada"};
    private final String[] Destroyers7 = {"Fletcher", "Kagero", "Akizuki", "Lightning", "Z-23", "G. J. Maerker", "Le Fantasque", "L'Aventurier", "Tashkent", "Udaloi", "V. Cunberti", "Split", "Osterogotland", "Hsienyang"};
    private final String[] Destroyers8 = {"Allen M. Sumner", "Yugumo", "Kitakaze", "Jutland", "Z-46", "F. Schultz", "Mogador", "Orage", "Delny", "Neustrashimy", "Adriatico", "L. Katsonis", "Smaland", "Chung Mu"};
    private final String[] DestroyersStar = {"Gearing", "Shimakaze", "Daring", "Z-52", "Kleber", "Khabarovsk", "Gdansk", "Halland"};

    //Battleships
    private final String[] Battleships3 = {"Wyoming", "Ishizuki", "Orion", "Kaiser", "Courbet", "Gangut", "D. Alighieri"};
    private final String[] Battleships4 = {"New York", "Neveda", "Kongo", "Iron Duke", "Konig", "Derfflinger", "Bretagne", "Pyotr Velikiy", "Cavour"};
    private final String[] Battleships5 = {"New Mexico", "Tennessee", "Fuso", "Queen Elizabeth", "Bayern", "Mackensen", "Normandie", "Izmail", "Andrea Doria"};
    private final String[] Battleships6 = {"Connecticut", "Colorado", "North Carolina", "Nagato", "Ise", "King George V", "Gneissanau", "P. Heinrich", "Lyon", "Sinop", "F. Caracciolo"};
    private final String[] Battleships7 = {"Nebraska", "Iowa", "Kansas", "Amagi", "Suwo", "Vanguard", "Bismarck", "Zieten", "Richelieu", "Vladivostok", "V. Veneto"};
    private final String[] Battleships8 = {"Delaware", "Maine", "Minnesota", "Izumo", "Dewa", "Temeraire", "F. der Große", "P. Rupprecht", "Alsace", "Sov. Soyuz", "Lepanto"};
    private final String[] BattleshipsStar = {"Louisiana", "Montana", "Yamato", "Conqueror", "G. Kurfurst", "Bourgogne", "C. Colombo"};
    
    //Aircraft Carriers
    private final String[] AircraftCarriers3 = {"Langley", "Hosho", "Hermes", "Rhein", "Komsomolets"};
    private final String[] AircraftCarriers5 = {"Ranger", "Ryujo", "Furious", "Weser", "Serov"};
    private final String[] AircraftCarriers7 = {"Lexington", "Shokaku", "Implacable", "A. Parseval", "Pobeda"};
    private final String[] AircraftCarriersStar = {"Hakuryuu"};

    //Active arrays for each ship type and their tiers
    private ArrayList<String> activeShipTypes = new ArrayList<>();
    private ArrayList<String> activeCruiserTiers = new ArrayList<>();
    private ArrayList<String> activeDestroyerTiers = new ArrayList<>();
    private ArrayList<String> activeBattleshipTiers = new ArrayList<>();
    private ArrayList<String> activeAircraftCarrierTiers = new ArrayList<>();

    //Cruisers Arrays
    private ArrayList<String> activeCruisers1 = new ArrayList<>();
    private ArrayList<String> activeCruisers2 = new ArrayList<>();
    private ArrayList<String> activeCruisers3 = new ArrayList<>();
    private ArrayList<String> activeCruisers4 = new ArrayList<>();
    private ArrayList<String> activeCruisers5 = new ArrayList<>();
    private ArrayList<String> activeCruisers6 = new ArrayList<>();
    private ArrayList<String> activeCruisers7 = new ArrayList<>();
    private ArrayList<String> activeCruisers8 = new ArrayList<>();
    private ArrayList<String> activeCruisersStar = new ArrayList<>();

    //Destroyers Arrays
    private ArrayList<String> activeDestroyers2 = new ArrayList<>();
    private ArrayList<String> activeDestroyers3 = new ArrayList<>();
    private ArrayList<String> activeDestroyers4 = new ArrayList<>();
    private ArrayList<String> activeDestroyers5 = new ArrayList<>();
    private ArrayList<String> activeDestroyers6 = new ArrayList<>();
    private ArrayList<String> activeDestroyers7 = new ArrayList<>();
    private ArrayList<String> activeDestroyers8 = new ArrayList<>();
    private ArrayList<String> activeDestroyersStar = new ArrayList<>();

    //Battleship Arrays
    private ArrayList<String> activeBattleships3 = new ArrayList<>();
    private ArrayList<String> activeBattleships4 = new ArrayList<>();
    private ArrayList<String> activeBattleships5 = new ArrayList<>();
    private ArrayList<String> activeBattleships6 = new ArrayList<>();
    private ArrayList<String> activeBattleships7 = new ArrayList<>();
    private ArrayList<String> activeBattleships8 = new ArrayList<>();
    private ArrayList<String> activeBattleshipsStar = new ArrayList<>();

    //Aircraft Carrier Arrays
    private ArrayList<String> activeAircraftCarriers3 = new ArrayList<>();
    private ArrayList<String> activeAircraftCarriers5 = new ArrayList<>();
    private ArrayList<String> activeAircraftCarriers7 = new ArrayList<>();
    private ArrayList<String> activeAircraftCarriersStar = new ArrayList<>();

    public WorldOfWarshipsRandomizer() {
        addShipTypes();
        addCruiserTiers();
        addDestroyerTiers();
        addBattleshipTiers();
        addAircraftCarrierTiers();

        addCruisers1();
        addCruisers2();
        addCruisers3();
        addCruisers4();
        addCruisers5();
        addCruisers6();
        addCruisers7();
        addCruisers8();
        addCruisersStar();

        addDestroyers2();
        addDestroyers3();
        addDestroyers4();
        addDestroyers5();
        addDestroyers6();
        addDestroyers7();
        addDestroyers8();
        addDestroyersStar();

        addBattleships3();
        addBattleships4();
        addBattleships5();
        addBattleships6();
        addBattleships7();
        addBattleships8();
        addBattleshipsStar();

        addAircraftCarriers3();
        addAircraftCarriers5();
        addAircraftCarriers7();
        addAircraftCarriersStar();
    }

    public void activateProgram(boolean quit, Random rand, Scanner input){
        while(quit == false){
            if(activeShipTypes.size() == 0){
                System.out.println("Reloading ship types...");
                addShipTypes();
            }
            if(activeCruiserTiers.size() == 0){
                System.out.println("Reloading Cruiser Tiers...");
                addCruiserTiers();
            }
            if(activeDestroyerTiers.size() == 0){
                System.out.println("Reloading Destroyer Tiers...");
                addDestroyerTiers();
            }
            if(activeBattleshipTiers.size() == 0){
                System.out.println("Reloading Battleship Tiers...");
                addBattleshipTiers();
            }
            if(activeAircraftCarrierTiers.size() == 0){
                System.out.println("Reloading Aircraft Carrier Tiers...");
                addAircraftCarrierTiers();
            }

            int tracker = rand.nextInt(activeShipTypes.size());
            String shipType = activeShipTypes.get(tracker);
            activeShipTypes.remove(tracker);
            String tier = "";
            String ship = "";

            switch(shipType) {
                case "Cruiser":
                    tracker = rand.nextInt(activeCruiserTiers.size());
                    tier = activeCruiserTiers.get(tracker);
                    activeCruiserTiers.remove(tracker);
                    switch(tier){
                        case "1":
                            tracker = rand.nextInt(activeCruisers1.size());
                            ship = activeCruisers1.get(tracker);
                            activeCruisers1.remove(tracker);
                            break;
                        case "2":
                            tracker = rand.nextInt(activeCruisers2.size());
                            ship = activeCruisers2.get(tracker);
                            activeCruisers2.remove(tracker);
                            break;
                        case "3":
                            tracker = rand.nextInt(activeCruisers3.size());
                            ship = activeCruisers3.get(tracker);
                            activeCruisers3.remove(tracker);
                            break;
                        case "4":
                            tracker = rand.nextInt(activeCruisers4.size());
                            ship = activeCruisers4.get(tracker);
                            activeCruisers4.remove(tracker);
                            break;
                        case "5":
                            tracker = rand.nextInt(activeCruisers5.size());
                            ship = activeCruisers5.get(tracker);
                            activeCruisers5.remove(tracker);
                            break;
                        case "6":
                            tracker = rand.nextInt(activeCruisers6.size());
                            ship = activeCruisers6.get(tracker);
                            activeCruisers6.remove(tracker);
                            break;
                        case "7":
                            tracker = rand.nextInt(activeCruisers7.size());
                            ship = activeCruisers7.get(tracker);
                            activeCruisers7.remove(tracker);
                            break;
                        case "8":
                            tracker = rand.nextInt(activeCruisers8.size());
                            ship = activeCruisers8.get(tracker);
                            activeCruisers8.remove(tracker);
                            break;
                        case "Legendary":
                            tracker = rand.nextInt(activeCruisersStar.size());
                            ship = activeCruisersStar.get(tracker);
                            activeCruisersStar.remove(tracker);
                            break;
                    }
                    break;
                case "Destroyer":
                    tracker = rand.nextInt(activeDestroyerTiers.size());
                    tier = activeDestroyerTiers.get(tracker);
                    activeDestroyerTiers.remove(tracker);
                    switch(tier){
                        case "2":
                            tracker = rand.nextInt(activeDestroyers2.size());
                            ship = activeDestroyers2.get(tracker);
                            activeDestroyers2.remove(tracker);
                            break;
                        case "3":
                            tracker = rand.nextInt(activeDestroyers3.size());
                            ship = activeDestroyers3.get(tracker);
                            activeDestroyers3.remove(tracker);
                            break;
                        case "4":
                            tracker = rand.nextInt(activeDestroyers4.size());
                            ship = activeDestroyers4.get(tracker);
                            activeDestroyers4.remove(tracker);
                            break;
                        case "5":
                            tracker = rand.nextInt(activeDestroyers5.size());
                            ship = activeDestroyers5.get(tracker);
                            activeDestroyers5.remove(tracker);
                            break;
                        case "6":
                            tracker = rand.nextInt(activeDestroyers6.size());
                            ship = activeDestroyers6.get(tracker);
                            activeDestroyers6.remove(tracker);
                            break;
                        case "7":
                            tracker = rand.nextInt(activeDestroyers7.size());
                            ship = activeDestroyers7.get(tracker);
                            activeDestroyers7.remove(tracker);
                            break;
                        case "8":
                            tracker = rand.nextInt(activeDestroyers8.size());
                            ship = activeDestroyers8.get(tracker);
                            activeDestroyers8.remove(tracker);
                            break;
                        case "Legendary":
                            tracker = rand.nextInt(activeDestroyersStar.size());
                            ship = activeDestroyersStar.get(tracker);
                            activeDestroyersStar.remove(tracker);
                            break;
                    }
                    break;
                case "Battleship":
                    tracker = rand.nextInt(activeBattleshipTiers.size());
                    tier = activeBattleshipTiers.get(tracker);
                    activeBattleshipTiers.remove(tracker);
                    switch(tier){
                        case "3":
                            tracker = rand.nextInt(activeBattleships3.size());
                            ship = activeBattleships3.get(tracker);
                            activeBattleships3.remove(tracker);
                            break;
                        case "4":
                            tracker = rand.nextInt(activeBattleships4.size());
                            ship = activeBattleships4.get(tracker);
                            activeBattleships4.remove(tracker);
                            break;
                        case "5":
                            tracker = rand.nextInt(activeBattleships5.size());
                            ship = activeBattleships5.get(tracker);
                            activeBattleships5.remove(tracker);
                            break;
                        case "6":
                            tracker = rand.nextInt(activeBattleships6.size());
                            ship = activeBattleships6.get(tracker);
                            activeBattleships6.remove(tracker);
                            break;
                        case "7":
                            tracker = rand.nextInt(activeBattleships7.size());
                            ship = activeBattleships7.get(tracker);
                            activeBattleships7.remove(tracker);
                            break;
                        case "8":
                            tracker = rand.nextInt(activeBattleships8.size());
                            ship = activeBattleships8.get(tracker);
                            activeBattleships8.remove(tracker);
                            break;
                        case "Legendary":
                            tracker = rand.nextInt(activeBattleshipsStar.size());
                            ship = activeBattleshipsStar.get(tracker);
                            activeBattleshipsStar.remove(tracker);
                            break;
                    }
                    break;
                case "Aircraft Carrier":
                    tracker = rand.nextInt(activeAircraftCarrierTiers.size());
                    tier = activeAircraftCarrierTiers.get(tracker);
                    activeAircraftCarrierTiers.remove(tracker);
                    switch(tier){
                        case "3":
                            tracker = rand.nextInt(activeAircraftCarriers3.size());
                            ship = activeAircraftCarriers3.get(tracker);
                            activeAircraftCarriers3.remove(tracker);
                            break;
                        case "5":
                            tracker = rand.nextInt(activeAircraftCarriers5.size());
                            ship = activeAircraftCarriers5.get(tracker);
                            activeAircraftCarriers5.remove(tracker);
                            break;
                        case "7":
                            tracker = rand.nextInt(activeAircraftCarriers7.size());
                            ship = activeAircraftCarriers7.get(tracker);
                            activeAircraftCarriers7.remove(tracker);
                            break;
                        case "Legendary":
                            tracker = rand.nextInt(activeAircraftCarriersStar.size());
                            ship = activeAircraftCarriersStar.get(tracker);
                            activeAircraftCarriersStar.remove(tracker);
                            break;
                    }
                    break;
            }

            boolean validInput = false;

            System.out.println("You ship is the tier " + tier + " " + ship);

            while(!validInput){
                try{
                    System.out.println("Would you like another ship? (y/n)");
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

            if(activeCruisers1.size() == 0){
                addCruisers1();
            }

            if(activeCruisers2.size() == 0){
                addCruisers2();
            }

            if(activeCruisers3.size() == 0){
                addCruisers3();
            }

            if(activeCruisers4.size() == 0){
                addCruisers4();
            }

            if(activeCruisers5.size() == 0){
                addCruisers5();
            }

            if(activeCruisers6.size() == 0){
                addCruisers6();
            }

            if(activeCruisers7.size() == 0){
                addCruisers7();
            }

            if(activeCruisers8.size() == 0){
                addCruisers8();
            }

            if(activeCruisersStar.size() == 0){
                addCruisersStar();
            }

            if(activeDestroyers2.size() == 0){
                addDestroyers2();
            }

            if(activeDestroyers3.size() == 0){
                addDestroyers3();
            }

            if(activeDestroyers4.size() == 0){
                addDestroyers4();
            }

            if(activeDestroyers5.size() == 0){
                addDestroyers5();
            }

            if(activeDestroyers6.size() == 0){
                addDestroyers6();
            }

            if(activeDestroyers7.size() == 0){
                addDestroyers7();
            }

            if(activeDestroyers8.size() == 0){
                addDestroyers8();
            }

            if(activeDestroyersStar.size() == 0){
                addDestroyersStar();
            }

            if(activeBattleships3.size() == 0){
                addBattleships3();
            }

            if(activeBattleships4.size() == 0){
                addBattleships4();
            }

            if(activeBattleships5.size() == 0){
                addBattleships5();
            }

            if(activeBattleships6.size() == 0){
                addBattleships6();
            }

            if(activeDestroyers7.size() == 0){
                addDestroyers7();
            }

            if(activeBattleships8.size() == 0){
                addBattleships8();
            }

            if(activeBattleshipsStar.size() == 0){
                addBattleshipsStar();
            }

            if(activeAircraftCarriers3.size() == 0){
                addAircraftCarriers3();
            }

            if(activeAircraftCarriers5.size() == 0){
                addAircraftCarriers5();
            }

            if(activeAircraftCarriers7.size() == 0){
                addAircraftCarriers7();
            }

            if(activeAircraftCarriersStar.size() == 0){
                addAircraftCarriersStar();
            }
        }
    }

    //Reloader methods
    public void addShipTypes(){
        for(int i = 0; i < shipTypes.length; i++){
            activeShipTypes.add(shipTypes[i]);
        }
    }

    public void addCruiserTiers(){
        for(int i = 0; i < CruiserTiers.length; i++){
            activeCruiserTiers.add(CruiserTiers[i]);
        }
    }

    public void addDestroyerTiers(){
        for(int i = 0; i < DestroyerTiers.length; i++){
            activeDestroyerTiers.add(DestroyerTiers[i]);
        }
    }

    public void addBattleshipTiers(){
        for(int i = 0; i < BattleshipTiers.length; i++){
            activeBattleshipTiers.add(BattleshipTiers[i]);
        }
    }

    public void addAircraftCarrierTiers(){
        for(int i = 0; i < AircraftCarrierTiers.length; i++){
            activeAircraftCarrierTiers.add(AircraftCarrierTiers[i]);
        }
    }

    public void addCruisers1(){
        for(int i = 0; i < Cruisers1.length; i++){
            activeCruisers1.add(Cruisers1[i]);
        }
    }

    public void addCruisers2(){
        for(int i = 0; i < Cruisers2.length; i++){
            activeCruisers2.add(Cruisers2[i]);
        }
    }

    public void addCruisers3(){
        for(int i = 0; i < Cruisers3.length; i++){
            activeCruisers3.add(Cruisers3[i]);
        }
    }

    public void addCruisers4(){
        for(int i = 0; i < Cruisers4.length; i++){
            activeCruisers4.add(Cruisers4[i]);
        }
    }

    public void addCruisers5(){
        for(int i = 0; i < Cruisers5.length; i++){
            activeCruisers5.add(Cruisers5[i]);
        }
    }

    public void addCruisers6(){
        for(int i = 0; i < Cruisers6.length; i++){
            activeCruisers6.add(Cruisers6[i]);
        }
    }

    public void addCruisers7(){
        for(int i = 0; i < Cruisers7.length; i++){
            activeCruisers7.add(Cruisers7[i]);
        }
    }

    public void addCruisers8(){
        for(int i = 0; i < Cruisers8.length; i++){
            activeCruisers8.add(Cruisers8[i]);
        }
    }

    public void addCruisersStar(){
        for(int i = 0; i < CruisersStar.length; i++){
            activeCruisersStar.add(CruisersStar[i]);
        }
    }

    public void addDestroyers2(){
        for(int i = 0; i < Destroyers2.length; i++){
            activeDestroyers2.add(Destroyers2[i]);
        }
    }

    public void addDestroyers3(){
        for(int i = 0; i < Destroyers3.length; i++){
            activeDestroyers3.add(Destroyers3[i]);
        }
    }

    public void addDestroyers4(){
        for(int i = 0; i < Destroyers4.length; i++){
            activeDestroyers4.add(Destroyers4[i]);
        }
    }

    public void addDestroyers5(){
        for(int i = 0; i < Destroyers5.length; i++){
            activeDestroyers5.add(Destroyers5[i]);
        }
    }

    public void addDestroyers6(){
        for(int i = 0; i < Destroyers6.length; i++){
            activeDestroyers6.add(Destroyers6[i]);
        }
    }

    public void addDestroyers7(){
        for(int i = 0; i < Destroyers7.length; i++){
            activeDestroyers7.add(Destroyers7[i]);
        }
    }

    public void addDestroyers8(){
        for(int i = 0; i < Destroyers8.length; i++){
            activeDestroyers8.add(Destroyers8[i]);
        }
    }

    public void addDestroyersStar(){
        for(int i = 0; i < DestroyersStar.length; i++){
            activeDestroyersStar.add(DestroyersStar[i]);
        }
    }

    public void addBattleships3(){
        for(int i = 0; i < Battleships3.length; i++){
            activeBattleships3.add(Battleships3[i]);
        }
    }

    public void addBattleships4(){
        for(int i = 0; i < Battleships4.length; i++){
            activeBattleships4.add(Battleships4[i]);
        }
    }

    public void addBattleships5(){
        for(int i = 0; i < Battleships5.length; i++){
            activeBattleships5.add(Battleships5[i]);
        }
    }

    public void addBattleships6(){
        for(int i = 0; i < Battleships6.length; i++){
            activeBattleships6.add(Battleships6[i]);
        }
    }

    public void addBattleships7(){
        for(int i = 0; i < Battleships7.length; i++){
            activeBattleships7.add(Battleships7[i]);
        }
    }

    public void addBattleships8(){
        for(int i = 0; i < Battleships8.length; i++){
            activeBattleships8.add(Battleships8[i]);
        }
    }

    public void addBattleshipsStar(){
        for(int i = 0; i < BattleshipsStar.length; i++){
            activeBattleshipsStar.add(BattleshipsStar[i]);
        }
    }

    public void addAircraftCarriers3(){
        for(int i = 0; i < AircraftCarriers3.length; i++){
            activeAircraftCarriers3.add(AircraftCarriers3[i]);
        }
    }

    public void addAircraftCarriers5(){
        for(int i = 0; i < AircraftCarriers5.length; i++){
            activeAircraftCarriers5.add(AircraftCarriers5[i]);
        }
    }

    public void addAircraftCarriers7(){
        for(int i = 0; i < AircraftCarriers7.length; i++){
            activeAircraftCarriers7.add(AircraftCarriers7[i]);
        }
    }

    public void addAircraftCarriersStar(){
        for(int i = 0; i < AircraftCarriersStar.length; i++){
            activeAircraftCarriersStar.add(AircraftCarriersStar[i]);
        }
    }
}