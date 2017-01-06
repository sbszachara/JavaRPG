import java.util.*;
import java.io.*;
public class Player //(CL)
{
  //This is my player class that I created to make
  //That the current player and use the previous player data
  
  //The static variables are used for the current in game
  //Player while the private variables are used to find
  //search, and sort previous player varaibles for my
  //search and sort methods
  static ArrayList inventory = new ArrayList();
  //This static arrayList is key to the saving of the current player's
  //progress, that is why whenever a player creation or set character
  //method is called, this is changed
  static ArrayList saveCharacter = new ArrayList();
  static String overAllClass = "X";
  static String newName = "USERBLANK";
  static int userLevel = 1;
  static int health = 10;
  static int defense = 10;
  static int attack = 10;
  static int loadState = 0;
  private int healthSearch;
  private int defenseSearch;
  private int attackSearch;
  private String inventorySearch;
  private String classSearch;
  private String nameSearch;
  private int loadStateSearch;
  private int userLevelSearch;
  
  
  
  
  
  //Constructor that sets all the static variables to defaults and
  //makes the current save file default
  public Player()
  {
    health = 10;
    attack = 10;
    defense = 10;
    loadState = 0;
    newName = "Blank";
    saveCharacter.add(newName);
    saveCharacter.add(overAllClass);
    saveCharacter.add(health);
    saveCharacter.add(attack);
    saveCharacter.add(defense);
    saveCharacter.add(inventory);
    saveCharacter.add(userLevel);
    saveCharacter.add(loadState);
  }
  
  //Used to create players from previous saves
  public Player(String n, String c, int h, int a, int d, String invT, int lvl, int ls)
  {
    nameSearch = n;
    classSearch = c;
    healthSearch = h;
    attackSearch = a;
    defenseSearch = d;
    inventorySearch = invT;
    loadStateSearch = ls;
    userLevelSearch = lvl;
  }
  
  
  
  //This sets the current user and its save file to a mage with his/her name
  public static void setMage()
  {
    
    health = 7;
    attack = 14;
    defense = 9;
    overAllClass = "M";
    inventory.add("Robe");
    saveCharacter = new ArrayList();
    saveCharacter.add(newName);
    saveCharacter.add(overAllClass);
    saveCharacter.add(health);
    saveCharacter.add(attack);
    saveCharacter.add(defense);
    saveCharacter.add(inventory);
    saveCharacter.add(userLevel);
    saveCharacter.add(loadState);
  }
  
  
  
  
  //This sets the current user and its save file to a knight with his/her name
  public static void setKnight()
  {
    health = 12;
    attack = 8;
    defense = 10;
    inventory.add("Armor");
    overAllClass = "K";
    saveCharacter = new ArrayList();
    saveCharacter.add(newName);
    saveCharacter.add(overAllClass);
    saveCharacter.add(health);
    saveCharacter.add(attack);
    saveCharacter.add(defense);
    saveCharacter.add(inventory);
    saveCharacter.add(userLevel);
    saveCharacter.add(loadState);
  }
  
  
  
  
  //This sets the current user and its save file to an archer with his/her name
  public static void setArcher()
  {
    health = 10;
    attack = 12;
    defense = 8;
    inventory.add("HoodCloak");
    overAllClass = "A";
    saveCharacter = new ArrayList();
    saveCharacter.add(newName);
    saveCharacter.add(overAllClass);
    saveCharacter.add(health);
    saveCharacter.add(attack);
    saveCharacter.add(defense);
    saveCharacter.add(inventory);
    saveCharacter.add(userLevel);
    saveCharacter.add(loadState);
  }
  
  
  
  //This was used to return the saveCharacter arraylist if it was needed to be tested
  //in another method
  public static ArrayList getSaveCharacterArrayList()
  {
    return saveCharacter;
  }
  
  
  
  //This prints the stats of a class so the user gets a sense of what class
  //he or she picked
  public static String printStatsOfClass()
  {
     p("HEALTH: " + saveCharacter.get(2));
     p("ATTACK: " + saveCharacter.get(3));
     p("DEFENSE: " + saveCharacter.get(4));
     return "";
  }
  
  
  
  //This resets both the save file and the inventory which basically
  //resets the save file 'saveCharacter' in general
  public static void resetSaveCharacter()
  {
    inventory = new ArrayList();
    saveCharacter = new ArrayList();
  }
  
  
  
  //This pushes the users's player class icon to all of the graphics methods
  public static String getPlayerIcon()
  {
    String characterPicture = "";
    characterPicture = characterPicture + saveCharacter.get(1);
    return characterPicture;
  }
  
  
  //The print method that I created to save time
   public static void p(String print)
  {
    System.out.println(print);
  }
   
  //This is used to make the arrayList saveCharacter a string so that it can easily be
  //Saved into a text file
   public static String SaveStatetoString()
   {
     String saveStateString = "";
     for(int i = 0; i<8; i++)
     {
       if(i == 0)
       {
         saveStateString = saveStateString + saveCharacter.get(i);
       }
       else if(saveCharacter.get(i) instanceof ArrayList)
       {
         String tempString = "";
         tempString = tempString + saveCharacter.get(i);
         tempString = tempString.replace("[", "");
         tempString = tempString.replace(" ", "");
         tempString = tempString.replace("]", "");
         saveStateString = saveStateString + "     " + tempString;
       }
       else if(i != 0)
       {
         saveStateString = saveStateString + "     " + saveCharacter.get(i);
       }
     }
     return saveStateString;
   }
  
  
  
  
  
  
  //sets health of a character
  public void setHealth(int h)
  {
    health = h;
  }
  
  
  
  
  //returns health of a character
  public static int getHealth()
  {
    return health;
  }
  
  
  
  
  //sets attack of a character
  public void setAttack(int a)
  {
    attack = a;
  }
  
  
  
  
  //sets defense of a character
  public void setDefense(int d)
  {
    defense = d;
  }
  
  //sets defense of a character
  public static int getDefense()
  {
    return defense;
  }
  
  
  
  
  //Returns attack of character
  public static int getAttack()
  {
    return attack;
  }
  
  
  //THESE SEARCH A GENERIC PLAYER, NOT THE MAIN PLAYER PLAYING THE GAME CURRENTLY
  public int getAttackForSearch()
  {
    return attackSearch;
  }
  
  public String getNameForSearch()
  {
    return nameSearch;
  }
  
  public String getClassForSearch()
  {
    return classSearch;
  }
  
  public int getHealthForSearch()
  {
    return healthSearch;
  }
  
  public int getDefenseForSearch()
  {
    return defenseSearch;
  }
  
  public int getLevelForSearch()
  {
    return userLevelSearch;
  }
  
  public String getInventorySearch()
  {
    return inventorySearch;
  }
  
  public int getSaveState()
  {
    return loadStateSearch;
  }

  //sets name of the character
  public static void setName(String n)
  {
    newName = n;
  }
  
  //This sets the save state of the current user and the save file of
  //the current user to that of a save file with the new save state
  public static void setSaveState(int newLoadState)
  {
    //SAVES VARIABLES FOR NEW saveCHARACTER
    String saveName = newName;
    String saveClass = overAllClass;
    int saveHealth = health;
    int saveAttack = attack;
    int saveDefense = defense;
    ArrayList newInventory = inventory;
    int saveLevel = userLevel;
    saveCharacter = new ArrayList();
    saveCharacter.add(saveName);
    saveCharacter.add(saveClass);
    saveCharacter.add(saveHealth);
    saveCharacter.add(saveAttack);
    saveCharacter.add(saveDefense);
    saveCharacter.add(newInventory);
    saveCharacter.add(saveLevel);
    saveCharacter.add(newLoadState); 
  }
  
  
  //Prints a player object from previous players
   public static String printTheCharacter(Player a)//(MYMETH(0))
  {
    p.pr("CLASS: " + a.getClassForSearch());
    p.pr("HEALTH: " + a.getHealthForSearch());
    p.pr("ATTACK: " + a.getAttackForSearch());
    p.pr("DEFENSE: " + a.getDefenseForSearch());
    p.pr("INVENTORY: " + a.getInventorySearch());
    p.pr("LEVEL: " + a.getLevelForSearch());
    return "";
  }
  
   //Another method that takes in a player object and converts it into the arraylist
   //save file
   public static void converPlayerToSave(Player a)
   {
    newName = a.getNameForSearch();
    newName = newName.replace(" ","|");
    overAllClass = a.getClassForSearch();
    health = a.getHealthForSearch();
    attack = a.getAttackForSearch();
    defense = a.getDefenseForSearch();
    String newInventory = a.getInventorySearch();
    userLevel = a.getLevelForSearch();
    loadState = a.getSaveState();
    saveCharacter = new ArrayList();
    saveCharacter.add(newName);
    saveCharacter.add(overAllClass);
    saveCharacter.add(health);
    saveCharacter.add(attack);
    saveCharacter.add(defense);
    saveCharacter.add(newInventory);
    saveCharacter.add(userLevel);
    saveCharacter.add(loadState);
   }
   
   
  
  
  
  
  
}