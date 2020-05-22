package com.stackoverflow.spirit;

import com.stackoverflow.spirit.Spirit.SpiritType;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Party griffindor = new Party("Griffindor"), slytherin = new Party(
                "Slytherin");

        // You can also do for (SpiritType type : SpiritType.values() then
        // type.ordinal()
        for (int i = 0; i < SpiritType.values().length; i++) {
            griffindor.add(new Spirit(SpiritType.values()[i]));
            slytherin.add(new Spirit(SpiritType.values()[i]));
        }

        Spirit mySpirit = new Spirit("NotAHPFan", SpiritType.Celeste);

        slytherin.add(mySpirit);

        System.out.println("Name of party:" + mySpirit.getParty().getName());
        System.out.println("Is on griffindor?:"
                + griffindor.isOnParty(mySpirit));

        // What now?
        griffindor.add(mySpirit);
        System.out.println("Is " + mySpirit.getName() + " on "
                + slytherin.getName() + "?:" + slytherin.isOnParty(mySpirit));

        System.out.println(mySpirit.getName() + " is now on "
                + mySpirit.getParty() + "\n");


        System.out.println(griffindor.getPartyInfo());
        System.out.println(slytherin.getPartyInfo());
    }
}