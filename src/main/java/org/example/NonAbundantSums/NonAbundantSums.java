package org.example.NonAbundantSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

public class NonAbundantSums {


    public static final int LIMIT_CAN_BE_WRITTED_AS_AMICABLE_NUMBERS = 28123;

    private static int[] divisors(int number){
        ArrayList<Integer> resultDivisors = new ArrayList<>();


        for (int counter = 1; counter < number; counter++) {
            if (isDivisor(number, counter)){
                resultDivisors.add(counter);
            }
        }

        return convertToArray(resultDivisors);
    }

    private static boolean isDivisor(int remainder,int divisor) {
        return remainder % divisor == 0;
    }

    private static int[] convertToArray(ArrayList<Integer> resultDivisors) {
        int sizeOfArrayResultFromArrayList = resultDivisors.size();
        int[] arrayResultFromArrayList = new int[sizeOfArrayResultFromArrayList];

        for (int counter = 0; counter < sizeOfArrayResultFromArrayList; counter++) {
            arrayResultFromArrayList[counter] = resultDivisors.get(counter);
        }

        return arrayResultFromArrayList;
    }

    private static int sumArray(int[] resultDivisors) {
        int sumArray = 0;



        for (int counter = 0; counter < resultDivisors.length; counter++) {
            sumArray += resultDivisors[counter];
        }

        return sumArray;
    }

    public static int amicableNumbers(int number, boolean canBeWrittenAsTheSumOfTwoAbundantNumbers) {
        ArrayList<Integer> listNumbers = new ArrayList<>();

        for (int counter = 1; counter <= number; counter++) {
            if (isAmicableNumber(counter)){
                listNumbers.add(counter);
            }
        }

        int[] arrayResultAmicableNumbers = convertToArray(listNumbers);
        int[] resultAmicableNumbers = canBeWrittenAsTheSumOfTwoAbundantNumbers ? cutArrayOf(arrayResultAmicableNumbers, LIMIT_CAN_BE_WRITTED_AS_AMICABLE_NUMBERS) : arrayResultAmicableNumbers;

        // System.out.println(Arrays.toString(resultAmicableNumbers));

        return sumArray(resultAmicableNumbers);
    }

    private static int[] cutArrayOf(int[] array, int limit) {

        int lastIndexOfCutArray = lastIndexOfCutArray(array, limit);


        int[] arrayCutted = new int[lastIndexOfCutArray];

        for (int counter = 0; counter < lastIndexOfCutArray; counter++) {
            arrayCutted[counter] = array[counter];
        }

        return arrayCutted;
    }

    private static int lastIndexOfCutArray(int[] array, int limit) {

        int counter = 0;
        boolean isFound = false;

        for (counter = 0; counter < array.length && !isFound; counter++) {
            isFound = array[counter] >= limit;
        }

        return counter - 1;
    }

    private static boolean isAmicableNumber(int number) {
        int[] divisors = divisors(number);
        int sumArray = sumArray(divisors);

        return sumArray > number;
    }

}
