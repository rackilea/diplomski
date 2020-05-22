package com.ooDesign;

import com.ooDesign.Country.Country;
import com.ooDesign.Country.Country.City;
import com.ooDesign.Country.Country.District;
import com.ooDesign.Country.Country.State;
import com.ooDesign.Country.Registry.NoSuchPlaceException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryClient 
{
    public static void main(String[] args)
    {
        /*Creating various combinations of places.*/      
        build("ImaginaryState" , "ImaginaryDistrict", "MadCity");
        build("ImaginaryState" , "ImaginaryDistrict", "EastCity");
        build("ImaginaryState" , "ImaginaryDistrict", "WestCity");
        build("DamnGoodState" , "DamnGoodDistrict", "DamnGoodCity");
        build("ImaginaryState" , "ProgrammersDistrict", "NoLifersCity");
        build("DamnGoodState" , "DamnGoodDistrict", "DamnBadCity");
        /*"DamnGoodCity" in "DamnBadDistrict" is not the same as "DamnGoodCity" in "DamnGoodDistrict"
           since they are located in different districts. You can easily find out how to change implementation
           to not allow to build multiple cities with same name even if they are in different districts.*/
        build("DamnGoodState" , "DamnBadDistrict", "DamnGoodCity");

        /*Printing what we just created*/
        try
        {
            traverseWorld();
        } catch (NoSuchPlaceException ex)
        {
            Logger.getLogger(CountryClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Getting state of speciffic city (thanks to ZipCode interface)*/
        try
        {
            print(Country.registry().state("DamnGoodState").district("DamnBadDistrict").city("DamnGoodCity").zipCode().state());
        } catch (NoSuchPlaceException ex)
        {
            Logger.getLogger(CountryClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void print(String string)
    {
        System.out.println(string);
    }

    static void traverseWorld() throws NoSuchPlaceException
    {
        for(State s : Country.registry())
        {
            print("Districts in state \"" + s.name() + "\" :");
            for(District d : s)
            {
                print("   Cities in district \"" + d.name() + "\" :");
                for(City c : d)
                {
                    print("      " + c.name());
                }
            }
            print("---------------------------------------------");
        }
    }

    static void build(String state, String district, String city)
    {
        Country.builder().build().state(state).district(district).city(city);
    }

    static void build(String state, String district)
    {
        Country.builder().build().state(state).district(district);
    }

    static void build(String state)
    {
        Country.builder().build().state(state);
    }
}