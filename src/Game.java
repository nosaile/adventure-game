
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random random = new Random();


        String[] legends = {"Bigfoot", "Moon-Eyed Person", "Wampus Cat", "Mothman", "Flatwoods Monster"};
        int maxLegendHealth = 150;
        int maxLegendAttackDamage = 30;
//        int timeUntilSunrise = 24;


        int baseHP = 100;
        int maxPlayerAttackDamage = 20;
        int numOfSipsLeftInFlask = 15;
        int amountSipHealsPlayer = 10;
        int searchAreaForFlaskRefill = 7;

        boolean running = true;

        System.out.println("************************************************************************************");
        System.out.println("""
                \t# Welcome to Appalachia,
                \t# you seem to have strayed a little too far from the path...
                \t# night has fallen quicker than you expected and you begin to grow tired from your travels....
                \t# however you know the mountains won't let you rest, you must survive the night!
                \t# it is 6:00pm, that gives you 12 and a half hours until the daylight climbs back above the mountains
                \t# if you can survive that long you might just make it out of these hills.....""");
        System.out.println("************************************************************************************");


        GAME:
        while (running) {

            int enemyHealth = random.nextInt(maxLegendHealth);
            String enemy = legends[random.nextInt(legends.length)];

            System.out.println("""
                    \t# You notice an unbearable stench, you hear the snapping of trees and feel the ground shaking as the sound grows closer...
                    \t# prepare to face off against the unknown!""");
            System.out.println("Suddenly the creature reveals itself, it appears to be a " + enemy + "!");

            while (enemyHealth > 0) {
                System.out.println("Your HP is " + baseHP + ".");
                System.out.println("The " + enemy + "'s HP is " + enemyHealth + ".");
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Take a sip from your flask.");

                String options = s.nextLine();
                if (options.equals("1")) {
                    int damageDealt = random.nextInt(maxPlayerAttackDamage);
                    int damageTaken = random.nextInt(maxLegendAttackDamage);

                    enemyHealth -= damageDealt;
                    baseHP -= damageTaken;

                    System.out.println("\t> You hit the " + enemy + " for " + damageDealt + " damage!");
                    System.out.println("\t> You received " + damageTaken + " damage from the " + enemy + ".");

                    if (baseHP < 1) {
                        System.out.println("You have been slain by the legends of Appalachia, you will now roam these hills for eternity...");
                        break;
                    }
                } else if (options.equals("2")) {
                    if (numOfSipsLeftInFlask > 0) {
                        baseHP += amountSipHealsPlayer;
                        numOfSipsLeftInFlask--;
                        System.out.println("\t> You take a sip from your flask, you feel slightly stronger. Your HP is now " + baseHP + ". You only have " +
                                numOfSipsLeftInFlask + " sips left in your flask.");
                    } else {
                        System.out.println("\t> Your flask has run dry, defeat the legendary creature and then search your surroundings,\n maybe you'll come across an old moonshine still.");
                    }

                } else {
                    System.out.println("\tINVALID COMMAND");

                }

            }
            if (baseHP < 1) {
                System.out.println("You have been slain by the legends of Appalachia, you will now roam these hills for eternity...");
                break;
            }
            System.out.println("************************************************************************************");
            System.out.println(" # " + enemy + " has been killed! # ");
            System.out.println(" # You have " + baseHP + " HP left. # ");
            if (random.nextInt(10) > searchAreaForFlaskRefill) {
                amountSipHealsPlayer++;
                System.out.println("Searching the immediate area you have found an abandoned still!\n Theres enough extra to refill your flask by one sip!\n" +
                        "You now have " + numOfSipsLeftInFlask + " sips left.");
            }

            System.out.println("************************************************************************************");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue into the night");
            System.out.println("2. Give up and die");

            String input = s.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("INVALID COMMAND");
                input = s.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue your trek...");
            } else if (input.equals("2")) {
                System.out.println("You have let fear conquer you, it has taken your life and now you're dead.");
                break;
            }
        }
        System.out.println("************************");
        System.out.println("Thank you for playing :)");
        System.out.println("************************");

    }
}
