package com.cudp.cuprodigy.utils;

import java.awt.*;
import java.io.*;
import java.util.*;

public class SortPlanets
{





    public static void main (String [] args)
    {
        String Mercury="Mercury", Venus="Venus", Earth="Earth", Mars="Mars", Jupiter="Jupiter", Saturn="Saturn", Uranus="Uranus", Neptune="Neptune", Pluto="Pluto" ;
        String list [] = {Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto};

        System.out.println ("Array contents before sorting...");
        System.out.print (list [0]);
        System.out.print (" ");
        System.out.print (list [1]);
        System.out.print (" ");
        System.out.print (list [2]);
        System.out.print (" ");
        System.out.print (list [3]);
        System.out.print (" ");
        System.out.print (list [4]);
        System.out.println ("");
        System.out.println ("************************************");
        System.out.println ("PLEASE. NOT THE ASS.");

        SortPlanets.insertSort (list);

        System.out.println ("************************************");
        System.out.println ("Array contents after sorting...");
        System.out.print (list [0]);
        System.out.print (" ");
        System.out.print (list [1]);
        System.out.print (" ");
        System.out.print (list [2]);
        System.out.print (" ");
        System.out.print (list [3]);
        System.out.print (" ");
        System.out.print (list [4]);





        // Place your program here.  'c' is the output console
    } // main method


    public static void insertSort (String [] list)
    {
        for (int top = 1 ; top < list.length ; top++)
        {
            String item = list [top];
            int i = top;
            while (i > 0 && item.compareTo(list [i - 1]) < 0)
            {
                list [i] = list [i - 1];
                i--;
            }
            list [i] = item;
            System.out.print (list [0]);
            System.out.print (" ");
            System.out.print (list [1]);
            System.out.print (" ");
            System.out.print (list [2]);
            System.out.print (" ");
            System.out.print (list [3]);
            System.out.print (" ");
            System.out.print (list [4]);
            System.out.println ();
        }
    }
} // Insertion_Sort_Example class