
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Joan Amaury rosario
 * @version 2020.03.10
 */

    public class Game 
    {
    private Parser parser;
    private Room currentRoom;
    private Item roomItem;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }
    
     /**
     * Create all the rooms and link their exits together. Along with each 
      rooms item
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, pond, garden, 
        pathway, further, rip, Rip, RIp, RIP;
        
        Item baseball, pocketwatch, lamp, ciggarate, guitar, bat, book,
        knife, sword, ladder, coin, note, lighter, pencil;
        
        // create items
        baseball = new Item("a brand new baseball signed BR " , 1 , "baseball" );
        pocketwatch = new Item(" an antique pocketwatch made of pure gold", 2 ,"pocketwatch");
        book = new Item("Thick history book. Almost like it was left on porpuse", 5 , "book" );
        ciggarate = new Item("unused ciggarate. All you need now is a lighter" , 1, "ciggarate");
        guitar = new Item(" Rusty guitar. Looks like someone ripped all the strings..", 8, "guitar");
        bat = new Item(" A brand new bat signed Negan" , 2, "bat");
        sword = new Item(" medival sword. Maybe it can come in handy." , 10, "sword");
        ladder = new Item(" short ladder. feels pountless carrying this arround." ,20, "ladder");
        knife = new Item(" a butter knife... WHat am i suposed to do with this?" ,1, "knife");
        coin = new Item(" a gold coin with a picture of a doge engraved in it. Very valuable" ,5, "coin");
        pencil = new Item(" a diamond pencil covered in blood. I wonder why?", 2, "pencil");
        lighter = new Item(" an old lighter. Maybe you can light your way to safety.." , 1, "lighter");
        note = new Item(" the note states: Thanks for playing! You found the sad ending :(... try again?", 0, "note");
        
        // create the rooms
        outside = new Room("outside the main entrance of the university", baseball);
        theater = new Room("in a theater full of old manekins odly placed in every seat.", pocketwatch);
        pub = new Room("in the campus pub. Something feels off here...", book);
        lab = new Room("in a computing lab. Nothing odd here. ", ciggarate);
        office = new Room("in the  admin office. Theres blood everywhere! WHat the hell happened here?!", guitar);
        pond = new Room("near a pond behind the building", bat);
        pathway = new Room("on an eerie looking pathway surrounded by trees", sword);
        garden = new Room("on the universities garden. You feel safe here.",ladder);
        further = new Room("further down the path. Something doesnt feel right. Maybe turn around?", knife);
        rip = new Room("Somethings off. You cant seem to stop going forward.", coin);
        Rip = new Room("no longer in control of your body.", pencil);
        RIp = new Room("no longer in control.", lighter);
        RIP = new Room("dead", note);
        
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", pond);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        pond.setExit("south", outside);
        pond.setExit("north", pathway);
        pond.setExit("east", garden);
        
        garden.setExit("west", pond);
        
        pathway.setExit("south", pond);
        pathway.setExit("north", further);
        
        further.setExit("north", rip);
        
        rip.setExit("north", Rip);
        
        Rip.setExit("north", RIp);
        
        RIp.setExit("north", RIP);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Adios!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly exciting adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    /** 
     * take command word that allows player to "pick up item"
     */
    private void take()
    {
       System.out.println("You have picked up an Item."); 
    }

    /** 
     * look command word that gives room description
       */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * command word to eat 
     */
    private void eat()
    {
     System.out.println("You have eaten. You are no longer hungry.");   
    }
    
    /**
     * command word to check players picked up items
     */
    private void check()
    {
        System.out.println();
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case LOOK:
                look();
                break;
            
            case EAT:
                eat();
                break;
            
            case TAKE:
                 take();
                  break;
                  
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. Alone in a place you've never been in You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
