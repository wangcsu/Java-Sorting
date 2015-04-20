package com.company;

import java.util.*;

public class Main {

    private static final int ARRAY_SIZE = 60;

    public static void main(String[] args) {
        List<Integer> myArray1 = new ArrayList<Integer>();
        List<Integer> myArray2 = new ArrayList<Integer>();
        List<Integer> myArray3 = new ArrayList<Integer>();
        List<Integer> myArray4 = new ArrayList<Integer>();

        generateRandomArray(myArray1);
        copyArray(myArray1, myArray2);
        copyArray(myArray1,myArray3);
        copyArray(myArray1,myArray4);

        System.out.println("====================BUBBLE SORT====================");
        System.out.printf("Original Data: \n");
        printArray(myArray1);
        long startTime = System.nanoTime();
        bubbleSort(myArray1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("After Bubble sort: \n");
        printArray(myArray1);
        System.out.println("Time used: " + duration + " nanoseconds\n");

        System.out.println("====================SELECTION SORT====================");
        System.out.printf("Original Data: \n");
        printArray(myArray2);
        startTime = System.nanoTime();
        selectionSort(myArray2);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("After Selection sort: \n");
        printArray(myArray2);
        System.out.println("Time used: " + duration + " nanoseconds\n");

        System.out.println("====================QUICK SORT====================");
        System.out.printf("Original Data: \n");
        printArray(myArray3);
        startTime = System.nanoTime();
        quickSort(myArray3);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.printf("After Quick sort: \n");
        printArray(myArray1);
        System.out.println("Time used: " + duration + " nanoseconds\n");
    }

    private static void copyArray(List<Integer> myArray1, List<Integer> myArray2) {
        for (int i = 0; i < myArray1.size(); i++){
            myArray2.add(myArray1.get(i));
        }
    }

    private static void selectionSort(List<Integer> myArray) {
        for (int i = 0; i < myArray.size(); i++){
            int minimum = i;
            for (int j = i; j < myArray.size(); j++){
                if (myArray.get(minimum) > myArray.get(j)){
                    minimum = j;
                }
            }
            swap(i,minimum,myArray);
        }
    }

    private static void quickSort(List<Integer> myArray) {
        qs(0,myArray.size()-1,myArray);
    }

    private static void qs(int lower, int upper, List<Integer> myArray) {
        int i = lower;
        int j = upper;

        int pivot = myArray.get((lower+upper)/2);

        while (i <= j){
            while (myArray.get(i) < pivot){
                i++;
            }
            while (myArray.get(j) > pivot){
                j--;
            }
            if (i<=j){
                swap(i,j,myArray);
                i++;
                j--;
            }
        }
        if (lower < j)
            qs(lower,j,myArray);
        if (upper > i)
            qs(i,upper,myArray);
    }

    private static void bubbleSort(List<Integer> myArray) {
        boolean sorting = true;
        while(sorting){
            sorting = false;
            for (int i=0;i<myArray.size()-1;i++){
                if (myArray.get(i)>myArray.get(i+1)){
                    swap(i,i+1,myArray);
                    sorting = true;
                }
            }
        }
    }

    private static void swap(int i, int i1, List<Integer> myArray) {
        Collections.swap(myArray, i, i1);
    }

    //print out the array data to console
    private static void printArray(List<Integer> myArray) {
        System.out.printf("     ");
        for (int i = 0; i < myArray.size(); i++){
            System.out.printf("%4d ", myArray.get(i));
            if ((i+1)%20==0 && i!=0){
                System.out.println();
                System.out.printf("     ");
            }
        }
        System.out.println();
    }

    //Generate an array with 20 random numbers, each number is between 1 and 100
    private static void generateRandomArray(List<Integer> myArray) {
        for (int i = 0; i < ARRAY_SIZE; i++){
            myArray.add((int)(Math.random()*100+1));
        }
    }
}
