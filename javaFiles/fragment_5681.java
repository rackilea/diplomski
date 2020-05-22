package com.ooDesign.Country;

import com.ooDesign.Country.Country.State;
import static com.ooDesign.Country.Country.*;
import com.ooDesign.Country.Registry.NoSuchPlaceException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CountryBuilderImpl implements CountryBuilder
{
    private Map<String, State> states;

    public CountryBuilderImpl(Map<String, State> states)
    {
        this.states = states;
    }

    @Override
    public StateBuilder build()
    {
        return new StateBuilder()
        {
            @Override
            public DistrictBuilder state(String stateName)
            {

                StateImpl currentState;
                if (states.containsKey(stateName))
                {
                    currentState = (StateImpl)states.get(stateName);
                } else
                {
                    currentState = new StateImpl(stateName);
                    states.put(stateName, currentState);
                }

                return new DistrictBuilder()
                {
                    @Override
                    public CityBuilder district(String districtName)
                    {
                        DistrictImpl currentDistrict = currentState.addDistrict(districtName);

                        return new CityBuilder()
                        {
                            @Override
                            public void city(String cityName)
                            {
                                currentDistrict.addCity(cityName);
                            }
                        };
                    }
                };
            }
        };
    }

    private static class StateImpl implements State
    {

        private final Map<String, District> districts;
        private final String stateName;

        StateImpl(String stateName)
        {
            this.districts = new HashMap<>();
            this.stateName = stateName;
        }

        DistrictImpl addDistrict(String districtName)
        {
            if (!districts.containsKey(districtName))
            {
                districts.put(districtName, new DistrictImpl(stateName, districtName));
            }
            return (DistrictImpl)districts.get(districtName);
        }

        @Override
        public District district(String districtName) throws Registry.NoSuchPlaceException
        {
            if (!districts.containsKey(districtName))
            {
                throw new Registry.NoSuchPlaceException("District \"" + districtName + "\" in state of " + stateName + " does not exists");
            } else
            {
                return districts.get(districtName);
            }
        }

        @Override
        public String name()
        {
            return stateName;
        }

        @Override
        public Iterator<Country.District> iterator()
        {
            return districts.values().iterator();
        }

    }

    private static class DistrictImpl implements District
    {

        private final Map<String, Country.City> cities;
        private final String stateName, districtName;

        DistrictImpl(String stateName, String districtName)
        {
            this.cities = new HashMap<>();
            this.stateName = stateName;
            this.districtName = districtName;
        }

        void addCity(String cityName)
        {
            if (!cities.containsKey(cityName))
            {
                cities.put(cityName, new CityImpl(new ZipImpl(stateName, districtName, cityName)));
            }
        }

        @Override
        public City city(String cityName) throws NoSuchPlaceException
        {
            if (!cities.containsKey(cityName))
            {
                throw new Registry.NoSuchPlaceException("City \"" + cityName + "\" in state of " + stateName + " in district of " + districtName + " does not exists");
            } else
            {
                return cities.get(cityName);
            }
        }

        CityImpl getCity(String cityName)
        {
            return (CityImpl)cities.get(cityName);
        }

        @Override
        public String inState()
        {
            return stateName;
        }

        @Override
        public String name()
        {
            return districtName;
        }


        @Override
        public Iterator<Country.City> iterator()
        {
            return cities.values().iterator();
        }

    }

    private static class CityImpl implements City
    {

        private final Country.ZipCode zipCode;

        public CityImpl(Country.ZipCode zipCode)
        {
            this.zipCode = zipCode;
        }

        @Override
        public Country.ZipCode zipCode()
        {
            return zipCode;
        }

        @Override
        public String name()
        {
            return zipCode.city();
        }

    }

    private static class ZipImpl implements ZipCode
    {

        private final String state, district, city;

        public ZipImpl(String state, String district, String city)
        {
            this.state = state;
            this.district = district;
            this.city = city;
        }

        @Override
        public String state()
        {
            return state;
        }

        @Override
        public String district()
        {
            return district;
        }

        @Override
        public String city()
        {
            return city;
        }

        public String toString()
        {
            return "ZIP_CODE: STATE - " + state + "; DISTRICT - " + district + "; CITY - " + city;
        }
    }
}