package com.ooDesign.Country;

import java.util.HashMap;
import com.ooDesign.Country.Registry.NoSuchPlaceException;

public final class Country
{
    private static HashMap<String, State> states = new HashMap<>();

    public static CountryBuilder builder()
    {
        return new CountryBuilderImpl(states);
    }

    public static Registry registry()
    {
        return new RegistryImpl(states);
    }

    public interface Place
    {
        String name();
    }

    public interface State extends Place, Iterable<District>
    {
        public District district(String districtName) throws NoSuchPlaceException;
    }

    public interface District extends Place, Iterable<City>
    {
        public City city(String cityName) throws NoSuchPlaceException;
        public String inState();
    }

    public interface City extends Place
    {
        public ZipCode zipCode();
    }

    public interface ZipCode
    {
        String state();
        String district();
        String city();
    }
}