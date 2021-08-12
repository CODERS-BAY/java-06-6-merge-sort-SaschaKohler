package com.sksoft;

import java.util.Random;

public class MergeSort {

   // static int[] intArray = new int[10];

    private static int[] sort(int a, int b,int[] intArray) {
        if (a < b) {
            int mid = (a + b) / 2;
            sort(a, mid, intArray);
            sort(mid + 1, b,intArray);
            merge(a, mid, b,intArray);
        }
        return intArray;
    }

    private static void merge(int a, int mid, int b,int[] intArray) {
        int[] array = new int[intArray.length];

        for (int i = a; i <= mid; i++) {
            array[i] = intArray[i];
        }

        for( int j = mid + 1 ; j <= b; j++ ){
            array[mid+1 + b - j] = intArray[j];
        }

        int i = a;
        int j = b;

        for (int k = i; k <= b; k++) {
            if (array[i] <= array[j]) {
                intArray[k] = array[i];
                i++;
            } else {
                intArray[k] = array[j];
                j--;
            }
        }
    }


    public static void main(String[] args) {

        Random random = new Random();
        int MAXSIZE = 1000;
        int[] intArray = new int[MAXSIZE];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(600);

        }

        System.out.println("Unsorted");
        printArray(intArray);

        int[] arr = sort(0, intArray.length-1,intArray);

        System.out.println("Sorted");
        printArray(arr);
    }

    private static void printArray(int[] intArray) {
        System.out.println();
        for (int i = 0; i < intArray.length; i++) {
            if(i%29==0)
                System.out.println();
            if(i == intArray.length) {
                System.out.print(intArray[i]);
                System.out.println();
            } else {
                System.out.print(intArray[i] + ", " );
            }

        }
    }
}
