package Exam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        Map<String, Integer> sword = new TreeMap<>();
        sword.put("Gladius", 0);
        sword.put("Shamshir", 0);
        sword.put("Katana", 0);
        sword.put("Sabre", 0);

        int swordCount = 0;


        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(steel::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(carbon::push);

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int momentSteel = steel.peek();
            int momentCarbon = carbon.peek();
            int mixSum = momentSteel + momentCarbon;

            switch (mixSum) {
                case 70:
                    sword.compute("Gladius", (k, v) -> v + 1);
                    swordCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 80:
                    sword.compute("Shamshir", (k, v) -> v + 1);
                    swordCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 90:
                    sword.compute("Katana", (k, v) -> v + 1);
                    swordCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 100:
                    sword.compute("Sabre", (k, v) -> v + 1);
                    swordCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                default:
                    steel.poll();
                    carbon.pop();
                    carbon.push(momentCarbon + 5);
                    break;
            }


        }

        String collectSteel = steel.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
        String collectCarbon = carbon.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));


        if (swordCount > 0) {
            System.out.printf("You have forged %d swords.%n", swordCount);
        } else {
            System.out.printf("You did not have enough resources to forge a sword.%n");
        }

        if (steel.isEmpty()) {
            System.out.printf("Steel left: none%n");
        } else {
            System.out.printf("Steel left: " + collectSteel);
            System.out.println();
        }

        if (carbon.isEmpty()) {
            System.out.printf("Carbon left: none%n");
        } else {
            System.out.printf("Carbon left: " + collectCarbon);
            System.out.println();
        }
        sword.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(el -> System.out.println(el.getKey() + ": " + el.getValue()));

        }
}
