import java.util.Scanner;
import java.util.Random; 
import java.util.concurrent.TimeUnit;

public class TreasureBox  {
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
  public void TreasureBox()
  {
    
  }
  public void open(int iHealth){
    health=iHealth;
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    System.out.println("This is the duplicate treasure!");
    delay();
    System.out.println("There's nothing in here!");
    delay();
    System.out.println("Got you!");
    delay();
    System.out.println("\n------------------------------------------------------------------\n");
    delay(); 
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    System.out.println("As you continued straight, you came across a lake full of water"); 
    delay();
    System.out.println("Do you want to drink?"); 
    delay();
    System.out.println("1) drink the water"); 
    delay();
    System.out.println("2) Continue going straight"); 
    delay();
    System.out.println("\n------------------------------------------------------------------\n");
    delay();

    input = myScanner.nextLine();

    if (input.equals("1")) {
      drink(health);
    } else if (input.equals("2")) {
      straight(health);
  }
  }
    public void drink(int iHealth){
       health=iHealth;
      System.out.println("\n------------------------------------------------------------------\n");
      delay();
      System.out.println("The water has been poisoned"); 
      delay();
      health = health - 20; 
      System.out.println("You HP has been reduced 20");
      delay();
      System.out.println("Your HP: " + health);
      delay();
      System.out.println("\n------------------------------------------------------------------\n");
      delay();
      System.out.println("\n------------------------------------------------------------------\n");
      delay();
      System.out.println("You could see a mountain and a glowing treasure perched over it as you continued to travel."); 
      delay();
      System.out.println("You started to walk fast."); 
      delay();
      System.out.println("You came close to the mountain."); 
      delay();
      System.out.println("To get to the treasure, though, you must either climb the mountain or navigate the steps around it."); 
      delay();
      System.out.println("What do you like to do?"); 
      delay();
      System.out.println("1) Climb the Mountain"); 
      delay();
      System.out.println("2) Go by stairs"); 
      delay();
      System.out.println("\n------------------------------------------------------------------\n");
      delay();

      input = myScanner.nextLine();

      Mountain mountain = new Mountain(); 
      if (input.equals("1")) {
      mountain.climb();
    } else if (input.equals("2")) {
      mountain.stairs(health);
    } else {
        System.out.println("\tInvalid Command!");
    }
    }
  
    public void straight(int iHealth){
      health=iHealth;
      if (health < 1) {
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
      while (running) {
      System.out.println("-----------------------------------------------------------");
      myScanner = new Scanner(System.in);
      rand = new Random();
      System.out.println("-----------------------------------------------------------");


      System.out.println("-----------------------------------------------------------");
      delay();

		 enemyHealth = rand.nextInt(maxEnemyHealth);
		String enemy = enemies[rand.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");
      delay();

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
         delay();

        if (health < 1)  {
          System.out.println("\n------------------------------------------------------------------\n");
          delay();
        }
        else if (input.equals("2")) {
          if(numHealthPotions > 0) {
            health += healthPotionHealAmount;
            numHealthPotions--;
            System.out.println("\n------------------------------------------------------------------\n"); 
            delay();
            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount);
            delay();
            System.out.println("\t> You now have" + health + "HP.");
            delay();
            System.out.println("\t> You have " + numHealthPotions + " health potions left.\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
          }
          else {
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
            System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
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
          straight(health);
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
        delay();
        input = myScanner.nextLine();
      System.out.println("\n------------------------------------------------------------------\n");
        delay();
      System.out.println("You could see a mountain and a glowing treasure perched over it as you continued to travel."); 
        delay();
      System.out.println("You started to walk fast."); 
        delay();
      System.out.println("You came close to the mountain."); 
        delay();
          while (running)
      {
      System.out.println("To get to the treasure, though, you must either climb the mountain or navigate the steps around it."); 
        delay();
      System.out.println("What do you like to do?"); 
        delay();
      System.out.println("1) Climb the Mountain"); 
        delay();
      System.out.println("2) Go by stairs"); 
        delay();
      System.out.println("\n------------------------------------------------------------------\n");
        delay();
        input = myScanner.nextLine();

      Mountain mountain = new Mountain(); 
      if (input.equals("1")) {
      mountain.climb();
    } else if (input.equals("2")) {
      mountain.stairs(health);
      } else {
        System.out.println("\tInvalid Command!");
        continue;
    }
      }  
		}
	}
}
    }
  public void going(int iHealth){
     health=iHealth;
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
    
    System.out.println("-----------------------------------------------------------");
    delay();

		 enemyHealth = rand.nextInt(maxEnemyHealth);
		String enemy = enemies[rand.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");
    delay();

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
        delay();
        }
        else if (input.equals("2")) {
          if(numHealthPotions > 0) {
            health += healthPotionHealAmount;
            numHealthPotions--;
            System.out.println("\n------------------------------------------------------------------\n"); 
            delay();
            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount);
            delay();
            System.out.println("\t> You now have " + health + "HP.");
            delay();
            System.out.println("\t> You have " + numHealthPotions + " health potions left.\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
          }
          else {
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
            System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
            delay();
            System.out.println("\n------------------------------------------------------------------\n");
            delay();
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
         
          going(health);
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
        delay();
      }
    
     while (running)
      {
      System.out.println("\n------------------------------------------------------------------\n");
        delay();
      System.out.println("You could see a mountain and a glowing treasure perched over it as you continued to travel."); 
        delay();
      System.out.println("You started to walk fast."); 
        delay();
      System.out.println("You came close to the mountain."); 
        delay();
      System.out.println("To get to the treasure, though, you must either climb the mountain or navigate the steps around it."); 
        delay();
      System.out.println("What do you like to do?"); 
        delay();
      System.out.println("1) Climb the Mountain"); 
        delay();
      System.out.println("2) Go by stairs"); 
        delay();
      System.out.println("\n------------------------------------------------------------------\n");
        delay();

        input = myScanner.nextLine();

      Mountain mountain = new Mountain(); 
      if (input.equals("1")) {
      mountain.climb();
    } else if (input.equals("2")) {
      mountain.stairs(health);
    } else {
        System.out.println("\tInvalid Command!");
          continue;
    }

  }
    }
}