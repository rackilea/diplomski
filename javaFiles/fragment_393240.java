package com.stackoverflow.spirit;

import java.util.HashSet;

public class Party {
    private HashSet<Spirit> spirits = new HashSet<Spirit>();
    private static int id = 0;
    private String name = "Party " + Party.id++;;

    public Party() {
    }

    public Party(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Spirit spirit) {
        if (!spirits.contains(spirit)) {
            spirits.add(spirit);

            if (spirit.getParty() != null) {
                //Remove from previous party to update the other party set
                spirit.getParty().remove(spirit);
            }
            spirit.setParty(this);
        } else {
            // throw new SpiritAlreadyOnParty();
        }
    }


    public void remove(Spirit spirit)
    {
        if (spirits.contains(spirit))
        {
            spirit.setParty(null); // You could create a default empty party for "Nature/Neutral" Spirits perhaps :)
            spirits.remove(spirit);
        }
        else {
            //throw new SpiritNotInParty();
        }
    }

    public boolean isOnParty(Spirit spirit) {
        return spirits.contains(spirit);
    }

    public ArrayList<Spirit> getSpirits()
    {
        return new ArrayList<Spirit>(spirits);
    }

    public int getPartySize() {
        return spirits.size();
    }

    public String getPartyInfo()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Party:" + this.name + " Size:" + this.spirits.size() + "\n");
        for (Spirit s : spirits)
        {
            builder.append(s.getName() + "\n");
        }
        return builder.toString();
    }


    @Override
    public String toString()
    {
        return this.name;
    }
}