//THIS CLASS WAS MADE TO CREATE ANY CHARACTER IN THE GAME LIKE THE GOBLIN
public class Character
{
  
  //meta data
  static int health;
  static int attack;
  static int defense;
  static String name;
  
  
  //Constructor that sets default for all characters in game
  public Character(String n, int h, int a, int d)
  {
    health = h;
    attack = a;
    defense = d;
    name = n;
  }
  
  //sets health of a character
  public void setHealth(int h)
  {
    health = h;
  }
  
  //returns health of a character
  public int getHealth()
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
  
  //Returns attack of character
  public int getAttack()
  {
    return attack;
  }
  
  //Returns defense of character
  public int getDefense()
  {
    return defense;
  }
  
  //sets name of the character
  public void setName(String n)
  {
    name = n;
  }
  
  //Returns name of character
  public String getName()
  {
    return name;
  }
  
  
}