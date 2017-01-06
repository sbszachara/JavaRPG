import java.util.*;
import java.io.*;

//THIS WHOLE CLASS IS LITERALLY JUST THINGS TO BE PRINTED OUT
public class FinalProjectGraphics
{
  //THIS GRABS THE PLAYER'S CLASS STRING AND INTEGRATES IT WITHIN THE CODE
  static String playerIcon = Player.getPlayerIcon();
  static String path2 = "_*_|                         |_*_\n__*|                         |*__\n*__|                         |__*\n" + 
                        "_*_|                         |_*_\n__*|                         |*__\n*__|           [" + playerIcon + "]           |__*\n" +
                        "_*_|                         |_*_\n__*|                         |*__\n" + 
                        "*__|                         |__*\n_*_|                         |_*_\n";
  
  static String path3 = "*__|                         |__*\n_*_|                         |_*_\n__*|                         |*__\n" + 
                        "*__|                         |__*\n_*_|                         |_*_\n__*|           [" + playerIcon + "]           |*__\n" + 
                        "*__|                         |__*\n_*_|                         |_*_\n__*|                         |*__\n" +
                        "*__|                         |__*\n";
  
  static String path1 = "__*|                         |*__\n*__|                         |__*\n_*_|                         |_*_\n" + 
                        "__*|                         |*__\n*__|                         |__*\n_*_|           [" + playerIcon + "]           |_*_\n" + 
                        "__*|                         |*__\n*__|                         |__*\n_*_|                         |_*_\n" +
                        "__*|                         |*__\n";
  
  private static final int SPEED = 400;
  
  static String introHexagon = "\n\n\n\n\n\n\n" +
                               "    _________________________    \n" +
                               "   /%%% % %%% %%%%% % %%% % %\\  \n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    ___________              %|\n" +
                               "|%    !```[" + playerIcon + "]```!     .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n";
  
 //SIMPLE PRINT METHOD
  public static void p(String print)
  {
    System.out.println(print);
  }
  
  //SIMPLE PRINTING METHOD WITH THREAD VALUE
  public static void p(String print, int ms) throws InterruptedException
  {
    System.out.println(print);
    Thread.sleep(ms);
  }
  
  //WALKING DOWN ANIMATION
  public static void walkingDown() throws InterruptedException
  {
    p("Loading...");
    Thread.sleep(3000);
    p("You walk down the path...");
    Thread.sleep(2000);
    p("\n\n\n\n\n\n");
    for(int i = 0; i < 2; i++)
    {
      System.out.print(path1);
      Thread.sleep(SPEED);
      System.out.print(path2);
      Thread.sleep(SPEED);
      System.out.print(path3);
      Thread.sleep(SPEED);
    }
  }
  
  //CROSSROADS GRAPHICS
  public static void crossRoads() throws InterruptedException
  {   
    String spaceLine = "\n";
    String firstMoveDown = "*__|           [" + playerIcon + "]           |__*\n";
    String secondMoveDown = "_*_|           [" + playerIcon + "]           |_*_\n";
    String thirdMoveDown = "__*|           [" + playerIcon + "]           |*__\n";
    String starBarBar = "*__|                         |__*\n";
    String barStarBar = "_*_|                         |_*_\n";
    String barBarStar = "__*|                         |*__\n";
    String line = "----------------------------------";
    String changingString = starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + barBarStar + firstMoveDown + barStarBar + 
                            barBarStar + starBarBar;
    
    //Another downward animation towards crossroads
    p(changingString + spaceLine, SPEED);
    spaceLine = spaceLine + "\n";
    //Another downward animation towards crossroads
    //The changingString variable has specific changes that I felt was easier to map out in this way
    //So the variable is long, but is easy to understand especially when dealing with printed out graphics
    changingString = starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + barBarStar + starBarBar + secondMoveDown + 
                     barBarStar + starBarBar;
    p(changingString + spaceLine, SPEED);
    spaceLine = spaceLine + "\n";
    //Another downward animation towards crossroads
    changingString = starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + 
                     thirdMoveDown + starBarBar;
    p(changingString + spaceLine + line, SPEED);
    //Another downward animation towards crossroads
    changingString = starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + 
                     barBarStar + firstMoveDown; 
    p(changingString + spaceLine + line, SPEED);
    //Another downward animation towards crossroads
    changingString = starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + barBarStar + starBarBar + barStarBar + 
                     barBarStar + starBarBar;
    p(changingString + "               [" + playerIcon + "]               \n\n\n" + line);
    p("You have come to a cross road!", 2000);
    //Decides whether to go left or right
    p("Type '1' to go LEFT\nType '2' to go RIGHT");
  }//end crossroads    
  
  //ANIMATES AND DOES INTROGRAPHICS
  public static void introGraphics() throws InterruptedException
  {
    p("\n\n\n\n\n\n\nYou wake up in a tent in the middle");
    p("of a forest...");
    Thread.sleep(3000);
    p(introHexagon);
    Thread.sleep(3000);
    p("You remember setting up a campsite");
    p("before going to bed...");
    Thread.sleep(3000);
    p("You step outside by the fire..");
    Thread.sleep(3000);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "    _________________________    \n" +
                               "   /%%% % %%% %%%%% % %%% % %\\  \n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!    [" + playerIcon + "] .^^.    %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|";
    p(introHexagon);
    Thread.sleep(3000);
    p("As you warm up next to the fire,");
    p("you see a long path below you...");
    Thread.sleep(3000);
    p("You approach the start of the path...");
    Thread.sleep(3000);
    
    
    
    
    
    //OKAY
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "   /%%% % %%% %%%%% % %%% % %\\  \n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%             [" + playerIcon + "]             %|\n" +
                               "|%                             %|\n" +
                               "*|                             |*";
    p(introHexagon);
    Thread.sleep(800);
    
    //OKAY
    introHexagon = "\n\n\n\n\n\n\n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%             [" + playerIcon + "]             %|\n" + 
                               "*|                             |*\n"+
                               "_*|                           |*_";
    p(introHexagon);
    Thread.sleep(800);
    
    //OKAY
    introHexagon = "\n\n\n\n\n\n\n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|             [" + playerIcon + "]             |*\n"+
                               "_*|                           |*_\n" +
                               "__*|                         |*__";
    p(introHexagon);
    Thread.sleep(800);
    
    
    
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|            [" + playerIcon + "]            |*_\n" +
                               "__*|                         |*__\n" +
                               "_*_|                         |_*_";
    p(introHexagon);
    Thread.sleep(800);
    
    
    
    
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|                           |*_\n" +
                               "__*|           [" + playerIcon + "]           |*__\n" +
                               "_*_|                         |_*_\n" + 
                               "*__|                         |__*";
    p(introHexagon);
    Thread.sleep(800);
    
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|                           |*_\n" +
                               "__*|                         |*__\n" +
                               "_*_|           [" + playerIcon + "]           |_*_\n" + 
                               "*__|                         |__*\n" +
                               "__*|                         |*__";
    p(introHexagon);
    Thread.sleep(1000);
    p("Do you wish to start your adventure?");
    p("Type '1' for YES\t Type '2' for NO");
    Thread.sleep(1000);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   //ANIMATES AND DOES INTROGRAPHICS
  public static void introGraphicsBackwards() throws InterruptedException
  {
    
    p("Maybe another day...");
    Thread.sleep(3000);
    p("Your character goes back to the tent");
    p("and falls alseep...");
    Thread.sleep(3000);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|                           |*_\n" +
                               "__*|                         |*__\n" +
                               "_*_|           [" + playerIcon + "]           |_*_\n" + 
                               "*__|                         |__*\n" +
                               "__*|                         |*__";
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|                           |*_\n" +
                               "__*|           [" + playerIcon + "]           |*__\n" +
                               "_*_|                         |_*_\n" + 
                               "*__|                         |__*";
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|                             |*\n" + 
                               "_*|            [" + playerIcon + "]            |*_\n" +
                               "__*|                         |*__\n" +
                               "_*_|                         |_*_";
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" + 
                               "*|             [" + playerIcon + "]             |*\n"+
                               "_*|                           |*_\n" +
                               "__*|                         |*__";
    p(introHexagon);
    Thread.sleep(800);
    
    introHexagon = "\n\n\n\n\n\n\n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%             [" + playerIcon + "]             %|\n" + 
                               "*|                             |*\n"+
                               "_*|                           |*_";
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "    _________________________    \n" +
                               "   /%%% % %%% %%%%% % %%% % %\\  \n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !```````!       .^^.     %|\n" +
                               "|%             [" + playerIcon + "]             %|\n" +
                               "|%                             %|\n" +
                               "*|                             |*";
    p(introHexagon);
    Thread.sleep(800);
    introHexagon = "\n\n\n\n\n\n\n" +
                               "    _________________________    \n" +
                               "   /%%% % %%% %%%%% % %%% % %\\  \n" +
                               "  /% %%% % %%% %%%%% % %%% % %\\ \n" +
                               " /%                           %\\\n" +
                               "|%    _________                %|\n" +
                               "|%    !``[" + playerIcon + "]``!       .^^.     %|\n" +
                               "|%                             %|\n" +
                               "|%                             %|\n" +
                               "*|                             |*"; 
    p(introHexagon);
    Thread.sleep(2000);
    p("Loading...");
    Thread.sleep(2000);
    
    
    
    
    
  }
  
  
  
    
    
  }