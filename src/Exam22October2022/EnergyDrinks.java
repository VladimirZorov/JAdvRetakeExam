package Exam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> sequenceCaffeineMlgrms = new ArrayDeque<>();
        ArrayDeque<Integer> sequenceEnergyDrinks = new ArrayDeque<>();

        int maxCaffeine = 300;
        int initialCaffeine = 0;

        Arrays.stream(scanner.nextLine().split(", "))
                        .mapToInt(Integer::parseInt).forEach(sequenceCaffeineMlgrms::push);
        Arrays.stream(scanner.nextLine().split(", "))
                        .mapToInt(Integer::parseInt).forEach(sequenceEnergyDrinks::offer);

        while (!sequenceCaffeineMlgrms.isEmpty()&&!sequenceEnergyDrinks.isEmpty()){
           int currentMlgrms = sequenceCaffeineMlgrms.peek();
           int currentEnergyDrink = sequenceEnergyDrinks.peek();
           int currentAmount = currentMlgrms * currentEnergyDrink;

           if (currentAmount + initialCaffeine <= maxCaffeine){
               initialCaffeine += currentAmount;
               sequenceCaffeineMlgrms.pop();
               sequenceEnergyDrinks.poll();
           } else {
               sequenceCaffeineMlgrms.pop();
               sequenceEnergyDrinks.poll();
               sequenceEnergyDrinks.offer(currentEnergyDrink);
               if (initialCaffeine >= 30) {
                   initialCaffeine -=30;
               }
           }

        }

        if (!sequenceEnergyDrinks.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ",
                    Arrays.asList(sequenceEnergyDrinks.toString().
                            substring(1, sequenceEnergyDrinks.toString().length() -1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine." , initialCaffeine);
    }
}
