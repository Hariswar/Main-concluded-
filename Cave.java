import java.util.Scanner;
import java.util.Random; 
import java.util.concurrent.TimeUnit;

public class Cave {
  public int health = 100;
    private static void delay() { 
      try {
        TimeUnit.SECONDS.sleep(1);
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  
    String playerName;
    String input="";
    Scanner myScanner = new Scanner(System.in);
  
public  void Cave(){

    System.out.println("Please enter your name:");
    playerName = myScanner.nextLine();
    System.out.println("\n------------------------------------------------------------------\n");
    delay();
    System.out.println("Welcome to the Stayin' Alive game " + playerName + "!");
  delay();
    System.out.println("You'll go out on a dangerous journey to win a million dollars in the upcoming hours!");
  delay();
    System.out.println("Your life is not guaranteed by us!");
  delay();
    System.out.println("Let's start the Stayin' Alive game " + playerName + "!");
  delay();
    System.out.println("\n------------------------------------------------------------------\n");
 	 delay();
    System.out.println("\n------------------------------------------------------------------\n");
  delay();
	  System.out.println("You are at the entrance of this cave, and your objective is to find the treasure that has the million dollars without dying.");
  delay();
	  System.out.println("You discovered three diversions when you entered the cave.");
  delay();
	  System.out.println("");
  delay();
	  System.out.println("What do you want to do?");
  delay();
	  System.out.println("");
  delay();
	  System.out.println("1) Take the route 1");
	  System.out.println("2) Take the route 2");
	  System.out.println("3) Take the route 3");
  delay();

	  System.out.println("\n------------------------------------------------------------------\n");

     input = myScanner.nextLine();
    Route route = new Route();
    if(input.equals("1")) {
      route.route1();
    } else if (input.equals("2")) {
      route.route2();
    } else if (input.equals("3")) {
      route.route3(); 
    } else {
        System.out.println("\tInvalid Command!"); 
}
    }
      }


