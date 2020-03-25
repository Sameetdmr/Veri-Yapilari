package com.company;

import java.util.Random;

public class BubbleSort {

    public int[] bubbleSort(int[] list){

        int i,j, temp=0;
        for(i=0;i<list.length-1;i++){
            for(j=0;j<list.length-1-i;j++){
                if(list[j]>list[j+1]){
                    temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        return list;
    }

    public int[] insertionSort(int[] list){


        int i,j,key,temp;
        for(i=1;i<list.length;i++){
            key=list[i];
            j=i-1;
            while(j>0 && key<list[j]){

                //swap
                temp=list[j];
                list[j]=list[j+1];
                list[j+1]=temp;

                j--;

            }
        }



        return list;
    }


    public void mergeSort(int[] list, int lowIndex, int highIndex){

        if(lowIndex==highIndex)
            return;
        else{
            int midIndex=(lowIndex+highIndex)/2;
            mergeSort(list,lowIndex,midIndex);
            mergeSort(list,midIndex+1,highIndex);
            merge(list,lowIndex,midIndex,highIndex);
        }

    }
    public void merge(int[] list, int lowIndex, int midIndex, int highIndex){
        int[] L = new int[midIndex-lowIndex+2];

        for(int i=lowIndex;i<=midIndex;i++){
            L[i-lowIndex]=list[i];
        }
        L[midIndex-lowIndex+1]=Integer.MAX_VALUE;
        int[] R = new int[highIndex-midIndex+1];

        for(int i=midIndex+1;i<=highIndex;i++){
            R[i-midIndex-1]=list[i];
        }
        R[highIndex-midIndex]=Integer.MAX_VALUE;
        int i=0,j=0;

        for(int k=lowIndex;k<=highIndex;k++){
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            }
            else {
                list[k] = R[j];
                j++;
            }
        }
    }

    public static void quickSort(int A[],int p, int r)
    {
        int q;
        if(p<r)
        {
            q=partition(A,p, r);
            quickSort(A,p, q-1);
            quickSort(A,q+1, r);
        }
    }

    public static int partition(int A[],int p, int r){
        int tmp;
        int x = A[r];
        int i = p-1;

        for(int j=p; j<=r-1; j++)
        {
            if(A[j]<=x)
            {
                i++;
                tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
        }
        tmp=A[i+1];
        A[i+1]=A[r];
        A[r]=tmp;
        return i+1;
    }


    public static int[] selectionSort(int[] A,int n){
        int tmp,min;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i;j<n-1;j++){
                if(A[j]<A[min]){
                    min=j;
                }
                tmp=A[i];
                A[i]=A[min];
                A[min]=tmp;
            }

        }
        return A;
    }



}
