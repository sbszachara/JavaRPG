import java.util.*;
import java.io.*;
public class Menu
{
  
  static boolean repeatMenu = true;
  static Player mainUser = new Player();
  static boolean skip = false;
  
  //This method was to make sure that the console window was big enough
  //for the user to see/not see what the user is suppose to look at
  //After realizing that I could present this on my laptop
  //I figured I wouldn't need it in the main game but kept it around
  //Just in case
  public static void introSetupMenu() throws InterruptedException
  {
    Scanner read = new Scanner(System.in);
    
    System.out.println("=======Configuration=======\n" +
                       "Before we can begin, let's make\n" +
                       "sure your interactions window\n" +
                       "is configured properly.");
    
    
    Thread.sleep(5000);
    String configConfirmTitle = "======Configuration======\n" +
      "To configure properly, match\n" +
      "the height of your interactions\n" + 
      "window to the height of this box:";
    System.out.println(configConfirmTitle);
    Thread.sleep(5000);
    
    
    String boxConfig = "===============================\n" +
      "|                             |\n" +
      "|                             |\n" +
      "|                             |\n" +
      "|                             |\n" +
      "|                             |\n" +
      "===============================\n";
    System.out.println(boxConfig);
    Thread.sleep(5000);
    
    
    String configConfirm = "======ConfigComplete======\n" +
      "If you have done this correctly,\n" +
      "then the top line of this window should say\n" +
      "'======ConfigComplete======'\n" +
      "Is this the statement on the top line?\n" + 
      "Type '1' for YES\t" + 
      "Type '2' for NO";
    System.out.println(configConfirm);
    int configOkay = 0;
    configOkay = SuperMethods.oneOrTwo(configOkay);
    
    while(configOkay != 1)
    {
      System.out.println(configConfirmTitle);
      Thread.sleep(3000);
      System.out.println(boxConfig);
      Thread.sleep(5000);
      System.out.println(configConfirm);
      configOkay = SuperMethods.oneOrTwo(configOkay);
    }
    System.out.println("======ConfigComplete======\n" +
                       "Fantastic!\n" +
                       "Now we may begin.\n\n");
    Thread.sleep(2000);
  }
  
  
  
  
  
  
  
  
  
  
  //This is the driving method for the creation of a new character
  public static void CharacterCreation() throws InterruptedException,IOException
  {
    Scanner read = new Scanner(System.in);
    
    p("========CHARACTER-CREATION=======");
    p("You have decided to create a new character!");
    p("What is the name of your character?");
    //Initially sets up name and accounts for spaces by replacing them with "|"
    //So that when the game is saved there are no errors in saving
    String createName = read.nextLine();
    createName = createName.replace(" ", "|");
    //Sets main user's name
    mainUser.setName(createName);
    //Goes to the character creation data that sets all the classes
    CharacterCreationData();
    SavingGame.SaveGame();

  }//END OF CHOOSE CHARACTER
  
  
  
  
  
  //MAIN MENU
  //THIS IS THE MAIN DRIVER FOR MY WHOLE GAME
  //IT IS THE ONE LINE IN MY MAIN FILE
  public static void mainMenu() throws InterruptedException,IOException
  { 
    //Basically means while this static variable is true, the game menu
    //will repeat until off or false
    while(repeatMenu == true)//(BOOL)
    {
    p("============MAIN-MENU============");
    p("Please select from the options below.");
    p("Type '1' to start a new game.");
    p("Type '2' to load a previous game.");
    p("Type '3' to see the top ten players with most attack.");
    p("Type '4' to quit.");
    //Calls one of my supermethods to account for 1-4 integer typing
    int menuChoice = SuperMethods.oneOrTwoOrThreeOrFour(0);
    //Starts a new game if choice is 1
    if(menuChoice == 1)
    {
      //The whole game is right here
      //All the methods are embedded into these simple methods
      //Goes to character creation
      Menu.CharacterCreation();
      //Reminds users about saving function
      preIntroReminder();
      //Graphics of the intro
      SuperMethods.introGraphics();
      //Crossroads, Goblin, and Combat
      SuperMethods.crossRoads();
      Player.setSaveState(3);
      SavingGame.SaveGame();
      p.pr("Your character has reached the end");
      p.pr("of my game...");
      Thread.sleep(3000);
      p.pr("THANK YOU FOR PLAYING!");
      Thread.sleep(2000);
      p.pr("Exiting...");
      //Ends game
      repeatMenu = false;
    }
    //This loads a previous game
    else if (menuChoice == 2)
    {
      //This goes to the load method
      SavingGame.LoadGame();
      //This accounts for if the user doesn't want to load the character
      //it will skip over playing the game
      if(skip == false)
      {
      //If the user does say it wants to load the character, then the game
      //Looks at the savestate number to put the user back in the place they left off
      int s = mainUser.getSaveState();
      //If they just started
      if(s == 0)
      {
        preIntroReminder();
        SuperMethods.introGraphics();
        SuperMethods.crossRoads();
        Player.setSaveState(3);
        SavingGame.SaveGame();
        p.pr("Your character has reached the end");
        p.pr("of my game...");
        Thread.sleep(3000);
        p.pr("THANK YOU FOR PLAYING!");
        Thread.sleep(2000);
        p.pr("Exiting...");
        repeatMenu = false;
      }
      //if they are done with the intro reminder
      if(s == 1)
      {
        SuperMethods.introGraphics();
        SuperMethods.crossRoads();
        Player.setSaveState(3);
        SavingGame.SaveGame();
        p.pr("Your character has reached the end");
        p.pr("of my game...");
        Thread.sleep(3000);
        p.pr("THANK YOU FOR PLAYING!");
        Thread.sleep(2000);
        p.pr("Exiting...");
        repeatMenu = false;
      }
      //if they have already done the intro graphics
      if(s == 2)
      {
        SuperMethods.crossRoads();
        Player.setSaveState(3);
        SavingGame.SaveGame();
        p.pr("Your character has reached the end");
        p.pr("of my game...");
        Thread.sleep(3000);
        p.pr("THANK YOU FOR PLAYING!");
        Thread.sleep(2000);
        p.pr("Exiting...");
        repeatMenu = false;
      }
      //If they are already done with the game
      if(s == 3)
      {
        p.pr("Your character has reached the end");
        p.pr("of my game...");
        Thread.sleep(3000);
        p.pr("THANK YOU FOR PLAYING!");
        Thread.sleep(2000);
        p.pr("Exiting...");
        repeatMenu = false;
      }
      }
    }
    
    //This calls for the sort method that first gathers all
    //the previous saves into a player object array
    //and then searches the arrays for their attacks
    //and then sorts them by the highest number
    else if (menuChoice == 3)
    {
      SuperMethods.menuOptionThree();
    }
    
    //Simply quits the main menu
    else if (menuChoice == 4)
    {
      p.pr("Quitting...");
      Thread.sleep(1000);
      repeatMenu = false;
    }
    }
    
  }
  
  
  
  
  
  
  
  //You will see a lot of this method throughout, I figured since I was
  //printing a lot of text, I would make it easier to type
  public static void p(String print)
  {
    System.out.println(print);
  }
  
  
  
  
  
  
  
  
  //Sets the user's data or class
  public static void CharacterCreationData() throws InterruptedException
  {
    
    //STARTS BOOLEAN WHILE LOOP THAT CHECKS FOR USER CONFIRMATION
    //(BOOL)
    boolean whileLooper = true;
    while(whileLooper == true)
    {
    p("\n========CHARACTER-CREATION=======");
    p("To pick a class,");
    p("Type '1' for MAGE");
    p("Type '2' for KNIGHT");
    p("Type '3' for ARCHER");
    int i = 0;
    i = SuperMethods.oneOrTwoOrThree(i);
    //USER PICKS MAGE
    if (i == 1)
    {
      p("========CHARACTER-CREATION=======");
      Player.setMage();
      p("You are now a MAGE!");
      Thread.sleep(1000);
      p("These are the stats for the MAGE CLASS:");
      Player.printStatsOfClass();
      Thread.sleep(3000);
      whileLooper = false;
      
     }
    
    
    //USER PICKS KNIGHT
    if (i == 2)
    {
      p("========CHARACTER-CREATION=======");
      p("You are now a KNIGHT!");
      Player.setKnight();
      Thread.sleep(1000);
      p("These are the stats for the KNIGHT CLASS:");
      Player.printStatsOfClass();
      Thread.sleep(3000);
      whileLooper = false;
    }
    
    
    //USER PICKS ARCHER
    if (i == 3)
    {
      p("========CHARACTER-CREATION=======");
      p("You are now an ARCHER!");
      Thread.sleep(1000);
      Player.setArcher();
      p("These are the stats for the ARCHER CLASS:");
      Player.printStatsOfClass();
      Thread.sleep(3000);
      whileLooper = false;
    }
    
    }///END OF CHECKING LOOP
    
    
  }
  
  
  //This reminds the user about the save function in the game
  public static void preIntroReminder() throws InterruptedException,IOException
  {
    Thread.sleep(1000);
    p.pr("============REMINDER============");
    p.pr("Before we begin, a quick reminder.");
    p.pr("Your character will automatically");
    p.pr("save throughout the game.");
    Thread.sleep(5000);
    p.pr("============REMINDER============");
    p.pr("This means that you can exit the");
    p.pr("game anytime you want, so long as");
    p.pr("this message is displayed while");
    p.pr("playing the game:");
    Thread.sleep(3000);
    Player.setSaveState(1);
    SavingGame.SaveGame();
    p.pr("Now that your character is saved,");
    p.pr("we may begin!");
    p.pr("Loading...");
    Thread.sleep(3000);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}