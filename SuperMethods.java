import java.util.*;
import java.io.*;

//THIS CLASS WAS MADE TO BRING ALL OF THE LENGTHY METHODS TOGETHER IN A MORE
//SIMPLE FORM
public class SuperMethods
{
  //GENERIC METHOD THAT USES TRY CATCH TO PREVENT ERRORS FROM HAPPENING
  public static int antiError(int userInput) //(MYMETH)
  {
    Scanner read = new Scanner(System.in);
    
    while (userInput != 2 || userInput != 1)
    {
    try
    {
      userInput = read.nextInt();
      break;
    }
    catch(java.util.InputMismatchException e)
    {
      FinalProjectGraphics.p("Please type an accurate integer.");
      userInput = 0;
      break;
    }  //end catch
    }
    
    
    return userInput;
    
  }
  
  //SAME AS BEFORE BUT WITH 3 AS WELL
  public static int antiError3(int userInput)
  {
    Scanner read = new Scanner(System.in);
    
    while (userInput != 2 || userInput != 1 || userInput != 3)
    {
    try
    {
      userInput = read.nextInt();
      break;
    }
    catch(java.util.InputMismatchException e)
    {
      FinalProjectGraphics.p("Please type an accurate integer.");
      userInput = 0;
      break;
    }  //end catch
    }
    
    
    return userInput;
    
  }
  
  
  //USES ANTI-ERROR TO BE USED WITHIN CODE
  public static int oneOrTwo(int input)
  {
    input = 0;
    input = antiError3(input);
    while(input != 1 && input != 2)
    {
      input = antiError3(input);
    }
    return input;
  }
  
  //USES ANTI-ERROR3 TO BE USED WITHIN CODE
  public static int oneOrTwoOrThree(int input)
  {
    input = 0;
    input = antiError(input);
    while(input != 1 && input != 2 && input != 3)
    {
      p.pr("Please type an accurate integer.");
      input = antiError(input);
    }
    return input;
  }
  
  //GETS ALL THE ANIMATIONS AND CODE FOR THE CROSSROADS SECTION OF THE GAME
  public static void crossRoads() throws InterruptedException,IOException
  {
    FinalProjectGraphics.crossRoads();
    int i = 0;
    i = antiError(i);
    SideWaysGraphics.GoblinApproach(i);
    if (i == 1)
    {
      SideWaysGraphics.GoblinSetUpLeft();
      Player.setSaveState(2);
      SavingGame.SaveGame();
      CombatDamageCodeLeft();
    }
    if (i == 2)
    {
      SideWaysGraphics.GoblinSetUpRight();
      Player.setSaveState(2);
      SavingGame.SaveGame();
      CombatDamageCodeRight();
    }
  }
  
  //THE CODE FOR THE COMBAT FROM THE LEFT
  public static void CombatDamageCodeLeft() throws InterruptedException //(RANDOM)
  {
    Character goblin = new Character("Goblin", 10, 2, 4);
    Random gen = new Random();
    int gh = goblin.getHealth();
    int ga = goblin.getAttack();
    int gd = goblin.getDefense();
    int ph = Player.health;
    int pa = Player.attack;
    int pd = Player.defense;
    while(gh > 0 && ph > 0)
    {
      int goblinAttack = gen.nextInt(ga);
      int playerDefense = gen.nextInt(pd);
      int totalDamageToPlayer = goblinAttack - playerDefense;
      if(totalDamageToPlayer <= 0)
      {
        SideWaysGraphics.GoblinAttackLeft(-1);
      }
      if(totalDamageToPlayer > 0)
      {
        SideWaysGraphics.GoblinAttackLeft(totalDamageToPlayer);
        ph = ph - totalDamageToPlayer;
        if(ph <= 0)
        {
          break;
        }
      }
      int goblinDefense = gen.nextInt(gd);
      int playerAttack = gen.nextInt(pa);
      int totalDamageToGoblin = playerAttack - goblinDefense;
      if(totalDamageToGoblin <= 0)
      {
        SideWaysGraphics.PlayerAttackLeft(-1);
      }
      if(totalDamageToGoblin > 0)
      {
        SideWaysGraphics.PlayerAttackLeft(totalDamageToGoblin);
        gh = gh - totalDamageToGoblin;
        if(gh <= 0)
        {
          break;
        }
      }
    }
    
    if(gh <= 0)
    {
      p.pr("You have defeated the Goblin!");
      Thread.sleep(2000);
    }
    if(ph <= 0)
    {
      p.pr("You have been defeated...!");
      Thread.sleep(2000);
      p.pr("The game will exit now, but");
      p.pr("you can re-load your character");
      p.pr("when you start the game again.");
      Thread.sleep(5000);
      p.pr("Exiting...");
      Thread.sleep(3000);
      System.exit(1);
    }
    
  }
  
  
  
  //THE CODE FOR THE COMBAT FROM THE RIGHT
   public static void CombatDamageCodeRight() throws InterruptedException //(RANDOM)
  {
    Character goblin = new Character("Goblin", 10, 2, 4);
    Random gen = new Random();
    int gh = goblin.getHealth();
    int ga = goblin.getAttack();
    int gd = goblin.getDefense();
    int ph = Player.health;
    int pa = Player.attack;
    int pd = Player.defense;
    while(gh > 0 && ph > 0)
    {
      int goblinAttack = gen.nextInt(ga);
      int playerDefense = gen.nextInt(pd);
      int totalDamageToPlayer = goblinAttack - playerDefense;
      if(totalDamageToPlayer <= 0)
      {
        SideWaysGraphics.GoblinAttackRight(-1);
      }
      if(totalDamageToPlayer > 0)
      {
        SideWaysGraphics.GoblinAttackRight(totalDamageToPlayer);
        ph = ph - totalDamageToPlayer;
        if(ph <= 0)
        {
          break;
        }
      }
      int goblinDefense = gen.nextInt(gd);
      int playerAttack = gen.nextInt(pa);
      int totalDamageToGoblin = playerAttack - goblinDefense;
      if(totalDamageToGoblin <= 0)
      {
        SideWaysGraphics.PlayerAttackRight(-1);
      }
      if(totalDamageToGoblin > 0)
      {
        SideWaysGraphics.PlayerAttackRight(totalDamageToGoblin);
        gh = gh - totalDamageToGoblin;
        if(gh <= 0)
        {
          break;
        }
      }
    }
    
    if(gh <= 0)
    {
      p.pr("You have defeated the Goblin!");
      Thread.sleep(2000);
    }
    if(ph <= 0)
    {
      p.pr("You have been defeated...!");
      Thread.sleep(2000);
      p.pr("The game will exit now, but");
      p.pr("you can re-load your character");
      p.pr("when you start the game again.");
      Thread.sleep(5000);
      p.pr("Exiting...");
      Thread.sleep(3000);
      System.exit(1);
    }
    
  } 
  
  
  
  
  
  
  //CODE FOR THE INTRODUCTORY GRAPHICS
  public static void introGraphics() throws InterruptedException
  {
    int i = 0;
    while(i != 1)
    {
      FinalProjectGraphics.introGraphics();
      i = oneOrTwo(0);
      if(i == 1)
      {
        FinalProjectGraphics.walkingDown();
      }
      if(i == 2)
      {
        FinalProjectGraphics.introGraphicsBackwards();
      }
    }
  }
  
  
  //SAME AS ANTIERROR BUT WITH 4 VARIABLES FOR START OF GAME
    public static int antiError4(int userInput)
   {
    Scanner read = new Scanner(System.in);
    
    while (userInput != 2 || userInput != 1 || userInput != 3 || userInput != 4)
    {
    try
    {
      userInput = read.nextInt();
      break;
    }
    catch(java.util.InputMismatchException e)
    {
      userInput = 0;
      break;
    }  //end catch
    }
    
    
    return userInput;
    
  }
  
    //SAME AS OTHERS BUT WITH 4 INTEGERS FOR START OF GAME
  public static int oneOrTwoOrThreeOrFour(int input)
  {
    input = 0;
    input = antiError4(input);
    while(input != 1 && input != 2 && input != 3 && input != 4)
    {
      p.pr("Please type an accurate integer.");
      input = antiError(input);
    }
    return input;
  }
  
  //COMPILES ALL THREE METHODS NEEDED TO COMPLETE THE SORT AND PUTS THEM TOGETHER IN THIS METHOD
  public static void menuOptionThree() throws IOException,InterruptedException
  {
    SavingGame.setUpArrayofPlayers();
    SavingGame.sortByAttack(SavingGame.sortingPlayers);
    SavingGame.printTheSortList(SavingGame.sortingPlayers);
  }
  
  
  
  
  
}