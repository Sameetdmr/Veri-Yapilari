package com.company;
import java.io.*;

public class kuyruk {

    public double data;

    public kuyruk next;



    //==================================================



    public kuyruk(double d)

    {

        data = d;

        next = null;

    }

    //================================================

    public void display()

    {

        System.out.print(data+"--");



    }

    //=================================================

}

//***********************************************************************



class FirstLastList

{

    private kuyruk first;

    private kuyruk last;



    //===================================================

    public FirstLastList()

    {

        first = null;

        last = null;

    }

    //===================================================



    public boolean isEmpty()

    {

        if(first == null)

            return true;

        else

            return false;

    }

    //=====================================================



    public void insertLast(double item)

    {

        kuyruk newlink = new kuyruk(item);

        if(isEmpty())

            first = newlink;

        else

            last.next = newlink;

        last = newlink;

    }

    //===================================================



    public double deleteFirst()

    {

        double temp = first.data;

        if(first.next == null)

            last = null;

        first = first.next;

        return temp;

    }

    //=================================================

    public void displayList()

    {

        kuyruk current = first;

        while(current != null)

        {

            current.display();

            current = current.next;

        }

        System.out.println("");

    }



}



class   LinkQueue

{

    private FirstLastList theList;

    //====================================================



    public LinkQueue()

    {

        theList = new FirstLastList();



    }

    //================================================

    public boolean isEmpty()

    {

        return theList.isEmpty();

    }

    //===============================================



    public void insert(double j)

    {

        theList.insertLast(j);

    }

    //==================================================



    public double remove()

    {

        return theList.deleteFirst();

    }

    //===================================================

    public void displayQueue()

    {

        System.out.print("Queue ( front-->rear):");

        theList.displayList();

    }





    public static void main(String[] args) throws IOException

    {

        LinkQueue theQueue = new LinkQueue();



        theQueue.insert(20);

        theQueue.insert(40);



        theQueue.displayQueue();



        theQueue.insert(60);

        theQueue.insert(80);



        theQueue.displayQueue();



        theQueue.remove();

        theQueue.remove();



        theQueue.displayQueue();

    }

}
