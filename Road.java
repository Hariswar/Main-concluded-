import java.util.Scanner;
import java.util.Random; 
import java.util.concurrent.TimeUnit;

public class Road  {
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
  public void Road()
  {
    
  }
   
  public  void road1(int iHealth){
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    health=iHealth;
    System.out.println("You found an health drink");
    delay();
    System.out.println("Your HP is recovered.");
    delay();
    health = health + 10; 
    System.out.println("Your HP: " + health);
    delay();
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    while (running)
      {
    System.out.println("\n------------------------------------------------------------------\n");
    System.out.println("The cave comes to an end here. You notice a bridge when you exit the cave, but the bridge is unstable!");
    delay();
    System.out.println("What do you want to do?");
    delay();
    System.out.println("1) Cross the Bridge");
    delay();
    System.out.println("2) Keep going Straight");
    delay();
    System.out.println("\n------------------------------------------------------------------\n");

    input = myScanner.nextLine();

    Bridge bridge = new Bridge();
    if (input.equals("1")) {
      bridge.pass();
    } else if (input.equals("2")) {
      bridge.linear(health);
    } else {
        System.out.println("\tInvalid Command!");
      continue;
    }
  }
  }
  public  void road2(int iHealth){
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    System.out.println("You found an health drink");
    delay();
    System.out.println("Your HP is recovered.");
    delay();
     health=iHealth;
    health = health + 10; 
    System.out.println("Your HP: " + health);
    delay();
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    while (running)
      {
    System.out.println("\n------------------------------------------------------------------\n");
    System.out.println("The cave comes to an end here. You notice a bridge when you exit the cave, but the bridge is unstable!");
    delay();
    System.out.println("What do you want to do?");
    delay();
    System.out.println("1) Cross the Bridge");
    delay();
    System.out.println("2) Keep going Straight");
    delay();
    System.out.println("\n------------------------------------------------------------------\n");

    input = myScanner.nextLine();

    Bridge bridge = new Bridge();
    if (input.equals("1")) {
      bridge.pass();
    } else if (input.equals("2")) {
      bridge.linear(health);
    } else {
        System.out.println("\tInvalid Command!");
      continue; 
    }
   }
  }
  public void road3(int iHealth){
    
    if (health < 1) {
            System.out.println("\t You have taken too much damage, you are too weak to go on");
            delay();
            System.out.println("You dont't have enough energy to win the million dollars!");
            delay();
            System.out.println("You limp out of the Stayin' Alive game, weak to battle. ");
            delay();
            System.out.println("GAME OVER!");
           delay();
            System.exit(3); 
          }
    while (running) {
      System.out.println("-----------------------------------------------------------");
      myScanner = new Scanner(System.in);
      rand = new Random();
    System.out.println("-----------------------------------------------------------");

		 enemyHealth = rand.nextInt(maxEnemyHealth);
		String enemy = enemies[rand.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");
     health=iHealth;
		while (enemyHealth > 0) {
			System.out.println("\tYour HP: " + health);
      delay();
			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
      delay();
			System.out.println("\n\t What would you like to do?");
      delay();
			System.out.println("\t1. Attack");
      delay();
			System.out.println("\t2. Drink health potion");
      delay();
			System.out.println("\t3. Run");
      delay();

			 input = myScanner.nextLine();
      if(input.equals("1")) {
        int damageDealt = rand.nextInt(attackDamage);
        int damageTaken = rand.nextInt(enemyAttackDamage);

        enemyHealth -= damageDealt;
        health -= damageTaken; 

        System.out.println("\n------------------------------------------------------------------\n"); 
        delay();
        System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
        delay();
          System.out.println("\t> The " + enemy + " attacked you and gave " + damageTaken + " damage!");
        delay();
        System.out.println("\n------------------------------------------------------------------\n");
        }
        else if (input.equals("2")) {
          if(numHealthPotions > 0) {
            health += healthPotionHealAmount;
            numHealthPotions--;
            System.out.println("\n------------------------------------------------------------------\n"); 
            delay();
            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount);
            delay();
            System.out.println("\t> You now have " + health + " HP.");
            delay();
            System.out.println("\t> You have " + numHealthPotions + " health potions left.\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
          }
          else {
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
            System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
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
          delay();
          System.out.println("\n------------------------------------------------------------------\n");
          delay();
          road3(health); 
        }
        else {
          System.out.println("\tInvalid Command!"); 
        }
    }
    
      System.out.println("------------------------------------------------------");
    delay();
      System.out.println(" # " + enemy + " was defeated! # ");
    delay();
      System.out.println(" # You have " + health + "HP left #"); 
    delay();
      if (rand.nextInt(100) < healthPotionDropChance) {
        numHealthPotions++;
        System.out.println(" # The " + enemy + "dropped a health potion! # ");
        delay();
        System.out.println(" # You now have " + numHealthPotions + " health potions(s) . # "); 
        delay();
        System.out.println("---------------------------------------------------------");
      }
    while (running)
      {
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    System.out.println("The cave comes to an end here. You notice a bridge when you exit the cave, but the bridge is unstable!");
      delay();
    System.out.println("What do you want to do?");
      delay();
    System.out.println("1) Cross the Bridge");
      delay();
    System.out.println("2) Keep going Straight");
      delay();
    System.out.println("\n------------------------------------------------------------------\n");

    input = myScanner.nextLine();

    Bridge bridge = new Bridge();
    if (input.equals("1")) {
      bridge.pass();
    } else if (input.equals("2")) {
      bridge.linear(health);
    } else {
        System.out.println("\tInvalid Command!");
      continue;
    }
  }
}
}
}
