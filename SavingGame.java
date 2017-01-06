import java.util.*;
import java.io.*;
public class SavingGame
{
  //All the variables that are used to create save files and search within the 
  //save file
  static String previousSaves = "";
  static ArrayList tempSaveArray = new ArrayList();
  static List<Player> tempLoadArray = new ArrayList<Player>();
  static List<Player> sortingPlayers = new ArrayList<Player>();
  static int lengthOfSearchPlayersArray = 0;
  static int lengthOfLoadPlayersArray = 0;
  
  
  //(I/O)
  //THIS IS THE SVAE FUNCTION, CREATES A PLAYER SAVE BY FIRST SETTING THE SAVE AS A STRING
  //PREVIOUS SAVES AND THEN ADDING ALL THE OTHER SAVES AFTER IT TO MAKE A NEW SAVE FILE
  //AND PRINT ALL OF IT ON THE SAVE FILE
  public static void SaveGame()throws InterruptedException,IOException
  {
    //GRABS THE CURRENT PLAYER'S SAVE
    previousSaves = Player.SaveStatetoString();
    //OPENS UP THE SAVES FILE
    Scanner previousSavesFile = new Scanner ( new File("saves.txt"));
    //SCANS THROUGH THE FILE AND ADDS ALL THE SAVES ONTO THE PREVIOUSSAVES
    while(previousSavesFile.hasNextLine())
    {
      String name = previousSavesFile.next();
      String userClass = previousSavesFile.next();
      int health = previousSavesFile.nextInt();
      int attack = previousSavesFile.nextInt();
      int defense = previousSavesFile.nextInt();
      String inventory = previousSavesFile.next();
      int level = previousSavesFile.nextInt();
      int saveState = previousSavesFile.nextInt();
      tempSaveArray.add(name);
      tempSaveArray.add(userClass);
      tempSaveArray.add(health);
      tempSaveArray.add(attack);
      tempSaveArray.add(defense);
      tempSaveArray.add(inventory);
      tempSaveArray.add(level);
      tempSaveArray.add(saveState);
      previousSaves = previousSaves + "     " + SaveStatetoString(tempSaveArray);
      tempSaveArray = new ArrayList();
    }
    
    //MAKES A NEW WRITING FILE THAT OVERWRITES SAVES.TXT WITH THE
    //NEW PLAYER SAVE FIRST
    FileWriter fw = new FileWriter ("saves.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter saveFile = new PrintWriter (bw);
    saveFile.print(previousSaves);
    saveFile.close();
    
    //GIVES THE ILLUSION OF TIME PASSING WHEN SAVING
    p.pr("Saving...");
    Thread.sleep(3000);
    p.pr("Save Complete!");
    Thread.sleep(3000);
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  //LOAD CHARACTER METHOD (I/O)
  //THIS METHOD READS THROUGH THE PREVIOUS SAVES FILE AND LOOKS FOR THE MATCHED
  //STRING THAT THE USER ENTERS
  public static void LoadGame()throws InterruptedException,IOException
  {
    //OPENS THE SAVES FILE
    Scanner previousSavesFile = new Scanner ( new File("saves.txt"));
    //OPENS SCANNER FOR USER INPUT
    Scanner read = new Scanner(System.in);
    int statusOfValidation = 0;
    p.pr("=============LoadGame==============");
    p.pr("What was the name of your character?");
    //GETS THE USER INPUT AND CONVERTS IT INTO A MATACHBLE STRING
    String nameValidation = read.nextLine();
    nameValidation = nameValidation.replace(" ", "|");
    //ILLUSION OF TIME BEING PAST
    p.pr("Searching...");
    Thread.sleep(1000);
    //CALLS FUNCTION TO LOOK THROUGH THE TEXT FILE, SET UP THE TEXT FILE INTO AN
    //OBJECT LIST OF PLAYERS
    setUpArrayofPlayersForLoading();
    //SEARCHES THE PLAYER OBJECTS WITHIN THE LIST FOR THIER NAME TO MATCH WITH
    //THE NAME OF THE USER INPUT
    int returnIndex = searchPlayerArray(tempLoadArray, nameValidation); //(SEARCH)
      //IF THERE IS A MATCH, APPLY THE MATCH SAVE TO THE CURRENT DIRECTORY
      if (returnIndex > 0)
      {
        String displayName = tempLoadArray.get(returnIndex-1).getNameForSearch();
        displayName = displayName.replace("|", " ");
        p.pr("Here is the save for your character:");
        Thread.sleep(1500);
        p.pr("NAME: " + displayName);
        Player.printTheCharacter(tempLoadArray.get(returnIndex));
        Thread.sleep(1500);
        p.pr("=============LoadGame==============");
        p.pr("Would you like to load the character?");
        p.pr("Type '1' for YES\tType '2'");
        int choice = 0;
        choice = SuperMethods.oneOrTwo(choice);
        //IF THE USER WANTS TO LOAD THE CHARACTER
        if (choice == 1)
        {
          Player temp = new Player();
          temp = tempLoadArray.get(returnIndex-1);
          Menu.mainUser = tempLoadArray.get(returnIndex-1);
          Player.converPlayerToSave(temp);
          p.pr("Loading...");
          Thread.sleep(2000);
          statusOfValidation = 1;
        }
        //IF THE USER DOES NOT WANT TO LOAD THE CHARACTER
        if (choice == 2)
        {
          p.pr("Returning to the main menu...");
          Menu.skip = true;
          Thread.sleep(2000);
        }
      }
      //IF THERE IS NO STRING THAT EXISTS IN THE TEXTFILE
      else if(returnIndex <= 0)
      {
        tempLoadArray = new ArrayList<Player>();
        p.pr("ERROR: There are no characters under that name!");
        p.pr("Returning to the main menu...");
        Menu.skip = true;
        Thread.sleep(2000);
      }
    }
  
  
  
  
  
  //THIS METHOD SAVES THE CHARACTER LIST ARRAY TO A STRING
  public static String SaveStatetoString(ArrayList a)
   {
     String saveStateString = "";
     for(int i = 0; i<8; i++)
     {
       if(i == 0)
       {
         saveStateString = saveStateString + a.get(i);
       }
       else if(a.get(i) instanceof ArrayList)
       {
         String tempString = "";
         tempString = tempString + a.get(i);
         tempString = tempString.replace("[", "");
         tempString = tempString.replace(" ", "");
         tempString = tempString.replace("]", "");
         saveStateString = saveStateString + "     " + tempString;
       }
       else if(i != 0)
       {
         saveStateString = saveStateString + "     " + a.get(i);
       }
     }
     return saveStateString;
   }
  
  
 
  
  //SEARCH METHOD TO FULLFILL SEARCH REQUIREMENT
  //(SEARCH)
  //SEARCHES THE ARRAY LIST OF PLAYERS TO MATCH THE STRING OF THE USER INPUT
  public static int searchPlayerArray(List<Player> a, String b)
  {
    String compareString = "";
    int stateOfMatch = 0;
    int i = 0;
    //WHILE i IS LESS THAN THE LENGTH OF THE ARRAY AND THAT THE STATEOFMATCH IS NOT 1
    while(i < lengthOfLoadPlayersArray-1 && stateOfMatch < 1)
    {
      compareString = a.get(i).getNameForSearch();
      compareString = compareString.replace("|", " ");
      b = b.replace("|", " ");
      //IF THERE IS A MATCH
      if(compareString.equals(b))
       {
         stateOfMatch = 1;
       }
      //IF THERE IS NOT
       else
       {
         stateOfMatch = -1;
       }
       i = i + 1;
    }
    //IF THERE IS A MATCH
    if(stateOfMatch == 1)
    {
      return i;
    }
    //IF THERE IS NOT
    else
    {
      return -1;
    }
  }
  
  
  
  //THIS METHOD READS THROUGH THE TEXT FILE TO SET UP AN ARRAY OF OBJECT PLAYERS
  public static void setUpArrayofPlayers() throws IOException //(AR)
  {
    Scanner previousSavesFile = new Scanner ( new File("saves.txt"));
    //READS THROUGH SAVES.TXT AND MAKES A PLAYER FROM THE SAVES FILE AND THEN ADDS IT TO A PLAYER LIST
    while(previousSavesFile.hasNextLine())
    {
      String name = previousSavesFile.next();
      name = name.replace("|", " ");
      String userClass = previousSavesFile.next();
      int health = previousSavesFile.nextInt();
      int attack = previousSavesFile.nextInt();
      int defense = previousSavesFile.nextInt();
      String inventory = previousSavesFile.next();
      int level = previousSavesFile.nextInt();
      int saveState = previousSavesFile.nextInt();
      Player player = new Player(name, userClass, health, attack, defense, inventory, level, saveState);
      sortingPlayers.add(player); //(AR)
      lengthOfSearchPlayersArray = lengthOfSearchPlayersArray + 1;
    }
    previousSavesFile.close();
  }
  
  
  
  //SAME THING AS BEFORE JUST FOR THE LOADING PLAYERS METHOD
  public static void setUpArrayofPlayersForLoading() throws IOException
  {
    Scanner previousSavesFile = new Scanner ( new File("saves.txt"));
    
    while(previousSavesFile.hasNextLine())
    {
      String name = previousSavesFile.next();
      name = name.replace("|", " ");
      String userClass = previousSavesFile.next();
      int health = previousSavesFile.nextInt();
      int attack = previousSavesFile.nextInt();
      int defense = previousSavesFile.nextInt();
      String inventory = previousSavesFile.next();
      int level = previousSavesFile.nextInt();
      int saveState = previousSavesFile.nextInt();
      Player player = new Player(name, userClass, health, attack, defense, inventory, level, saveState);
      tempLoadArray.add(player);
      lengthOfLoadPlayersArray = lengthOfLoadPlayersArray + 1;
    }
    previousSavesFile.close();
  }
  
  
  
  
  
  //THIS IS THE SORTING METHOD THAT LOOKS THROUGH A LIST OF OBJECTS (PLAYERS) AND COMPARES THE ATTACKS
  //OF EACH OF THE PLAYERS AND SORTS THEM ACCORDINGLY
  public static void sortByAttack(List<Player> a) //(SORT)
  {
    Player player = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    int min;
    for (int index = 0; index < lengthOfSearchPlayersArray - 1; index++)
    {
      min = index;
      for(int j = index + 1; j < lengthOfSearchPlayersArray; j++)
      {
        if((a.get(j)).getAttackForSearch() < (a.get(min)).getAttackForSearch())
        {
          min = j;
        }
      }
      player2 = a.get(min);
      player3 = a.get(index);
      
      player = player2;
      a.set(min, player3);
      a.set(index, player);
    }
  }
  
  //THIS PRINTS THE SORT LIST CORRECTLY SO THAT IT LOOKS NICE IN THE CONSOLE
  public static void printTheSortList(List<Player> a) throws InterruptedException
  {
    int counter = 1;
    int index = 0;
    p.pr("============MAIN-MENU============");
    p.pr("Here are the players with the");
    p.pr("highest attack...");
    Thread.sleep(3000);
    
    while(counter != 11)
    {
      index = lengthOfSearchPlayersArray - counter;
      String nameName = a.get(index).getNameForSearch();
      nameName = nameName.replace("|", " ");
      String spacesSpace = "";
      if(nameName.length() > 10)
      {
        spacesSpace = "\t";
      }
      else
      {
        spacesSpace = "\t\t";
      }
      p.prr((counter) + ": NAME: " + nameName + spacesSpace + "ATTACK: " + a.get(index).getAttackForSearch()+ "\n");
      counter = counter + 1;
    }
    Thread.sleep(5000);
    p.pr("Returning to Main Menu...");
    Thread.sleep(3000);
  }

  
  
  
  
  
}