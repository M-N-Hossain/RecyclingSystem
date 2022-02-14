import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pant pant = new Pant();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean reset = true;

        while (reset) {


            System.out.println("Welcome, you can start depositing bottles now");
            System.out.println("After you finish, Type \"P\" for the receipt.");
            String pantName = (scanner.next());

            boolean run = true;
            pant.listOfPantA.clear();
            pant.listOfPantB.clear();
            pant.listOfPantC.clear();
            pant.listOfNoPant.clear();
            double totalValueOfPantA = 0;
            double totalValueOfPantB = 0;
            double totalValueOfPantC = 0;
            double totalPrice = 0;

            while (run) {
                if (!pantName.equals("P") && !pantName.equals("X")) {
                    int pantName1 = (random.nextInt(4) + 1);
                    if (pantName1 == 1) {
                        System.out.println("    Cans and bottles less than 1 liter and DKK 1,00");
                        pant.listOfPantA.add(new Pant());
                        totalPrice = totalPrice + pant.getPantA();
                        System.out.println("The Total: " + totalPrice);
                        pantName = scanner.next();

                    } else if (pantName1 == 2) {
                        System.out.println("    Bottles of plastic 0,5 liter and DKK 1,50");
                        pant.listOfPantB.add(new Pant());
                        totalPrice += pant.getPantB();
                        System.out.println("The Total: " + totalPrice);
                        pantName = scanner.next();
                    } else if (pantName1 == 3) {
                        System.out.println("    Cans and bottles more than 1 liter and DKK 3,00");
                        pant.listOfPantC.add(new Pant());
                        totalPrice += pant.getPantC();
                        System.out.println("The Total: " + totalPrice);
                        pantName = scanner.next();

                    } else if (pantName1 > 3) {
                        System.out.println("No pant!!");
                        pant.listOfNoPant.add(new Pant());
                        System.out.println("The Total: " + totalPrice);
                        pantName = scanner.next();
                    }
                }
                 else if (pantName.equals("P")) {
                    if (totalPrice == 0) {
                        System.out.println("You do not have any receipt");
                        System.out.println("Insert the pant ");
                        pantName = scanner.next();
                    } else if (totalPrice > 0) {

                        System.out.println("The receipt is being printed............");
                        Thread.sleep(2000);
                        System.out.println();

                        for (int i = 0; i < pant.listOfPantA.size(); i++) {
                            totalValueOfPantA = totalValueOfPantA + pant.listOfPantA.get(i).getPantA();
                        }

                        for (int i = 0; i < pant.listOfPantC.size(); i++) {
                            totalValueOfPantC = totalValueOfPantC + pant.listOfPantC.get(i).getPantC();
                        }

                        for (int i = 0; i < pant.listOfPantB.size(); i++) {
                            totalValueOfPantB = totalValueOfPantB + pant.listOfPantB.get(i).getPantB();
                        }

                        String p = "Pant";

                        System.out.printf("%-10s%-25s%-17s%-15s", p, "Quantity", " Price", " SubTotal");
                        System.out.printf("\n%-13s%-23d%-17.2f%-10.2f%s", "A", pant.listOfPantA.size(), pant.getPantA(), totalValueOfPantA, "Dkk");
                        System.out.printf("\n%-13s%-23d%-17.2f%-10.2f%s", "B", pant.listOfPantB.size(), pant.getPantB(), totalValueOfPantB, "Dkk");
                        System.out.printf("\n%-13s%-23d%-17.2f%-10.2f%s", "C", pant.listOfPantC.size(), pant.getPantC(), totalValueOfPantC, "Dkk");
                        System.out.printf("\n%-13s%-23d%-17.2f%-10.2f%s", "Missed Pant", pant.listOfNoPant.size(), pant.getNoPant(), pant.getNoPant(), "Dkk");

                        System.out.println("\n----------------------------------------------------------------------------------------------");

                        totalPrice = totalValueOfPantA + totalValueOfPantB + totalValueOfPantC;
                        double totalPant = pant.listOfPantA.size() + pant.listOfPantB.size() + pant.listOfPantC.size();

                        System.out.printf("%s%-10.0f%19s%14s%10s", "Total Pant : ", totalPant, "Total Price", totalPrice, " Dkk");
                        System.out.println();
                        Thread.sleep(3000);

                        System.out.println();
                        run = false;
                    }
                }
                else if (pantName.equals("X")) {
                    reset = false;
                    break;
                }

            }
        }
    }
}
