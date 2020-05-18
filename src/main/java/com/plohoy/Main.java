package com.plohoy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] numbers = new int[][]{{5, 2, 1, 6}, {6, 2, 4, 4}, {9, 2, 3, 7}, {7, 3, 5, 8}, {0, 0, 0, 0}};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println("");
        }

        int[] alfa = new int[numbers.length];
        int[] beta = new int[numbers[0].length];

        for (int i = 0; i < alfa.length; i++) {
            alfa[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < beta.length; j++) {
            beta[j] = Integer.MAX_VALUE;
        }
        alfa[0] = 0;

        int[][] factorKIt = new int[][]{
                {1, 3}, {2, 2}, {2, 4}, {3, 3},
                {4, 2}, {4, 3}, {5, 1}, {5, 4}};

        int maxNumber = 5;

        boolean init = false;
        while (!init) {
            init = true;
            for (int i = 0; i < factorKIt.length; i++) {
                if (alfa[factorKIt[i][0] - 1] == Integer.MAX_VALUE &&  beta[factorKIt[i][1] - 1] != Integer.MAX_VALUE) {
                    alfa[factorKIt[i][0] - 1] = beta[factorKIt[i][1] - 1] - numbers[factorKIt[i][0] - 1][factorKIt[i][1] - 1];
                    init = false;
                }
                if (beta[factorKIt[i][1] - 1] == Integer.MAX_VALUE &&  alfa[factorKIt[i][0] - 1] != Integer.MAX_VALUE) {
                    beta[factorKIt[i][1] - 1] = alfa[factorKIt[i][0] - 1] + numbers[factorKIt[i][0] - 1][factorKIt[i][1] - 1];
                    init = false;
                }
            }
        }

        int[][] factors = new int[numbers.length][numbers[0].length];
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[i].length; j++) {
                factors[i][j] = beta[j] - alfa[i] - numbers[i][j];
            }
        }

        System.out.println("");
        System.out.println("------");
        System.out.println("String Factors (Alfa)");
        System.out.print(Arrays.toString(alfa));
        System.out.println("");

        System.out.println("");
        System.out.println("Column Factors (Beta)");
        System.out.print(Arrays.toString(beta));
        System.out.println("");

        System.out.println("");
        System.out.println("------");
        System.out.println("Factors (Alfa ij)");
        for (int i = 0; i < factors.length; i++) {
            for (int j = 0; j < factors[i].length; j++) {
                System.out.print(factors[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
