import java.util.*;
import java.io.*;

//THIS CLASS WAS MADE FOR THE ANIMATION/MAKING OF THE SIDEWAYS GRAPHICS
public class SideWaysGraphics
{ 
  //USABLE VARIABLES THROUGHOUT THE METHODS
  static String playerIcon = Player.getPlayerIcon();
  static String line = "---------------------------";
  static String upperSegment1 = "\n\n\n\n\n\n\n" + "*___*___**___*___**___*___*" + "\n\n\n           [" + playerIcon + "]             \n\n\n" + line;
  static String upperSegment2 = "\n\n\n\n\n\n\n" + "__**___*___**___*___**___*_" + "\n\n\n           [" + playerIcon + "]             \n\n\n" + line;
  static String upperSegment3 = "\n\n\n\n\n\n\n" + "_*___**___*___**___*___**__" + "\n\n\n           [" + playerIcon + "]             \n\n\n" + line;
  static String upperSegment3Stopper = "_*___**___*___**___*___**__";
  static String upperSegment1Left = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n{G}             [" + playerIcon + "]      \n\n\n" + line;
  static String upperSegment2Left = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n{G}               [" + playerIcon + "]    \n\n\n" + line;
  static String upperSegment3Left = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n{G}                   [" + playerIcon + "]\n\n\n" + line;
  static String upperSegment1Right = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n        [" + playerIcon + "]          {G}\n\n\n" + line;
  static String upperSegment2Right = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n     [" + playerIcon + "]             {G}\n\n\n" + line;
  static String upperSegment3Right = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n[" + playerIcon + "]                  {G}\n\n\n" + line;
  
  //USED TO MAKE THE SPEED OF THE THREAD GENERIC
  private static final int SPEED = 400;
  
  //ANIMATES THE GOBLINAPPROACH
  public static void GoblinApproach(int a) throws InterruptedException
  {
    if(a == 1)
    {
      p("You have chosen to go left!");
      Thread.sleep(1000);
      p("Loading...");
      Thread.sleep(2500);
      p("\n\n\n\n\n\n\n\n");
      for(int i = 0; i < 3; i++)
      {
      p(upperSegment3, SPEED);
      p(upperSegment2, SPEED);
      p(upperSegment1, SPEED);
      }
      p(upperSegment1Left, 1000);
      p(upperSegment2Left, 1000);
      p(upperSegment3Left, 1000);
      p("You have spotted a Goblin!", 3000);
    }
    
     if(a == 2)
    {
      p("You have chosen to go right!");
      Thread.sleep(1000);
      p("Loading...");
      Thread.sleep(2500);
      p("\n\n\n\n\n\n\n\n");
      for(int i = 0; i < 3; i++)
      {
      p(upperSegment1, SPEED);
      p(upperSegment2, SPEED);
      p(upperSegment3, SPEED);
      } 
      p(upperSegment1Right, 800);
      p(upperSegment2Right, 800);
      p(upperSegment3Right, 800);
      p("You have spotted a Goblin!", 3000);
    }
     
  }
  
  //SETS UP THE ANIMATION FOR COMBAT ON THE LEFT
  public static void GoblinSetUpLeft() throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n{G}                   [" + playerIcon + "]\n\n\n" + line;
    p(setupCombat, 1000);
    setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n   {G}            [" + playerIcon + "]\n\n\n" + line;
    p(setupCombat, 1000);
    p("'ARRRRGGHHHH!'", 1000);  
  }
  //SETS UP THE ANIMATION FOR THE COMBAT ON THE RIGHT
  public static void GoblinSetUpRight() throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n[" + playerIcon + "]                  {G}\n\n\n" + line;
    p(setupCombat, 1000);
    setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n  [" + playerIcon + "]              {G}  \n\n\n" + line;
    p(setupCombat, 1000);
    p("'ARRRRGGHHHH!'", 1000);
  }
  
  //PRINT METHOD TO SAVE TIME
  public static void p(String print)
  {
    System.out.println(print);
  }
  
  //PRINT METHOD THAT INCORPORATES THE THREAD.SLEEP TO SAVE TIME
  public static void p(String print, int ms) throws InterruptedException
  {
    System.out.println(print);
    Thread.sleep(ms);
  }
  
  //ANIMATES WHAT HAPPENS WHEN THE GOBLIN ATTACKS FROM THE LEFT
  public static void GoblinAttackLeft(int i) throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n   {G}            [" + playerIcon + "]\n\n\n" + line;
    String top = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n";
    String basicMiddle = "   {G}            [" + playerIcon + "]\n";
    String end = "\n\n" + line;
    setupCombat = top + basicMiddle + end;
    p("The Goblin attacks!...", 1000);
    p(setupCombat, 1000);
    basicMiddle = "       {G}        [" + playerIcon + "]\n";
    setupCombat = top + basicMiddle + end;
    p(setupCombat, 1000);
    if (i > 0)
    {
    basicMiddle = "       {G}=     **[" + playerIcon + "]**\n";
      setupCombat = top + basicMiddle + end;
      p(setupCombat, 1000);
      p("You were hit for " + i + " damage!");
    }
    if (i <= 0)
    {
    basicMiddle = "       {G}=      ([" + playerIcon + "])\n";
      setupCombat = top + basicMiddle + end;
      p(setupCombat, 1000);
      p("You defended the attack!", 1000);
    }
    
  }
   //ANIMATES WHAT HAPPENS WHEN THE GOBLIN ATTACKS FROM THE RIGHT
  public static void PlayerAttackLeft(int i) throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n   {G}            [" + playerIcon + "]\n\n\n" + line;
    String top = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n";
    String basicMiddle = "   {G}            [" + playerIcon + "]\n";
    String end = "\n\n" + line;
    setupCombat = top + basicMiddle + end;
    p("You attack...", 1000);
    p(setupCombat, 1000);
    basicMiddle = "   {G}        [" + playerIcon + "]\n";
    setupCombat = top + basicMiddle + end;
    p(setupCombat, 1000);
    if (i > 0)
    {
    basicMiddle = " **{G}**     =[" + playerIcon + "]\n";
      setupCombat = top + basicMiddle + end;
      p(setupCombat, 1000);
      p("You hit the Goblin for " + i + " damage!");
    }
    if (i <= 0)
    {
    basicMiddle = "  ({G})      =[" + playerIcon + "]\n";
      setupCombat = top + basicMiddle + end;
      p(setupCombat, 1000);
      p("The Goblin defended the attack!", 1000);
    }
  }
  
  //ANIMATES WHAT HAPPENS WHEN THE PLAYER ATTACKS FROM THE RIGHT
  public static void PlayerAttackRight(int i) throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n  [" + playerIcon + "]              {G}  \n\n\n" + line;
    String top = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n";
    String basicMiddle = "  [" + playerIcon + "]              {G}  \n";
    String bottom = "\n\n" + line;
    setupCombat = top + basicMiddle + bottom;
    p("You attack the Goblin...", 1000);
    p(setupCombat, 1000);
    basicMiddle = "      [" + playerIcon + "]          {G}  \n";
    setupCombat = top + basicMiddle + bottom;
    p(setupCombat, 1000);
    if (i > 0)
    {
    basicMiddle = "      [" + playerIcon + "]=       **{G}**\n";
    setupCombat = top + basicMiddle + bottom;
      p(setupCombat, 1000);
      p("You hit the Goblin for " + i + " damage!");
    }
    if (i <= 0)
    {
    basicMiddle = "      [" + playerIcon + "]=        ({G}) \n";
      setupCombat = top + basicMiddle + bottom;
      p(setupCombat, 1000);
      p("The Goblin defended your attack!", 1000);
    }
  }
   //ANIMATES WHAT HAPPENS WHEN THE PLAYER ATTACKS FROM THE LEFT
  public static void GoblinAttackRight(int i) throws InterruptedException
  {
    String setupCombat = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n  [" + playerIcon + "]              {G}  \n\n\n" + line;
    String top = "\n\n\n\n\n\n\n" + upperSegment3Stopper + "\n\n\n";
    String basicMiddle = "  [" + playerIcon + "]              {G}  \n";
    String bottom = "\n\n" + line;
    setupCombat = top + basicMiddle + bottom;
    p("The Goblin Attacks!", 1000);
    p(setupCombat, 1000);
    basicMiddle = "  [" + playerIcon + "]          {G}  \n";
    setupCombat = top + basicMiddle + bottom;
    p(setupCombat, 1000);
    if (i > 0)
    {
    basicMiddle = "**[" + playerIcon + "]**       ={G}  \n";
    setupCombat = top + basicMiddle + bottom;
      p(setupCombat, 1000);
      p("The Goblin hits your for " + i + " damage!");
    }
    if (i <= 0)
    {
    basicMiddle = " ([" + playerIcon + "])        ={G}  \n";
      setupCombat = top + basicMiddle + bottom;
      p(setupCombat, 1000);
      p("You defended the attack!", 1000);
    }
  }
  
  
  
  
  
}