package com.ooDesign.Country;

public interface CountryBuilder
{
    public StateBuilder build();

    public interface StateBuilder
    {
       public DistrictBuilder state(String stateName);
    }

    public interface DistrictBuilder
    {
        public CityBuilder district(String districtName);
    }

    public interface CityBuilder
    {
        public void city(String cityName);
    }

}