package com.ooDesign.Country;

import com.ooDesign.Country.Country.State;
import java.util.Set;

public interface Registry extends Iterable<State>
{
    Set<String> listStates();
    State state(String stateName) throws NoSuchPlaceException;

    public static class NoSuchPlaceException extends Exception
    {
        public NoSuchPlaceException(String message)
        {
            super(message);
        }  
    }
}