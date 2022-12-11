package Exam22October2022;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String carNum = scanner.nextLine();
        int carRow = 0;
        int carColl = 0;
        int kmPassed = 0;
        boolean isFinished = false;
        int firstTunnelRow = -1;
        int firstTunnelColl = -1;
        int secondTunnelRow = -1;
        int secondTunnelColl = -1;

        String[][] route = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                if (line[j].equals("T") && firstTunnelRow == -1) {
                    firstTunnelRow = i;
                    firstTunnelColl = j;
                } else if (line[j].equals("T") && firstTunnelRow != -1){
                    secondTunnelRow = i;
                    secondTunnelColl = j;
                }
            }
            route[i] = line;
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "left":
                    carColl -= 1;
                    if (firstTunnelRow == carRow && firstTunnelColl == carColl) {
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = secondTunnelRow;
                        carColl = secondTunnelColl;
                        route[carRow][carColl] = ".";
                    } else if(secondTunnelRow == carRow && secondTunnelColl == carColl){
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = firstTunnelRow;
                        carColl = firstTunnelColl;
                        route[carRow][carColl] = ".";
                    } else {
                        kmPassed += 10;
                    }
                    break;
                case "right":
                    carColl += 1;
                    if (firstTunnelRow == carRow && firstTunnelColl == carColl) {
                    kmPassed += 30;
                    route[carRow][carColl] = ".";
                    carRow = secondTunnelRow;
                    carColl = secondTunnelColl;
                        route[carRow][carColl] = ".";
                } else if(secondTunnelRow == carRow && secondTunnelColl == carColl){
                    kmPassed += 30;
                    route[carRow][carColl] = ".";
                    carRow = firstTunnelRow;
                    carColl = firstTunnelColl;
                        route[carRow][carColl] = ".";
                } else {
                    kmPassed += 10;
                }
                    break;
                case "up":
                    carRow -= 1;
                    if (firstTunnelRow == carRow && firstTunnelColl == carColl) {
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = secondTunnelRow;
                        carColl = secondTunnelColl;
                        route[carRow][carColl] = ".";
                    } else if(secondTunnelRow == carRow && secondTunnelColl == carColl){
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = firstTunnelRow;
                        carColl = firstTunnelColl;
                        route[carRow][carColl] = ".";
                    } else {
                        kmPassed += 10;
                    }
                    break;
                case "down":
                    carRow += 1;
                    if (firstTunnelRow == carRow && firstTunnelColl == carColl) {
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = secondTunnelRow;
                        carColl = secondTunnelColl;
                        route[carRow][carColl] = ".";
                    } else if(secondTunnelRow == carRow && secondTunnelColl == carColl){
                        kmPassed += 30;
                        route[carRow][carColl] = ".";
                        carRow = firstTunnelRow;
                        carColl = firstTunnelColl;
                        route[carRow][carColl] = ".";
                    } else {
                        kmPassed += 10;
                    }
                    break;
            }
            if (route[carRow][carColl].equals("F")) {
                isFinished = true;
                route[carRow][carColl] = "C";
                break;
            }

            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", carNum);
        } else {
            route[carRow][carColl] = "C";
            System.out.printf("Racing car %s DNF.%n", carNum);
        }
        System.out.printf("Distance covered %d km.%n", kmPassed);
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                System.out.print(route[j][k]);
            }
            System.out.println();
        }
    }
}
