import java.util.*;

public class DeadByDaylightRandomizer {

    //General

    private ArrayList<String> activeKillers = new ArrayList<String>();
    private ArrayList<String> activeKillerPerks = new ArrayList<String>();
    private ArrayList<String> activeSurvivorItems = new ArrayList<String>();
    private ArrayList<String> activeSurvivorPerks = new ArrayList<String>();

    private final String[] killers = {"Trapper", "Wraith", "Hillbilly", "Nurse", "Shape", "Hag", "Doctor", "Huntress", "Cannibal", "Nightmare", "Pig", "Clown", "Spirit", "Legion", "Plague", "Ghost Face", "Demogorgon", "Oni", "Death Slinger", "Executioner", "Blight", "Twins", "Trickster", "Nemesis", "Cenobite", "Artist", "Onryo", "Dredge", "Mastermind", "Knight", "Skull Merchant", "Singularity", "Xenomorph", "Good Guy", "Unknown", "Lich", "Dark Lord", "Houndmaster", "Ghoul", "Animatronic", "Krasue", "First"};
    private final String[] killerPerks = {"Bitter Murmer", "Deerstalker", "Distressing", "Hex: No One Escapes Death", "Hex: Thrill of The Hunt", "Insidious", "Iron Grasp", "Scourge Hook: Monsterous Shrine", "Shattered Hope", "Sloppy Butcher", "Spies from the Shadows", "Whispers", "Unrelenting", "Agitation", "Unnerving Presence", "Brutal Strength", "Bloodhound", "Predator", "Shadowborn", "Enduring", "Lightborn", "Tinkerer", "Nurse's Calling", "Stridor", "Thanatophobia", "Dying Light", "Play with your Food", "Save the Best for Last", "Hex: Devour Hope", "Hex: Ruin", "Hex: The Third Seal", "Monitor & Abuse", "Overcharge", "Overwhelming Presence", "Barbecue & Chili", "Franklin's Demise", "Knock Out", "Beast of Prey", "Hex: Huntress Lullaby", "Territorial Imperative", "Blood Warden", "Fire Up", "Remember Me", "Hangman's Trick", "Make Your Choice", "Surveillance", "Bamboozle", "Coulrophobia", "Pop Goes the Weasel", "Hex: Haunted Ground", "Ranchor", "Spirit Fury", "Discordance", "Iron Maiden", "Mad Grit", "Corrupt Intervention", "Dark Devotion", "Infectious Fright", "Furtive Chase", "I'm All Ears", "Thrilling Tremors", "Cruel Limits", "Mindbreaker", "Surge", "Blood Echo", "Nemesis", "Zanshin Tactics", "Dead Man's Switch", "Gear Head", "Hex: Retribution", "Deathbound", "Forced Penance", "Trail of Torment", "Dragon's Grip", "Hex: Blood Favor", "Hex: Undying", "Coup de Grace", "Hoarder", "Oppression", "Hex: Crowd Control", "No Way Out", "Starstruck", "Eruption", "Hysteria", "Lethal Pursuer", "Deadlock", "Hex: Plaything", "Scourge Hook: Gift of Pain", "Grim Embrace", "Hex: Petimento", "Scourge Hook: Pain Resonance", "Call of Brine", "Merciless Storm", "Scourge Hook: Floods of Rage", "Darkness Revealed", "Dissolution", "Septic Touch", "Awakened Awareness", "Superior Anatomy", "Terminus", "Hex: Face the Darkness", "Hubris", "Nowhere to Hide", "Game Afoot", "Leverage", "THWACK!", "Forced Hesitation", "Genetic Limits", "Machine Learning", "Alien Instinct", "Rapid Brutality", "Ultimate Weapon", "Batteries Included", "Friends 'til the End", "Hex: Two Can Play", "Unbound", "Undone", "Unforeseen", "Dark Arrogance", "Languid Touch", "Weave Attunement", "Dominance", "Hex: Wretched Fate", "Human Greed", "All-shaking Thunder", "No Quarter", "Scourge Hook: Jagged Compass", "Forever Entwined", "Hex: Nothing But Misery", "None Are Free", "Help Wanted", "Haywire", "Phantom Fear", "Hex: Overture of Doom", "Ravenous", "Wandering Eye", "Hex: Hive Mind", "Turn Back The Clock", "Secret Project"};
    private final String[] survivorItems = {"Flashlight", "Sport Flashlight", "Utility Flashlight", "Broken Key", "Dull Key", "Skeleton Key", "Apprentice's Fog Vial", "Artisan's Fog Vial", "Vigo's Fog Vial", "Cryptic Map", "Scribbled Map", "Annotated Map", "Camping Aid Kit", "First Aid Kit", "Emergency Med-Kit", "Ranger Med-Kit", "Worn-Out Tools", "Toolbox", "Commodius Toolbox", "Mechanic's Toolbox", "Alex's Toolbox", "Engineer's Toolbox"};
    private final String[] survivorPerks = {"Dark Sense", "Deja Vu", "Hope", "Kindred", "Lightweight", "No One Left Behind", "Plunderer's Instinct", "Premonition", "Resilience", "Slippery Meat", "Small Game", "Spine Chill", "This Is Not Happening", "We'll Make It", "Bond", "Leader", "Prove Thyself", "Adrenaline", "Quick & Quiet", "Sprint Burst", "Botany Knowledge", "Empathy", "Self-Care", "Calm Spirit", "Iron Will", "Saboteur", "Balanced Landing", "Streetwise", "Urban Evasion", "Decisive Strike", "Object of Obsession", "Sole Survivor", "Ace in the Hole", "Open-Handed", "Up the Ante", "Borrowed Time", "Left Behind", "Unbreakable", "Alert", "Lithe", "Technician", "Dead Hard", "No Mither", "We're Gonna Live Forever", "Pharmacy", "Vigil", "Wake Up!", "Detective's Hunch", "Stake Out", "Tenacity", "Boil Over", "Dance With Me", "Windows of Opportunity", "Autodidact", "Deliverance", "Diversion", "Aftercare", "Breakdown", "Distortion", "Head On", "Poised", "Solidarity", "Buckle Up", "Flip-Flop", "Mettle of Man", "Better Together", "Fixated", "Inner Strength", "Babysitter", "Camaraderie", "Second Wind", "Any Means Necessary", "Breakout", "Lucky Break", "For the People", "Off the Record", "Red Herring", "Blood Pact", "Repressed Alliance", "Soul Guard", "Built to Last", "Desperate Measures", "Visionary", "Appraisal", "Deception", "Power Struggle", "Fast Track", "Self-Preservation", "Smash Hit", "Blast Mine", "Counterforce", "Resurgence", "Bite The Bullet", "Flashbang", "Rookie Spirit", "Boon: Circle of Healing", "Boon: Shadow Step", "Clairvoyance", "Boon: Exponential", "Corrective Action", "Overcome", "Boon: Dark Theory", "Empathic Connection", "Parental Guidance", "Inner Focus", "Overzealous", "Residual Manifest", "Low Profile", "Reactive Healing", "Wiretap", "Better Than New", "Hyperfocus", "Reassurance", "Fogwise", "Potential Energy", "Quick Gambit", "Cut Loose", "Friendly Competition", "Teamwork: Power of Two", "Background Player", "Blood Rush", "Teamwork: Collective Stealth", "Made for This", "Scavenger", "Troubleshooter", "Dramaturgy", "Scene Partner", "Plot Twist", "Chemical Trap", "Light-Footed", "Lucky Star", "Boon: Illumination", "Champion of Light", "Deadline", "Invocation: Weaving Spiders", "Strength in Shadows", "Wicked", "Bardic Inspiration", "Mirrored Illusion", "Still Sight", "Finesse", "Hardened", "Specialist", "Exultation", "Moment of Glory", "Eyes of Belmont", "Clean Break", "Invocation: Treacherous Crows", "Shoulder the Burden", "Do No Harm", "Duty of Care", "Rapid Response", "Apocalyptic Ingenuity", "Come and Get Me!", "Teamwork: Toughen Up", "Conviction", "Last Stand", "Teamwork: Throw Down", "Road Life", "ONE-TWO-THREE-FOUR!", "Ghost Notes", "Bada Bada Boom", "Change of Plan", "Teamwork: Full Circuit", "Extrasensory Perception", "We See You", "Teamwork: Soft-Spoken", "A Place for Us", "Five Moves Ahead", "Flow State"};

    //Survivor Addons

    private ArrayList<String> activeFlashlightAddons = new ArrayList<String>();
    private ArrayList<String> activeKeyAddons = new ArrayList<String>();
    private ArrayList<String> activeMapAddons = new ArrayList<String>();
    private ArrayList<String> activeMedkitAddons = new ArrayList<String>();
    private ArrayList<String> activeToolboxAddons = new ArrayList<String>();
    private ArrayList<String> activeFogVialAddons = new ArrayList<String>();

    private final String[] flashlightAddons = {"Odd Bulb", "Intense Halogen", "Long Life Battery", "High-End Sapphire Lens", "Focused Lens", "Heavy Duty Battery", "Low Amp Filament", "Rubber Grip", "Tir Optic", "Battery", "Leather Grip", "Power Bulb", "Wide Lens"};
    private final String[] keyAddons = {"Blood Amber", "Unique Wedding Ring", "Braided Bauble", "Shrill Whistle", "Friendship Charm"};
    private final String[] mapAddons = {"Crimson Stamp", "Sharpened Flint", "Battered Tape", "Gnarled Compass", "Glowing Ink"};
    private final String[] medkitAddons = {"Anti-Exhaustion Syringe", "Gel Dressing", "Abdominal Dressing", "Styptic Agent", "Guaze Roll", "Surgical Suture", "Medical Scissors", "Needle & Thread", "Self Adherent Wrap", "Sponge", "Bandages", "Butterfly Tape", "Rubber Gloves"};
    private final String[] toolboxAddons = {"Brand New Part", "Grip Wrench", "Hacksaw", "Cutting Wire", "Socket Swivels", "Spring Clamp", "Protective Gloves", "Wire Spool", "Clean Rag", "Instructions", "Scraps"};
    private final String[] fogVialAddons = {"Potent Extract", "Oily Sap", "Mushroom Formula", "Reactive Compound", "Volcanic Stone"};

    //Killer Addons

    private ArrayList<String> activeTrapperAddons = new ArrayList<String>();
    private ArrayList<String> activeWraithAddons = new ArrayList<String>();
    private ArrayList<String> activeHillbillyAddons = new ArrayList<String>();
    private ArrayList<String> activeNurseAddons = new ArrayList<String>();
    private ArrayList<String> activeShapeAddons = new ArrayList<String>();
    private ArrayList<String> activeHagAddons = new ArrayList<String>();
    private ArrayList<String> activeDoctorAddons = new ArrayList<String>();
    private ArrayList<String> activeHuntressAddons = new ArrayList<String>();
    private ArrayList<String> activeCannibalAddons = new ArrayList<String>();
    private ArrayList<String> activeNightmareAddons = new ArrayList<String>();
    private ArrayList<String> activePigAddons = new ArrayList<String>();
    private ArrayList<String> activeClownAddons = new ArrayList<String>();
    private ArrayList<String> activeSpiritAddons = new ArrayList<String>();
    private ArrayList<String> activeLegionAddons = new ArrayList<String>();
    private ArrayList<String> activePlagueAddons = new ArrayList<String>();
    private ArrayList<String> activeGhostFaceAddons = new ArrayList<String>();
    private ArrayList<String> activeDemogorgonAddons = new ArrayList<String>();
    private ArrayList<String> activeOniAddons = new ArrayList<String>();
    private ArrayList<String> activeDeathSlingerAddons = new ArrayList<String>();
    private ArrayList<String> activeExecutionerAddons = new ArrayList<String>();
    private ArrayList<String> activeBlightAddons = new ArrayList<String>();
    private ArrayList<String> activeTwinsAddons = new ArrayList<String>();
    private ArrayList<String> activeTricksterAddons = new ArrayList<String>();
    private ArrayList<String> activeNemesisAddons = new ArrayList<String>();
    private ArrayList<String> activeCenobiteAddons = new ArrayList<String>();
    private ArrayList<String> activeArtistAddons = new ArrayList<String>();
    private ArrayList<String> activeOnryoAddons = new ArrayList<String>();
    private ArrayList<String> activeDredgeAddons = new ArrayList<String>();
    private ArrayList<String> activeMastermindAddons = new ArrayList<String>();
    private ArrayList<String> activeKnightAddons = new ArrayList<String>();
    private ArrayList<String> activeSkullMerchantAddons = new ArrayList<String>();
    private ArrayList<String> activeSingularityAddons = new ArrayList<String>();
    private ArrayList<String> activeXenomorphAddons = new ArrayList<String>();
    private ArrayList<String> activeGoodGuyAddons = new ArrayList<String>();
    private ArrayList<String> activeUnknownAddons = new ArrayList<String>();
    private ArrayList<String> activeLichAddons = new ArrayList<String>();
    private ArrayList<String> activeDarkLordAddons = new ArrayList<String>();
    private ArrayList<String> activeHoundmasterAddons = new ArrayList<String>();
    private ArrayList<String> activeGhoulAddons = new ArrayList<String>();
    private ArrayList<String> activeAnimatronicAddons = new ArrayList<String>();
    private ArrayList<String> activeKrasueAddons = new ArrayList<String>();
    private ArrayList<String> activeFirstAddons = new ArrayList<String>();

    private final String[] trapperAddons = {"Iridescent Stone", "Bloody Coil", "Trapper Sack", "Tension Spring", "Oily Coil", "Honing Stone", "Trapper Bag", "Tar Bottle", "Secondary Coil", "Rusted Jaws", "Fastening Tools", "Wax Brick", "Serrated Jaws", "Lengthened Jaws", "4-coil Spring Kit", "Trapper Gloves", "Padded Jaws", "Makeshift Wrap", "Bear Oil"};
    private final String[] wraithAddons = {"Coxcombed Clapper", "\"All Seeing\"-Spirit", "\"Windstorm\"-Blood", "\"Swift Hunt\"-Blood", "\"Shadow Dance\"-Blood", "\"All Seeing\"-Blood", "\"Windstorm\"-White", "\"Swift Hunt\"-White", "\"Shadow Dance\"-White", "\"Blink\"-White", "\"Blind Warrior\"-White", "Bone Clapper", "\"Windstorm\"-Mud", "\"Swift Hunt\"-Mud", "\"Blink\"-Mud", "\"Blind Warrior\"-Mud", "\"The Serpent\"-Soot", "\"The Hound\"-Soot", "\"The Ghost\"-Soot", "\"The Beast\"-Soot"};
    private final String[] hillbillyAddons = {"Tuned Carburettor", "Iridescent Engravings", "Spiked Boots", "LoPro Chains", "Filthy Slippers", "Apex Muffler", "The Thompson's Mix", "Ragged Engines", "Low Kickback Chains", "Dad's Boots", "Begrimed Chains", "Thermal Casing", "Off-Brand Motor Oil", "High-Speed Idler Screw", "Greased Throttle", "Clogged Intake", "Steel Toe Boots", "Discarded Air Filter", "Cracked Primer Bulb", "Counterweight"};
    private final String[] nurseAddons = {"Torn Bookmark", "Matchbox", "Kavanagh's Last Breath", "Jenner's Last Breath", "Campbell's Last Breath", "\"Bad Man's\" Last Breath", "Spasmotic Breath", "Heavy Panting", "Fragile Wheeze", "Ataxic Respiration", "Anxious Gasp", "Pocket Watch", "Dull Bracelet", "Dark Cinture", "Catatonic Boy's Treasure", "Bad Man Keepsake", "Wooden Horse", "White Nit Comb", "Plaid Flannel", "Metal Spoon"};
    private final String[] shapeAddons = {"Scratched Mirror", "Judith's Tombstone", "Vanity Mirror", "Tombstone Piece", "Reflective Fragment", "Lock of Hair", "Mirror Shard", "Judith's Journal", "Jewellry Box", "J. Myers Memorial", "Hair Bow", "Jewellry", "Hair Brush", "Glass Fragment", "Fragment Tuft of Hair", "Dead Rabbit", "Tacky Earrings", "Memorial Flowers", "Boyfriend's Memo", "Blond Hair"};
    private final String[] hagAddons = {"Waterlogged Shoe", "Mint Rag", "Scarred Hand", "Rusty Shackles", "Grandma's Heart", "Disfigured Ear", "Willow Wreath", "Swamp Orchid Necklet", "Dried Cicada", "Cracked Turtle Egg", "Pussy Willow Catkins", "Half Eggshell", "Cypress Necklet", "Bloodied Water", "Rope Necklet", "Powdered Eggshell", "Dead Fly Mud", "Bog Water"};
    private final String[] doctorAddons = {"Iridescent King", "Iridescent Queen", "\"Restraint\"-Carter's Notes", "\"Order\"-Carter's Notes", "\"Discipline\"-Carter's Notes", "\"Calm\"-Carter's Notes", "Scrapped Tape", "Interview Tape", "High Stimulus Electrode", "\"Restraint\"-Class III", "\"Discipline\"-Class III", "Polished Electrode", "\"Restraint\"-Class II", "\"Order\"-Class II", "\"Discipline\"-Class II", "\"Calm\"-Class II", "Moldy Electrode", "Maple Knight", "\"Order\"-Class I", "\"Calm\"-Class I"};
    private final String[] huntressAddons = {"Soldier's Puttee", "Iridescent Head", "Wooden Fox", "Infantry Belt", "Glowing Concoction", "Begrimed Head", "Venomous Concoction", "Rusty Head", "Rose Root", "Flower Babushka", "Deerskin Gloves", "Weighted Head", "Shiny Pin", "Oak Haft", "Manna Grass Braid", "Leather Loop", "Yellowed Cloth", "Coarse Stone", "Bandaged Haft", "Amanita Toxin"};
    private final String[] cannibalAddons = {"Iridescent Flesh", "Carburettor Tuning Guide", "Rusted Chains", "Light Chasis", "Depth Gauge Rake", "Award-Winning Chilli", "The Grease", "The Beast's Marks", "Shop Lubricant", "Grisly Chains", "Begrimed Chains", "Primer Bulb", "Long Guide Bar", "Knife Scratches", "Homemade Muffler", "Chilli", "Vegetable Oil", "Speed Limiter", "Spark Plug", "Chainsaw File"};
    private final String[] nightmareAddons = {"Red Paint Brush", "Black Box", "Swing Chains", "Pill Bottle", "Class Photo", "\"Z\" Block", "Unicorn Block", "Paint Thinner", "Nancy's Masterpiece", "Jump Rope", "Blue Dress", "Prototype Claws", "Outdoor Rope", "Nancy's Sketch", "Green Dress", "Cat Block", "Wool Shirt", "Sheep Block", "Kid's Drawing", "Garden Rake"};
    private final String[] pigAddons = {"Video Tape", "Amanda's Letter", "Tampered Timer", "Jigsaw's Sketch", "Crate of Gears", "Amanda's Secret", "Slow-Release Toxin", "Rusty Attachments", "Rules Set No.2", "Jigsaw's Annotated Plan", "Bag of Gears", "Workshop Grease", "Utility Blades", "Razor Wires", "Last Will", "Face Mask", "Shattered Syringe", "John's Medical File", "Interlocking Razor", "Combat Straps"};
    private final String[] clownAddons = {"Tattoo's Middle Finger", "Redhead's Pinkie Finger", "Garish Make-Up Kit", "Ether 15 Vol%", "Cigar Box", "Cheap Gin Bottle", "Sulphuric Acid Vial", "Spirit of Hartshorn", "Smelly Inner Soles", "Flask of Bleach", "Bottle of Chloroform", "Thick Cork Stopper", "Sticky Soda Bottle", "Starling Feather", "Solvent Jug", "Kerosene Can", "VHS Porn", "Robin Feather", "Party Bottle", "Fingerless Parade Gloves"};
    private final String[] spiritAddons = {"Mother-Daughter Ring", "Kintsugi Teacup", "Yakuyoke Amulet", "Wakizashi Saya", "Furin", "Dried Cherry Blossom", "Uchiwa", "Senko Hanabi", "Rusty Flute", "Mother's Glasses", "Katana Tsuba", "White Hair Ribbon", "Rin's Broken Watch", "Muddy Sports Day Cap", "Kaiun Talisman", "Juniper Bonsai", "Zori", "Shiawase Amulet", "Origami Crane", "Gifted Bamboo Comb"};
    private final String[] legionAddons = {"Iridescent Button", "Fuming Mix Tape", "Stab Wounds Study", "Frank's Mix Tape", "Filthy Blade", "BFFs", "The Legion Pin", "Susie's Mix Tape", "Stylish Sunglasses", "Stolen Sketch Book", "Joey's Mix Tape", "Never-Sleep Pills", "Mural Sketch", "Julie's Mixtape", "Etched Ruler", "Defaced Smiley Pin", "Smiley Pin", "Scratched Ruler", "Mischief List", "Friendship Bracelet"};
    private final String[] plagueAddons = {"Iridescent Seal", "Black Incense", "Worship Tablet", "Vile Emetic", "Severed Toe", "Devottee's Amulet", "Rubbing Oil", "Infected Emetic", "Incensed Ointment", "Exorcism Amulet", "Ashen Apple", "Prophylactic Amulet", "Potent Tincture", "Haematite Seal", "Emetic Potion", "Blessed Apple", "Prayer Tablet Fragment", "Olibanum Incense", "Limestone Seal", "Healing Salve"};
    private final String[] ghostFaceAddons = {"Outdoor Security Camera", "\"Ghost Face Caught on Tape\"", "Victim's Detailed Routine", "Night Vision Monocular", "Drop-Leg Knife Stealth", "Driver's Liscense", "Olsen's Wallet", "Leather Knife Sheath", "Lasting Perfume", "Knife Belt Clip", "Chewed Pen", "Telephoto Lens", "Olsen's Journal", "Olsen's Address Book", "Marked Map", "Cinch Straps", "Walleye's Matchbook", "Headline Cut Outs", "Cheap Cologne", "\"Philly\""};
    private final String[] demogorgonAddons = {"Red Moss", "Leprose Lichen", "Vermillion Webcap", "Upside Down Resin", "Unknown Egg", "Lifeguard Whistle", "Violet Waxcap", "Thorny Vines", "Eleven's Soda", "Deer Lung", "Brass Case Lighter", "Viscous Webbing", "Sticky Lining", "Rotten Green Tripe", "Mew's Guts", "Barb's Glasses", "Rotten Pumpkin", "Rat Tail", "Rat Liver", "Black Heart"};
    private final String[] oniAddons = {"Renjiro's Bloody Glove", "Iridescent Family Crest", "Tear-Soaked Tenugui", "Splintered Hull", "Lion Fang", "Akito's Crutch", "Yamaoka Sashimono", "Wooden Oni Mask", "Shattered Wakizashi", "Scalped Topknot", "Kanai-Anzen Talisman", "Polished Maedate", "Ink Lion", "Chipped SaiHai", "Child's Wooden Sword", "Bloody Sash", "Rotting Rope", "Paper Lantern", "Cracked Sakazuki", "Blackend Toenail"};
    private final String[] deathSlingerAddons = {"Iridescent Coin", "Hellshire Iron", "Prison Chain", "Gold Creek Whiskey", "Bayshore's Cigar", "Barbed Wire", "Warden's Keys", "Wanted Poster", "Tin Oil Can", "Honey Locust Thorn", "Bayshore's Gold Tooth", "Rusted Spike", "Poison Oak Leaves", "Marshal's Badge", "Jaw Smasher", "Chewing Tobacco", "Spit Polish Rag", "Snake Oil", "Rickety Chain", "Modified Ammo Belt"};
    private final String[] executionerAddons = {"Obsidian Goblet", "Iridescent Seal of Metatron", "Scarlet Egg", "Rust Covered Egg", "Lost Memories Book", "Crimson Ceremony Book", "Vatiel Sect Photograph", "Tablet of The Oppressor", "Misty Day, Remains of Judgement", "Mannequin Foot", "Burning Man Painting", "Wax Doll", "Spearhead", "Leopard-Print Fabric", "Forgotten Videotape", "Cinderella Music Box", "Lead Ring", "Dead Butterfly", "Copper Ring", "Black Strap"};
    private final String[] blightAddons = {"Iridescent Blight Tag", "Compound Thirty-Three", "Vigo's Journal", "Summoning Stone", "Soul Chemical", "Alchemist's Ring", "Umbra Salts", "Rose Tonic", "Compound Twenty-One", "Blighted Crow", "Adrenaline Vial", "Shredded Notes", "Pustula Dust", "Plague Bile", "Canker Thorn", "Blighted Rat", "Placebo Tablet", "Foxglove", "Compound Seven", "Chipped Monocle"};
    private final String[] twinsAddons = {"Silencing Cloth", "Iridescent Pendant", "Victor's Soldier", "Spinning Top", "Forest Stew", "Drop of Perfume", "Weighty Rattle", "Stale Biscuit", "Sewer Sludge", "Rusted Needle", "Madeleine's Scarf", "Madeleine's Gloves", "Ceremonial Candelabrum", "Cat's Eye", "Bloody Black Hood", "Baby Teeth", "Toy Sword", "Tiny Fingernail", "Soured Milk", "Cat Figurine"};
    private final String[] tricksterAddons = {"Iridescent Photocard", "Death Throes Combination", "Trick Blades", "Edge of Revival Album", "Diamond Cufflinks", "Cut Thru U Single", "Waiting For You Watch", "Ripper Brace", "Melodius Murder", "Fizz-Spin Soda", "Bloddy Boa", "Tequila Moonrock", "On Target Single", "Lucky Blade", "Ji-woon's Autograph", "Caged Heart Shoes", "Trick Pouch", "Memento Blades", "Killing Part Chords", "Inferno Wires"};
    private final String[] nemesisAddons = {"Shattered S.T.A.R.S. Badge", "Iridescent Umbrella Badge", "Ne-a Parasite", "Jill's Sandwich", "Depleted Ink Ribbon", "Broken Revovery Coin", "Tyrant Gore", "T-Virus Sample", "Serotonin Injector", "Plant 43 Vines", "Licker Tongue", "Zombie Heart", "Mikail's Eye", "Marvin's Blood", "Adrenaline Injector", "Admin Wristband", "Visitor Wristband", "S.T.A.R.S. Field Combat Manual", "Damaged Syringe", "Brian's Intestine"};
    private final String[] cenobiteAddons = {"Iridescent Lament Configuration", "Engineer's Fang", "Original Pain", "Impailing Wire", "Greasy Black Lens", "Chatterer's Tooth", "Torture Pillar", "Slice of Frank", "Larry's Remains", "Larry's Blood", "Frank's Heart", "Wriggling Maggots", "Spoiled Meal", "Skewered Rat", "Liquified Gore", "Flickering Television", "Lively Crickets", "Leather Strap", "Burning Candle", "Bent Nail"};
    private final String[] artistAddons = {"Iridescent Feather", "Garden of Rot", "Severed Tongue", "Severed Hands", "Matias' Baby Shoes", "Ink Egg", "Thorny Nest", "Silver Bell", "O Grief, O Lover", "Darkest Ink", "Charcoal Stick", "Velvet Fabric", "Untitled Agony", "Still Life Crow", "Festering Carrion", "Automatic Drawing", "Vibrant Obituary", "Thick Tar", "Oil Paints", "Choclo Corn"};
    private final String[] onryoAddons = {"Remote Control", "Iridescent Videotape", "VCR", "Telephone", "Tape Editing Deck", "Distorted Photo", "Well Water", "Ring Drawing", "Rickety Pinwheel", "Mother's Comb", "Bloody Fingernails", "Yoichi's Fishing Net", "Well Stone", "Sea-Soaked Cloth", "Reiko's Waych", "Clump of Hair", "Videotape Copy", "Old Newspaper", "Mother's Mirror", "Cabin Sign"};
    private final String[] dredgeAddons = {"Sacrificial Knife", "Iridescent Wooden Plank", "Tiling Blade", "Lavalier Microphone", "Field Recorder", "Boat Key", "Worry Stone", "War Helmet", "Ottomarian Writing", "Destroyed Pillow", "Broken Doll", "Malthinker's Skull", "Haddie's Calendar", "Fallen Shingle", "Burnt Letters", "Air Freshener", "Wooden Plank", "Mortar and Pestle", "Follower's Cowel", "Caffeine Tablets"};
    private final String[] mastermindAddons = {"Lab Photo", "Iridescent Uroboros Vial", "Uroboros Virus", "Helicopter Stick", "Green Herb", "Dark Sunglasses", "Video Conference Device", "Red Herb", "Portable Safe", "Maiden Medallion", "Egg (Gold)", "Loose Crank", "Lion Medallion", "Leather Gloves", "Chalice (Gold)", "Bullhorn", "Uroboros Tendril", "Unicorn Medallion", "R.P.D. Shoulder Walkie", "Jewel Beetle"};
    private final String[] knightAddons = {"Knight's Contract", "Iridescent Company Banner", "Jailer's Chimes", "Healing Poltice", "Flint and Steel", "Blacksmith's Hammer", "Town Watche's Torch", "Sharpened Mount", "Iron Worker's Tongs", "Grim Iron Mask", "Broken Hilt", "Treated Blade", "Dried Horsemeat", "Cold Steel Manacles", "Call to Arms", "Battle Axe Head", "Tattered Tabard", "Pillaged Mead", "Map of The Realm", "Gritty Lump"};
    private final String[] skullMerchantAddons = {"Iridescent Unpublished Manuscript", "Expired Batteries", "Randomised Strobes", "Prototype Rotor", "Geographical Readout", "Advanced Movement Prediction", "Vital Targetting Processor", "Powdered Glass", "Loose Screw", "Infrared Upgrade", "Brown Noise Generator", "Supercharge", "Stereo Remote Mic", "Shotgun Speakers", "Low-Power Mode", "Adaptive Lighting", "Ultrasonic Speaker", "High-Power Floodlight", "High-Current Upgrade", "Adi Valente Issue 1"};
    private final String[] singularityAddons = {"Iridescent Crystal Shard", "Denied Requisition Form", "Soma Family Photo", "Foreign Plant Fibers", "Diagnostic Tool (Construction)", "Crew Manifest", "Spent Oxygen Tank", "Nanomachine Gel", "Live Wires", "Hyperawareness Spray", "Hologram Generator", "Ultrasonic Sensor", "Kid's Ball Glove", "Cryo Gel", "Cremated Remains", "Android Arm", "Nutritional Slurry", "Heavy Water", "Diagnostic Tool (Repair)", "Broken Security Key"};
    private final String[] xenomorphAddons = {"Improvised Cattle Prod", "Acidic Blood", "Semiotic Keyboard", "Self-Destruct Bolt", "Harpoon Gun", "Cat Carrier", "Parker's Headband", "Multipurpose Hatchet", "Moulted Skin", "Cane's Helmet", "Emergency Helmet", "Light Wand", "Lambert's Star Map", "Crew Headset", "Brett's Cap", "Ash's Innards", "Ripley's Watch", "Ovomorph", "Drinking Bird", "Cereal Rations"};
    private final String[] goodGuyAddons = {"Iridescent Amulet", "Hard Hat", "Straight Razor", "Plastic Bag", "Pile of Nails", "Mirror Shards", "Yardstick", "Silk Pillow", "Running Shoes", "Rat Poison", "Portable TV", "Power Drill", "Jump Rope", "Hair Spray & Candle", "Electric Carving Knife", "Automatic Skrewdriver", "Tiny Scalpel", "Strobing Light", "Good Guy Box", "Doll Eyes"};
    private final String[] unknownAddons = {"Iridescent OSS Report", "Captured by the Dark", "Serum Vial", "Obscure Game Cartridge", "Homemade Mask", "Discarded Milk Carton", "Vanishing Box", "Hypnotist's Watch", "Front-Page Article", "Footprint Cast", "B-Movie Poster", "Victim's Map", "Slashed Backpack", "Notebook of Theories", "Last Known Recording", "Device of Undisclosed Origin", "Sketch Attempt", "Rabbit's Foot", "Punctured Eyeball", "Blurry Photo"};
    private final String[] lichAddons = {"Vorpal Sword", "Iridescent Book of Vile Darkness", "Robe of Eyes", "Dragontooth Dagger", "Cloak of Invisibility", "Bag of Holding", "Staff of Withering", "Pearl of Power", "Ornate Horn", "Cloak of Elvenkind", "Boots of Speed", "Ring of Telekinesis", "Ring of Spell Storing", "Potion of Speed", "Lantern of Revealing", "Glass Eye", "Trickster's Gloves", "Tattered Headband", "Raven's Feather", "Crystal Ball"};
    private final String[] darkLordAddons = {"Iridescent Ring of Vlad", "Alucard's Shield", "Warg's Fang", "Medusa's Hair", "Lapis Lazuli", "Cube of Zoe", "Sylph Feather", "Sunglasses", "Pocket Watch", "Killer Doll", "Force of Echo", "Winged Boots", "White Wolf Medallion", "Moonstone Necklace", "Magical Ticket", "Blood-Filled Goblet", "Traveller's Hat", "Ruby Circlet", "Clock Tower Gear", "Cerberus Talon"};
    private final String[] houndmasterAddons = {"Torn Novel", "Iridescent Wheel Handle", "Ship Figurehead", "Marlin Spike", "Leather Harness", "Gunpowder Tin", "Waterskin", "Unfinished Map", "Training Bell", "Spiked Collar", "Fatty Meat", "Spyglass", "Smoked Snapper", "Knotted Rope", "Belaying Pins", "Barley Meal", "Young Coconut", "Trainer's Book", "Sticky Pitch", "Creature's Bones"};
    private final String[] ghoulAddons = {"Yamori's Mask", "Iridescent Eye Patch", "Torture Apparatus", "Red-Headed Centipede", "Fresh Coffee", "CCG ID Card", "Reze's Glasses", "Red Spider Lily", "Mado's Gloves", "Aogiri Tree Robe", "Amon's Necktie", "Kaneki's Satchel", "Hinami's Umbrella", "Hide's Headphones", "Broken Chain", "Blood-Stained Hankerchief", "The Black Goat's Egg", "Taiyaki", "Kaneki's Wallet", "Anteiku Apron"};
    private final String[] animatronicAddons = {"Iridescent Remnant", "Faz-coin", "Loot Bag", "Endo CPU", "Celebrate! Poster", "Access Panel", "Purple Guy Drawing", "Freddy's Hat", "Foxy's Hook", "Chica's Bib", "Bonnie's Guitar Strings", "Streamers", "Security Guard Badge", "Ripped Curtain", "Party Hat", "Office Phone", "Rotten Pizza", "Resturant Menu", "Help Wanted Ad", "Greasy Paper Plate"};
    private final String[] krasueAddons = {"Shredded Gown", "Chicken Head", "Rotten Swine", "Queen's Sceptre", "Mysterious Elixir", "Lorenza's Remains", "Theatre Binoculars", "Spattered Hankerchief", "Janjira's Hand", "Framed Newspaper", "Dulled Knife", "Wriggling Parasite", "Pig's Eye", "Defective Metronome", "Crumpled Sheet Music", "Chunk of Malai", "Sticky Lozenge", "Luckless Mouse", "First Libretto", "Broken Tiara"};
    private final String[] firstAddons = {"Iridescent Sotaria Chip", "Chess Piece", "Pizza Goggles", "Electroshock Collar", "Broken Skateboard", "Black Widow Spider", "Victor's Razor Blade", "Rabbit Remains", "Neck Tendril", "Forged Death Certificate", "Electrode Cap", "Smashed Cassete Deck", "Mid-Century Radio", "Gutted Supercom", "Clock Hands", "Bloody Roller Skate", "Stained Glass Mural", "Shattered Wrist Rocket", "Orderly ID", "Bead Maze"};

    public DeadByDaylightRandomizer() {
        // General
        addKillers();
        addKillerPerks();
        addSurvivorItems();
        addSurvivorPerks();

        //Survivor Addons
        addFlashlightAddons();
        addKeyAddons();
        addMapAddons();
        addMedkitAddons();
        addToolboxAddons();
        addFogVialAddons();

        //Killer Addons
        addTrapperAddons();
        addWraithAddons();
        addHillbillyAddons();
        addNurseAddons();
        addShapeAddons();
        addHagAddons();
        addDoctorAddons();
        addHuntressAddons();
        addCannibalAddons();
        addNightmareAddons();
        addPigAddons();
        addClownAddons();
        addSpiritAddons();
        addLegionAddons();
        addPlagueAddons();
        addGhostFaceAddons();
        addDemogorgonAddons();
        addOniAddons();
        addDeathSlingerAddons();
        addExecutionerAddons();
        addBlightAddons();
        addTwinsAddons();
        addTricksterAddons();
        addNemesisAddons();
        addCenobiteAddons();
        addArtistAddons();
        addOnryoAddons();
        addDredgeAddons();
        addMastermindAddons();
        addKnightAddons();
        addSkullMerchantAddons();
        addSingularityAddons();
        addXenomorphAddons();
        addGoodGuyAddons();
        addUnknownAddons();
        addLichAddons();
        addDarkLordAddons();
        addHoundmasterAddons();
        addGhoulAddons();
        addAnimatronicAddons();
        addKrasueAddons();
        addFirstAddons();
    }

    public void activateProgram(boolean quit, Random rand, Scanner input) {
        boolean validInput = false;
        System.out.println("Survivor or Killer loadout? (s/k)");
        int roleChoice = 0;
        
        while(!validInput){
            try{
                input = new Scanner(System.in);
                String response = input.nextLine();
                switch (response) {
                    case "s":
                        validInput = true;
                        roleChoice = 1;
                        break;
                    case "k":
                        validInput = true;
                        roleChoice = 2;
                        break;
                    default:
                        throw new InvalidInputException("Invalid input. Please enter 's' or 'k'.");
                }
            } catch(InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }

        //Survivor Randomizer
        while((quit == false) && (roleChoice == 1)){
            int trackSurvivorItems = rand.nextInt(activeSurvivorItems.size());
            int addonCount = 0;
            String survivorItem = activeSurvivorItems.get(trackSurvivorItems);
            activeSurvivorItems.remove(trackSurvivorItems);
            
            System.out.println("Your random survivor item is: " + survivorItem);

            if(survivorItem.equals("Flashlight") || survivorItem.equals("Sport Flashlight") || survivorItem.equals("Utility Flashlight")){
                String flashlightAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeFlashlightAddons.size() > 0){
                        int trackFlashlightAddons = rand.nextInt(activeFlashlightAddons.size());
                        flashlightAddon[addonCount] = activeFlashlightAddons.get(trackFlashlightAddons);
                        activeFlashlightAddons.remove(trackFlashlightAddons);
                    }
                    else{
                        System.out.println("All flashlight addons have been used and need more, Reloading flashlight addon list...");
                        addFlashlightAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your flashlight addons are: " + flashlightAddon[0] + " and " + flashlightAddon[1]);
            }

            else if(survivorItem.equals("Broken Key") || survivorItem.equals("Dull Key") || survivorItem.equals("Skeleton Key")){
                String keyAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeKeyAddons.size() > 0){
                        int trackKeyAddons = rand.nextInt(activeKeyAddons.size());
                        keyAddon[addonCount] = activeKeyAddons.get(trackKeyAddons);
                        activeKeyAddons.remove(trackKeyAddons);
                    }
                    else{
                        System.out.println("All key addons have been used and need more, Reloading key addon list...");
                        addKeyAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your key addons are: " + keyAddon[0] + " and " + keyAddon[1]);
            }

            else if(survivorItem.equals("Apprentice's Fog Vial") || survivorItem.equals("Artisan's Fog Vial") || survivorItem.equals("Vigo's Fog Vial")){
                String fogVialAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeFogVialAddons.size() > 0){
                        int trackFogVialAddons = rand.nextInt(activeFogVialAddons.size());
                        fogVialAddon[addonCount] = activeFogVialAddons.get(trackFogVialAddons);
                        activeFogVialAddons.remove(trackFogVialAddons);
                    }
                    else{
                        System.out.println("All fog vial addons have been used and need more, Reloading fog vial addon list...");
                        addFogVialAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your fog vial addons are: " + fogVialAddon[0] + " and " + fogVialAddon[1]);
            }

            else if(survivorItem.equals("Cryptic Map") || survivorItem.equals("Scribbled Map") || survivorItem.equals("Annotated Map")){
                String mapAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeMapAddons.size() > 0){
                        int trackMapAddons = rand.nextInt(activeMapAddons.size());
                        mapAddon[addonCount] = activeMapAddons.get(trackMapAddons);
                        activeMapAddons.remove(trackMapAddons);
                    }
                    else{
                        System.out.println("All map addons have been used and need more, Reloading map addon list...");
                        addMapAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your map addons are: " + mapAddon[0] + " and " + mapAddon[1]);
            }

            else if(survivorItem.equals("Camping Aid Kit") || survivorItem.equals("First Aid Kit") || survivorItem.equals("Emergency Med-Kit") || survivorItem.equals("Ranger Med-Kit")){
                String medkitAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeMedkitAddons.size() > 0){
                        int trackMedkitAddons = rand.nextInt(activeMedkitAddons.size());
                        medkitAddon[addonCount] = activeMedkitAddons.get(trackMedkitAddons);
                        activeMedkitAddons.remove(trackMedkitAddons);
                    }
                    else{
                        System.out.println("All med-kit addons have been used and need more, Reloading med-kit addon list...");
                        addMedkitAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your med-kit addons are: " + medkitAddon[0] + " and " + medkitAddon[1]);
            }

            else{
                String toolboxAddon[] = new String[2];
                while(addonCount < 2){
                    if(activeToolboxAddons.size() > 0){
                        int trackToolboxAddons = rand.nextInt(activeToolboxAddons.size());
                        toolboxAddon[addonCount] = activeToolboxAddons.get(trackToolboxAddons);
                        activeToolboxAddons.remove(trackToolboxAddons);
                    }
                    else{
                        System.out.println("All toolbox addons have been used and need more, Reloading toolbox addon list...");
                        addToolboxAddons();
                        addonCount--;
                    }
                    addonCount++;
                }
                System.out.println("Your toolbox addons are: " + toolboxAddon[0] + " and " + toolboxAddon[1]);
            }

            if(activeSurvivorPerks.size() > 3){
                int trackSurvivorPerks = rand.nextInt(activeSurvivorPerks.size());
                String survivorPerk1 = activeSurvivorPerks.get(trackSurvivorPerks);
                activeSurvivorPerks.remove(trackSurvivorPerks);

                trackSurvivorPerks = rand.nextInt(activeSurvivorPerks.size());
                String survivorPerk2 = activeSurvivorPerks.get(trackSurvivorPerks);
                activeSurvivorPerks.remove(trackSurvivorPerks);

                trackSurvivorPerks = rand.nextInt(activeSurvivorPerks.size());
                String survivorPerk3 = activeSurvivorPerks.get(trackSurvivorPerks);
                activeSurvivorPerks.remove(trackSurvivorPerks);

                trackSurvivorPerks = rand.nextInt(activeSurvivorPerks.size());
                String survivorPerk4 = activeSurvivorPerks.get(trackSurvivorPerks);
                activeSurvivorPerks.remove(trackSurvivorPerks);

                System.out.println("Your random survivor perks are: " + survivorPerk1 + ", " + survivorPerk2 + ", " + survivorPerk3 + ", " + survivorPerk4);
            }

            else{
                String[] loadout = new String[4];
                int i = 0;
                while(activeSurvivorPerks.size() > 0){
                    loadout[i] = activeSurvivorPerks.get(0);
                    activeSurvivorPerks.remove(0);
                    i++;
                }

                System.out.println("All survivor perks have been used and need more, Reloading survivor perk list...");
                addSurvivorPerks();

                while(i < 4){
                    int trackSurvivorPerk = rand.nextInt(activeSurvivorPerks.size());
                    String survivorPerk = activeSurvivorPerks.get(trackSurvivorPerk);
                    activeSurvivorPerks.remove(trackSurvivorPerk);
                    loadout[i] = survivorPerk;
                    i++;
                }

                System.out.println("Your random survivor perks are: " + loadout[0] + ", " + loadout[1] + ", " + loadout[2] + ", " + loadout[3]);
            }
            validInput = false;

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

            if(activeSurvivorPerks.size() == 0){
                System.out.println("All survivor perks have been used, Reloading survivor perk list...");
                addSurvivorPerks();
            }

            if(activeSurvivorItems.size() == 0){
                System.out.println("All survivor items have been used, Reloading survivor item list...");
                addSurvivorItems();
            }
        }

        //Killer Randomizer
        while((quit == false) && (roleChoice == 2)){
            //Killer
            int trackKillers = rand.nextInt(activeKillers.size());
            String killer = activeKillers.get(trackKillers);
            activeKillers.remove(trackKillers);

            validInput = false;

            System.out.println("Your random loadout is:");
            System.out.println("Killer: " + killer);

            //Perks
            if(activeKillerPerks.size() > 3){
                int trackKillerPerks = rand.nextInt(activeKillerPerks.size());
                String KillerPerk1 = activeKillerPerks.get(trackKillerPerks);
                activeKillerPerks.remove(trackKillerPerks);

                trackKillerPerks = rand.nextInt(activeKillerPerks.size());
                String KillerPerk2 = activeKillerPerks.get(trackKillerPerks);
                activeKillerPerks.remove(trackKillerPerks);

                trackKillerPerks = rand.nextInt(activeKillerPerks.size());
                String KillerPerk3 = activeKillerPerks.get(trackKillerPerks);
                activeKillerPerks.remove(trackKillerPerks);

                trackKillerPerks = rand.nextInt(activeKillerPerks.size());
                String KillerPerk4 = activeKillerPerks.get(trackKillerPerks);
                activeKillerPerks.remove(trackKillerPerks);

                System.out.println("Your random killer perks are: " + KillerPerk1 + ", " + KillerPerk2 + ", " + KillerPerk3 + ", " + KillerPerk4);
            }

            else{
                String[] loadout = new String[4];
                int i = 0;
                while(activeKillerPerks.size() > 0){
                    loadout[i] = activeKillerPerks.get(0);
                    activeKillerPerks.remove(0);
                    i++;
                }

                System.out.println("All killer perks have been used and need more, Reloading killer perk list...");
                addKillerPerks();

                while(i < 4){
                    int trackKillerPerk = rand.nextInt(activeKillerPerks.size());
                    String killerPerk = activeKillerPerks.get(trackKillerPerk);
                    activeKillerPerks.remove(trackKillerPerk);
                    loadout[i] = killerPerk;
                    i++;
                }

                System.out.println("Your random killer perks are: " + loadout[0] + ", " + loadout[1] + ", " + loadout[2] + ", " + loadout[3]);
            }

            //Add-ons
            int trackAddon = 0;
            String addon1 = "";
            String addon2 = "";

            if(killer.equals("Trapper")){
                if(activeTrapperAddons.size() == 0){
                    addTrapperAddons();
                }

                trackAddon = rand.nextInt(activeTrapperAddons.size());
                addon1 = activeTrapperAddons.get(trackAddon);
                activeTrapperAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeTrapperAddons.size());
                addon2 = activeTrapperAddons.get(trackAddon);
                activeTrapperAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Wraith")){
                if(activeWraithAddons.size() == 0){
                    addWraithAddons();
                }

                trackAddon = rand.nextInt(activeWraithAddons.size());
                addon1 = activeWraithAddons.get(trackAddon);
                activeWraithAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeWraithAddons.size());
                addon2 = activeWraithAddons.get(trackAddon);
                activeWraithAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Hillbilly")){
                if(activeHillbillyAddons.size() == 0){
                    addHillbillyAddons();
                }
                
                trackAddon = rand.nextInt(activeHillbillyAddons.size());
                addon1 = activeHillbillyAddons.get(trackAddon);
                activeHillbillyAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeHillbillyAddons.size());
                addon2 = activeHillbillyAddons.get(trackAddon);
                activeHillbillyAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }
            
            else if(killer.equals("Nurse")){
                if(activeNurseAddons.size() == 0){
                    addNurseAddons();
                }
                
                trackAddon = rand.nextInt(activeNurseAddons.size());
                addon1 = activeNurseAddons.get(trackAddon);
                activeNurseAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeNurseAddons.size());
                addon2 = activeNurseAddons.get(trackAddon);
                activeNurseAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Shape")){
                if(activeShapeAddons.size() == 0){
                    addShapeAddons();
                }
                
                trackAddon = rand.nextInt(activeShapeAddons.size());
                addon1 = activeShapeAddons.get(trackAddon);
                activeShapeAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeShapeAddons.size());
                addon2 = activeShapeAddons.get(trackAddon);
                activeShapeAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Hag")){
                if(activeHagAddons.size() == 0){
                    addHagAddons();
                }
                
                trackAddon = rand.nextInt(activeHagAddons.size());
                addon1 = activeHagAddons.get(trackAddon);
                activeHagAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeHagAddons.size());
                addon2 = activeHagAddons.get(trackAddon);
                activeHagAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Doctor")){
                if(activeDoctorAddons.size() == 0){
                    addDoctorAddons();
                }
                
                trackAddon = rand.nextInt(activeDoctorAddons.size());
                addon1 = activeDoctorAddons.get(trackAddon);
                activeDoctorAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeDoctorAddons.size());
                addon2 = activeDoctorAddons.get(trackAddon);
                activeDoctorAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Huntress")){
                if(activeHuntressAddons.size() == 0){
                    addHuntressAddons();
                }
                
                trackAddon = rand.nextInt(activeHuntressAddons.size());
                addon1 = activeHuntressAddons.get(trackAddon);
                activeHuntressAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeHuntressAddons.size());
                addon2 = activeHuntressAddons.get(trackAddon);
                activeHuntressAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Cannibal")){
                if(activeCannibalAddons.size() == 0){
                    addCannibalAddons();
                }
                
                trackAddon = rand.nextInt(activeCannibalAddons.size());
                addon1 = activeCannibalAddons.get(trackAddon);
                activeCannibalAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeCannibalAddons.size());
                addon2 = activeCannibalAddons.get(trackAddon);
                activeCannibalAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Nightmare")){
                if(activeNightmareAddons.size() == 0){
                    addNightmareAddons();
                }
                
                trackAddon = rand.nextInt(activeNightmareAddons.size());
                addon1 = activeNightmareAddons.get(trackAddon);
                activeNightmareAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeNightmareAddons.size());
                addon2 = activeNightmareAddons.get(trackAddon);
                activeNightmareAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Pig")){
                if(activePigAddons.size() == 0){
                    addPigAddons();
                }
                
                trackAddon = rand.nextInt(activePigAddons.size());
                addon1 = activePigAddons.get(trackAddon);
                activePigAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activePigAddons.size());
                addon2 = activePigAddons.get(trackAddon);
                activePigAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Clown")){
                if(activeClownAddons.size() == 0){
                    addClownAddons();
                }
                
                trackAddon = rand.nextInt(activeClownAddons.size());
                addon1 = activeClownAddons.get(trackAddon);
                activeClownAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeClownAddons.size());
                addon2 = activeClownAddons.get(trackAddon);
                activeClownAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Spirit")){
                if(activeSpiritAddons.size() == 0){
                    addSpiritAddons();
                }
                
                trackAddon = rand.nextInt(activeSpiritAddons.size());
                addon1 = activeSpiritAddons.get(trackAddon);
                activeSpiritAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeSpiritAddons.size());
                addon2 = activeSpiritAddons.get(trackAddon);
                activeSpiritAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Legion")){
                if(activeLegionAddons.size() == 0){
                    addLegionAddons();
                }
                
                trackAddon = rand.nextInt(activeLegionAddons.size());
                addon1 = activeLegionAddons.get(trackAddon);
                activeLegionAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeLegionAddons.size());
                addon2 = activeLegionAddons.get(trackAddon);
                activeLegionAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Plague")){
                if(activePlagueAddons.size() == 0){
                    addPlagueAddons();
                }
                
                trackAddon = rand.nextInt(activePlagueAddons.size());
                addon1 = activePlagueAddons.get(trackAddon);
                activePlagueAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activePlagueAddons.size());
                addon2 = activePlagueAddons.get(trackAddon);
                activePlagueAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Ghost Face")){
                if(activeGhostFaceAddons.size() == 0){
                    addGhostFaceAddons();
                }
                
                trackAddon = rand.nextInt(activeGhostFaceAddons.size());
                addon1 = activeGhostFaceAddons.get(trackAddon);
                activeGhostFaceAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeGhostFaceAddons.size());
                addon2 = activeGhostFaceAddons.get(trackAddon);
                activeGhostFaceAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Demogorgon")){
                if(activeDemogorgonAddons.size() == 0){
                    addDemogorgonAddons();
                }
                
                trackAddon = rand.nextInt(activeDemogorgonAddons.size());
                addon1 = activeDemogorgonAddons.get(trackAddon);
                activeDemogorgonAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeDemogorgonAddons.size());
                addon2 = activeDemogorgonAddons.get(trackAddon);
                activeDemogorgonAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Oni")){
                if(activeOniAddons.size() == 0){
                    addOniAddons();
                }
                
                trackAddon = rand.nextInt(activeOniAddons.size());
                addon1 = activeOniAddons.get(trackAddon);
                activeOniAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeOniAddons.size());
                addon2 = activeOniAddons.get(trackAddon);
                activeOniAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Death Slinger")){
                if(activeDeathSlingerAddons.size() == 0){
                    addDeathSlingerAddons();
                }
                
                trackAddon = rand.nextInt(activeDeathSlingerAddons.size());
                addon1 = activeDeathSlingerAddons.get(trackAddon);
                activeDeathSlingerAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeDeathSlingerAddons.size());
                addon2 = activeDeathSlingerAddons.get(trackAddon);
                activeDeathSlingerAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Executioner")){
                if(activeExecutionerAddons.size() == 0){
                    addExecutionerAddons();
                }
                
                trackAddon = rand.nextInt(activeExecutionerAddons.size());
                addon1 = activeExecutionerAddons.get(trackAddon);
                activeExecutionerAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeExecutionerAddons.size());
                addon2 = activeExecutionerAddons.get(trackAddon);
                activeExecutionerAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Blight")){
                if(activeBlightAddons.size() == 0){
                    addBlightAddons();
                }
                
                trackAddon = rand.nextInt(activeBlightAddons.size());
                addon1 = activeBlightAddons.get(trackAddon);
                activeBlightAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeBlightAddons.size());
                addon2 = activeBlightAddons.get(trackAddon);
                activeBlightAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Twins")){
                if(activeTwinsAddons.size() == 0){
                    addTwinsAddons();
                }
                
                trackAddon = rand.nextInt(activeTwinsAddons.size());
                addon1 = activeTwinsAddons.get(trackAddon);
                activeTwinsAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeTwinsAddons.size());
                addon2 = activeTwinsAddons.get(trackAddon);
                activeTwinsAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Trickster")){
                if(activeTricksterAddons.size() == 0){
                    addTricksterAddons();
                }

                trackAddon = rand.nextInt(activeTricksterAddons.size());
                addon1 = activeTricksterAddons.get(trackAddon);
                activeTricksterAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeTricksterAddons.size());
                addon2 = activeTricksterAddons.get(trackAddon);
                activeTricksterAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Nemesis")){
                if(activeNemesisAddons.size() == 0){
                    addNemesisAddons();
                }

                trackAddon = rand.nextInt(activeNemesisAddons.size());
                addon1 = activeNemesisAddons.get(trackAddon);
                activeNemesisAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeNemesisAddons.size());
                addon2 = activeNemesisAddons.get(trackAddon);
                activeNemesisAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Cenobite")){
                if(activeCenobiteAddons.size() == 0){
                    addCenobiteAddons();
                }

                trackAddon = rand.nextInt(activeCenobiteAddons.size());
                addon1 = activeCenobiteAddons.get(trackAddon);
                activeCenobiteAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeCenobiteAddons.size());
                addon2 = activeCenobiteAddons.get(trackAddon);
                activeCenobiteAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Artist")){
                if(activeArtistAddons.size() == 0){
                    addArtistAddons();
                }

                trackAddon = rand.nextInt(activeArtistAddons.size());
                addon1 = activeArtistAddons.get(trackAddon);
                activeArtistAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeArtistAddons.size());
                addon2 = activeArtistAddons.get(trackAddon);
                activeArtistAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Onryo")){
                if(activeOnryoAddons.size() == 0){
                    addOnryoAddons();
                }

                trackAddon = rand.nextInt(activeOnryoAddons.size());
                addon1 = activeOnryoAddons.get(trackAddon);
                activeOnryoAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeOnryoAddons.size());
                addon2 = activeOnryoAddons.get(trackAddon);
                activeOnryoAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }
            
            else if(killer.equals("Dredge")){
                if(activeDredgeAddons.size() == 0){
                    addDredgeAddons();
                }

                trackAddon = rand.nextInt(activeDredgeAddons.size());
                addon1 = activeDredgeAddons.get(trackAddon);
                activeDredgeAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeDredgeAddons.size());
                addon2 = activeDredgeAddons.get(trackAddon);
                activeDredgeAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Mastermind")){
                if(activeMastermindAddons.size() == 0){
                    addMastermindAddons();
                }

                trackAddon = rand.nextInt(activeMastermindAddons.size());
                addon1 = activeMastermindAddons.get(trackAddon);
                activeMastermindAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeMastermindAddons.size());
                addon2 = activeMastermindAddons.get(trackAddon);
                activeMastermindAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Knight")){
                if(activeKnightAddons.size() == 0){
                    addKnightAddons();
                }

                trackAddon = rand.nextInt(activeKnightAddons.size());
                addon1 = activeKnightAddons.get(trackAddon);
                activeKnightAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeKnightAddons.size());
                addon2 = activeKnightAddons.get(trackAddon);
                activeKnightAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Skull Merchant")){
                if(activeSkullMerchantAddons.size() == 0){
                    addTricksterAddons();
                }

                trackAddon = rand.nextInt(activeSkullMerchantAddons.size());
                addon1 = activeSkullMerchantAddons.get(trackAddon);
                activeSkullMerchantAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeSkullMerchantAddons.size());
                addon2 = activeSkullMerchantAddons.get(trackAddon);
                activeSkullMerchantAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Singularity")){
                if(activeSingularityAddons.size() == 0){
                    addSingularityAddons();
                }

                trackAddon = rand.nextInt(activeSingularityAddons.size());
                addon1 = activeSingularityAddons.get(trackAddon);
                activeSingularityAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeSingularityAddons.size());
                addon2 = activeSingularityAddons.get(trackAddon);
                activeSingularityAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Xenomorph")){
                if(activeXenomorphAddons.size() == 0){
                    addXenomorphAddons();
                }

                trackAddon = rand.nextInt(activeXenomorphAddons.size());
                addon1 = activeXenomorphAddons.get(trackAddon);
                activeXenomorphAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeXenomorphAddons.size());
                addon2 = activeXenomorphAddons.get(trackAddon);
                activeXenomorphAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Good Guy")){
                if(activeGoodGuyAddons.size() == 0){
                    addGoodGuyAddons();
                }

                trackAddon = rand.nextInt(activeGoodGuyAddons.size());
                addon1 = activeGoodGuyAddons.get(trackAddon);
                activeGoodGuyAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeGoodGuyAddons.size());
                addon2 = activeGoodGuyAddons.get(trackAddon);
                activeGoodGuyAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Unknown")){
                if(activeUnknownAddons.size() == 0){
                    addUnknownAddons();
                }

                trackAddon = rand.nextInt(activeUnknownAddons.size());
                addon1 = activeUnknownAddons.get(trackAddon);
                activeUnknownAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeUnknownAddons.size());
                addon2 = activeUnknownAddons.get(trackAddon);
                activeUnknownAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Lich")){
                if(activeLichAddons.size() == 0){
                    addLichAddons();
                }

                trackAddon = rand.nextInt(activeLichAddons.size());
                addon1 = activeLichAddons.get(trackAddon);
                activeLichAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeLichAddons.size());
                addon2 = activeLichAddons.get(trackAddon);
                activeLichAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Dark Lord")){
                if(activeDarkLordAddons.size() == 0){
                    addDarkLordAddons();
                }

                trackAddon = rand.nextInt(activeDarkLordAddons.size());
                addon1 = activeDarkLordAddons.get(trackAddon);
                activeDarkLordAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeDarkLordAddons.size());
                addon2 = activeDarkLordAddons.get(trackAddon);
                activeDarkLordAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Houndmaster")){
                if(activeHoundmasterAddons.size() == 0){
                    addHoundmasterAddons();
                }

                trackAddon = rand.nextInt(activeHoundmasterAddons.size());
                addon1 = activeHoundmasterAddons.get(trackAddon);
                activeHoundmasterAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeHoundmasterAddons.size());
                addon2 = activeHoundmasterAddons.get(trackAddon);
                activeHoundmasterAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Ghoul")){
                if(activeGhoulAddons.size() == 0){
                    addGhoulAddons();
                }

                trackAddon = rand.nextInt(activeGhoulAddons.size());
                addon1 = activeGhoulAddons.get(trackAddon);
                activeGhoulAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeGhoulAddons.size());
                addon2 = activeGhoulAddons.get(trackAddon);
                activeGhoulAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Animatronic")){
                if(activeAnimatronicAddons.size() == 0){
                    addAnimatronicAddons();
                }

                trackAddon = rand.nextInt(activeAnimatronicAddons.size());
                addon1 = activeAnimatronicAddons.get(trackAddon);
                activeAnimatronicAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeAnimatronicAddons.size());
                addon2 = activeAnimatronicAddons.get(trackAddon);
                activeAnimatronicAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("Krasue")){
                if(activeKrasueAddons.size() == 0){
                    addKrasueAddons();
                }

                trackAddon = rand.nextInt(activeKrasueAddons.size());
                addon1 = activeKrasueAddons.get(trackAddon);
                activeKrasueAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeKrasueAddons.size());
                addon2 = activeKrasueAddons.get(trackAddon);
                activeKrasueAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else if(killer.equals("First")){
                if(activeFirstAddons.size() == 0){
                    addFirstAddons();
                }

                trackAddon = rand.nextInt(activeFirstAddons.size());
                addon1 = activeFirstAddons.get(trackAddon);
                activeFirstAddons.remove(trackAddon);

                trackAddon = rand.nextInt(activeFirstAddons.size());
                addon2 = activeFirstAddons.get(trackAddon);
                activeFirstAddons.remove(trackAddon);

                System.out.println("Your random killer addons are: " + addon1 + " and " + addon2);
            }

            else{
                System.out.println("Killer addons cannot be decided for killers with no addons yet.");
            }

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

            if(activeKillers.size() == 0){
                System.out.println("All killers have been used, Reloading killer list...");
                addKillers();
            }
        }
    }

    //General Reload Methods

    public void addKillers(){
        for(int i = 0; i < killers.length; i++){
            activeKillers.add(killers[i]);
        }
    }

    public void addKillerPerks(){
        for(int i = 0; i < killerPerks.length; i++){
            activeKillerPerks.add(killerPerks[i]);
        }
    }

    public void addSurvivorItems(){
        for(int i = 0; i < survivorItems.length; i++){
            activeSurvivorItems.add(survivorItems[i]);
        }
    }

    public void addSurvivorPerks(){
        for(int i = 0; i < survivorPerks.length; i++){
            activeSurvivorPerks.add(survivorPerks[i]);
        }
    }

    //Survivor Addon Reload Methods

    public void addFlashlightAddons(){
        for(int i = 0; i < flashlightAddons.length; i++){
            activeFlashlightAddons.add(flashlightAddons[i]);
        }
    }

    public void addKeyAddons(){
        for(int i = 0; i < keyAddons.length; i++){
            activeKeyAddons.add(keyAddons[i]);
        }
    }

    public void addMapAddons(){
        for(int i = 0; i < mapAddons.length; i++){
            activeMapAddons.add(mapAddons[i]);
        }
    }

    public void addMedkitAddons(){
        for(int i = 0; i < medkitAddons.length; i++){
            activeMedkitAddons.add(medkitAddons[i]);
        }
    }

    public void addToolboxAddons(){
        for(int i = 0; i < toolboxAddons.length; i++){
            activeToolboxAddons.add(toolboxAddons[i]);
        }
    }

    public void addFogVialAddons(){
        for(int i = 0; i < fogVialAddons.length; i++){
            activeFogVialAddons.add(fogVialAddons[i]);
        }
    }

    //Killer Addon Reload Methods

    public void addTrapperAddons(){
        for(int i = 0; i < trapperAddons.length; i++){
            activeTrapperAddons.add(trapperAddons[i]);
        }
    }

    public void addWraithAddons(){
        for(int i = 0; i < wraithAddons.length; i++){
            activeWraithAddons.add(wraithAddons[i]);
        }
    }

    public void addHillbillyAddons(){
        for(int i = 0; i < hillbillyAddons.length; i++){
            activeHillbillyAddons.add(hillbillyAddons[i]);
        }
    }

    public void addNurseAddons(){
        for(int i = 0; i < nurseAddons.length; i++){
            activeNurseAddons.add(nurseAddons[i]);
        }
    }

    public void addShapeAddons(){
        for(int i = 0; i < shapeAddons.length; i++){
            activeShapeAddons.add(shapeAddons[i]);
        }
    }

    public void addHagAddons(){
        for(int i = 0; i < hagAddons.length; i++){
            activeHagAddons.add(hagAddons[i]);
        }
    }

    public void addDoctorAddons(){
        for(int i = 0; i < doctorAddons.length; i++){
            activeDoctorAddons.add(doctorAddons[i]);
        }
    }

    public void addHuntressAddons(){
        for(int i = 0; i < huntressAddons.length; i++){
            activeHuntressAddons.add(huntressAddons[i]);
        }
    }

    public void addCannibalAddons(){
        for(int i = 0; i < cannibalAddons.length; i++){
            activeCannibalAddons.add(cannibalAddons[i]);
        }
    }

    public void addNightmareAddons(){
        for(int i = 0; i < nightmareAddons.length; i++){
            activeNightmareAddons.add(nightmareAddons[i]);
        }
    }

    public void addPigAddons(){
        for(int i = 0; i < pigAddons.length; i++){
            activePigAddons.add(pigAddons[i]);
        }
    }

    public void addClownAddons(){
        for(int i = 0; i < clownAddons.length; i++){
            activeClownAddons.add(clownAddons[i]);
        }
    }

    public void addSpiritAddons(){
        for(int i = 0; i < spiritAddons.length; i++){
            activeSpiritAddons.add(spiritAddons[i]);
        }
    }

    public void addLegionAddons(){
        for(int i = 0; i < legionAddons.length; i++){
            activeLegionAddons.add(legionAddons[i]);
        }
    }

    public void addPlagueAddons(){
        for(int i = 0; i < plagueAddons.length; i++){
            activePlagueAddons.add(plagueAddons[i]);
        }
    }

    public void addGhostFaceAddons(){
        for(int i = 0; i < ghostFaceAddons.length; i++){
            activeGhostFaceAddons.add(ghostFaceAddons[i]);
        }
    }

    public void addDemogorgonAddons(){
        for(int i = 0; i < demogorgonAddons.length; i++){
            activeDemogorgonAddons.add(demogorgonAddons[i]);
        }
    }

    public void addOniAddons(){
        for(int i = 0; i < oniAddons.length; i++){
            activeOniAddons.add(oniAddons[i]);
        }
    }

    public void addDeathSlingerAddons(){
        for(int i = 0; i < deathSlingerAddons.length; i++){
            activeDeathSlingerAddons.add(deathSlingerAddons[i]);
        }
    }

    public void addExecutionerAddons(){
        for(int i = 0; i < executionerAddons.length; i++){
            activeExecutionerAddons.add(executionerAddons[i]);
        }
    }

    public void addBlightAddons(){
        for(int i = 0; i < blightAddons.length; i++){
            activeBlightAddons.add(blightAddons[i]);
        }
    }

    public void addTwinsAddons(){
        for(int i = 0; i < twinsAddons.length; i++){
            activeTwinsAddons.add(twinsAddons[i]);
        }
    }

    public void addTricksterAddons(){
        for(int i = 0; i < tricksterAddons.length; i++){
            activeTricksterAddons.add(tricksterAddons[i]);
        }
    }

    public void addNemesisAddons(){
        for(int i = 0; i < nemesisAddons.length; i++){
            activeNemesisAddons.add(nemesisAddons[i]);
        }
    }

    public void addCenobiteAddons(){
        for(int i = 0; i < cenobiteAddons.length; i++){
            activeCenobiteAddons.add(cenobiteAddons[i]);
        }
    }

    public void addArtistAddons(){
        for(int i = 0; i < artistAddons.length; i++){
            activeArtistAddons.add(artistAddons[i]);
        }
    }

    public void addOnryoAddons(){
        for(int i = 0; i < onryoAddons.length; i++){
            activeOnryoAddons.add(onryoAddons[i]);
        }
    }

    public void addDredgeAddons(){
        for(int i = 0; i < dredgeAddons.length; i++){
            activeDredgeAddons.add(dredgeAddons[i]);
        }
    }

    public void addMastermindAddons(){
        for(int i = 0; i < mastermindAddons.length; i++){
            activeMastermindAddons.add(mastermindAddons[i]);
        }
    }

    public void addKnightAddons(){
        for(int i = 0; i < knightAddons.length; i++){
            activeKnightAddons.add(knightAddons[i]);
        }
    }

    public void addSkullMerchantAddons(){
        for(int i = 0; i < skullMerchantAddons.length; i++){
            activeSkullMerchantAddons.add(skullMerchantAddons[i]);
        }
    }

    public void addSingularityAddons(){
        for(int i = 0; i < singularityAddons.length; i++){
            activeSingularityAddons.add(singularityAddons[i]);
        }
    }

    public void addXenomorphAddons(){
        for(int i = 0; i < xenomorphAddons.length; i++){
            activeXenomorphAddons.add(xenomorphAddons[i]);
        }
    }

    public void addGoodGuyAddons(){
        for(int i = 0; i < goodGuyAddons.length; i++){
            activeGoodGuyAddons.add(goodGuyAddons[i]);
        }
    }

    public void addUnknownAddons(){
        for(int i = 0; i < unknownAddons.length; i++){
            activeUnknownAddons.add(unknownAddons[i]);
        }
    }

    public void addLichAddons(){
        for(int i = 0; i < lichAddons.length; i++){
            activeLichAddons.add(lichAddons[i]);
        }
    }

    public void addDarkLordAddons(){
        for(int i = 0; i < darkLordAddons.length; i++){
            activeDarkLordAddons.add(darkLordAddons[i]);
        }
    }

    public void addHoundmasterAddons(){
        for(int i = 0; i < houndmasterAddons.length; i++){
            activeHoundmasterAddons.add(houndmasterAddons[i]);
        }
    }

    public void addGhoulAddons(){
        for(int i = 0; i < ghoulAddons.length; i++){
            activeGhoulAddons.add(ghoulAddons[i]);
        }
    }

    public void addAnimatronicAddons(){
        for(int i = 0; i < animatronicAddons.length; i++){
            activeAnimatronicAddons.add(animatronicAddons[i]);
        }
    }

    public void addKrasueAddons(){
        for(int i = 0; i < krasueAddons.length; i++){
            activeKrasueAddons.add(krasueAddons[i]);
        }
    }

    public void addFirstAddons(){
        for(int i = 0; i < firstAddons.length; i++){
            activeFirstAddons.add(firstAddons[i]);
        }
    }
}