import java.util.Scanner;
import java.util.Random; 
import java.util.concurrent.TimeUnit;
public class Mountain {
  private static void delay() { 
      try {
        TimeUnit.SECONDS.sleep(1);
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
	Random rand = new Random();
  boolean running = true;
  Scanner myScanner = new Scanner(System.in);
  String[] enemies = { "Dragons", "Zombies", "Killers", "Warriors", "Skeletons", "Huge Chickens", "Archers", "Huge People", "Sauron", "Demons"};
  int maxEnemyHealth = 150;
  int enemyAttackDamage = 25;
  int health = 100;
  int attackDamage = 50;
  int numHealthPotions = 5;
  int healthPotionHealAmount = 25;
  int healthPotionDropChance = 40;
  int enemyHealth = 0;
  String input = "";
  public void Mountain()
  {
    
  }
  public void climb(){
    System.out.println("\n------------------------------------------------------------------\n"); 
    System.out.println("Unfortunately when you were climbing, Avalanche(snow slide) started to occur."); 
    System.out.println("Due to pressure of the breeze, you fell down from the peak of the mountain and died!");
    System.out.println("You came so close to winning but were unable to cross the finish line."); 
    delay(); 
    System.out.println("GAME OVER");
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
    System.out.println("THANKS FOR PLAYING!");
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
    System.exit(5); 
  }
  
  public void stairs(int iHealth){
    if (health < 1)  {
          System.out.println("\n------------------------------------------------------------------\n");
          delay();
          System.out.println("\t> You have taken too much damage, you are too weak to go on");
          delay();
          System.out.println("You limp out of the Stayin' Alive game, weak from battle. ");
          delay();
          System.out.println("GAME OVER!");
          delay();
          System.out.println("\n------------------------------------------------------------------\n");
          delay();
            System.exit(4); 
          }
    health=iHealth;
    System.out.println("-----------------------------------------------------------");
		 enemyHealth = rand.nextInt(maxEnemyHealth);
		String enemy = enemies[rand.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");
     health=iHealth;
		while (enemyHealth > 0) {
			System.out.println("\tYour HP: " + health);
			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
			System.out.println("\n\t What would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Drink health potion");
			System.out.println("\t3. Run");

			 input = myScanner.nextLine();
      if(input.equals("1")) {
        int damageDealt = rand.nextInt(attackDamage);
        int damageTaken = rand.nextInt(enemyAttackDamage);

        enemyHealth -= damageDealt;
        health -= damageTaken; 

        System.out.println("\n------------------------------------------------------------------\n"); 
        System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
          System.out.println("\t> The " + enemy + " attacked you and gave " + damageTaken + " damage!");
        System.out.println("\n------------------------------------------------------------------\n");

        }
        else if (input.equals("2")) {
          if(numHealthPotions > 0) {
            health += healthPotionHealAmount;
            numHealthPotions--;
            System.out.println("\n------------------------------------------------------------------\n"); 
            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount);
            System.out.println("\t> You now have" + health + "HP.");
            System.out.println("\t> You have " + numHealthPotions + " health potions left.\n");
            System.out.println("\n------------------------------------------------------------------\n");
          }
          else {
            System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
          } 
        }
        else if (input.equals("3")) {
          System.out.println("\n------------------------------------------------------------------\n");  
          delay();

         if ( rand.nextInt((10 - 1) + 1) + 1 <=5)
         {
          System.out.println("\tYou successfully ran away from the " + enemy + "!");
        }
          else
         {
           System.out.println("\tThe " + enemy + " has chased you down, your HP has been reduced ! ");
           health -= 20;
         }
          System.out.println("Your HP: " + health);
          System.out.println("\n------------------------------------------------------------------\n");
          stairs(health); 
        }
        else {
          System.out.println("\tInvalid Command!"); 
        }
    }
    
      System.out.println("------------------------------------------------------");
      System.out.println(" # " + enemy + " was defeated! # ");
      System.out.println(" # You have " + health + "HP left #"); 
      if (rand.nextInt(100) < healthPotionDropChance) {
        numHealthPotions++;
        System.out.println(" # The " + enemy + "dropped a health potion! # ");
        System.out.println(" # You now have " + numHealthPotions + " health potions(s) . # "); 
      }
      System.out.println("---------------------------------------------------------");

    System.out.println("---------------------------------------------------------");
    System.out.println("You reached the treasure and won the million dollars");
    System.out.println("Well Played!");
    System.out.println("CONGRATULATIONS"); 
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
    System.out.println("THANKS FOR PLAYING!");
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
    System.exit(7); 
  }
}