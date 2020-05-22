package com.ooDesign.Country;

import com.ooDesign.Country.Country.State;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class RegistryImpl implements Registry
{
    private final Map<String, State> states;

    public RegistryImpl(Map<String, State> states)
    {
        this.states = states;
    }

    @Override
    public Set<String> listStates()
    {
        return states.keySet();
    }

    @Override
    public State state(String stateName) throws NoSuchPlaceException
    {
        if(!states.containsKey(stateName)) 
            throw new NoSuchPlaceException("State \"" + stateName + "does not exists");
        return states.get(stateName);
    }

    @Override
    public Iterator<State> iterator()
    {
        return states.values().iterator();
    }

}