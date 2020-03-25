package com.company;



public class Stack {

    private int[] elements;
    private int top;
    private int max;
    Stack(int size)
    {
        elements = new int[size];
        top = 0;
        max = size;
    }
    public void push(int element)
    {
        elements[top] = element;
        top++;
    }

    public int pop()
    {
        top--;
        return elements[top];
    }

    public int peek()
    {
        return elements[top];
    }

    public boolean isEmpty()
    {
        if(top > 0) return true;
        else return false;
    }

    public boolean isFull()
    {
        if(top == max) return true;
        else return false;
    }

    public int size()
    {
        return top;
    }

    public void list()
    {
        for(int i = max - 1; i >= 0; i--) { if(elements[i] != 0)System.out.print(elements[i] + " ");}
    }


    public static void main(String[] args){
        Stack yigin = new Stack(11);
        yigin.push(10);
        yigin.push(5);
        yigin.push(1);
        yigin.push(3);
        yigin.push(7);


        yigin.list();
        System.out.println();
        System.out.println(yigin.pop());
        System.out.println(yigin.pop());
        System.out.println(yigin.pop());

        System.out.println(yigin.size());
        System.out.println("---------------");
        yigin.list();
    }



}
