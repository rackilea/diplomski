package com.debug;

import java.util.ArrayList;

/**
 * This is the individual case statement starting at <code>case (Integer or String):</code> <br />
 * The last line stored in the instance will be the <code>break;</code> statement.
 * 
 * @author Vincent
 *
 */
public class Case implements Comparable<Case> {

    private int nameInt;
    private String nameStr = null;
    private ArrayList<String> lines;

    /**
     * Constructs a new <code>Case</code> using integer values as the name.
     * 
     * @param nameInt The integer value name
     * @param lines The lines within this case statement
     * @see {@link ArrayList}
     */
    public Case(int nameInt, ArrayList<String> lines) {
        this.nameInt = nameInt;
        this.lines = lines;
    }

    /**
     * Constructs a new <code>Case</code> using string values as the name.
     * 
     * @param nameStr The string value name
     * @param lines The lines within this case statement
     * @see {@link ArrayList}
     */
    public Case(String nameStr, ArrayList<String> lines) {
        this.nameStr = nameStr;
        this.lines = lines;
    }

    @Override
    public int compareTo(Case aCase) {
        if (this.nameStr != null) {
            return this.nameStr.compareTo(aCase.getNameStr());
        } else {
            if (this.nameInt < aCase.getNameInt()) {
                return -1;
            } else if (this.nameInt > aCase.getNameInt()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Returns the lines stored in this <code>Case</code> instance.
     * 
     * @return {@link ArrayList}
     */
    public ArrayList<String> getLines() {
        return this.lines;
    }

    /**
     * Returns the integer name of this <code>Case</code> instance.
     * 
     * @return {@link Integer}
     */
    public int getNameInt() {
        return this.nameInt;
    }

    /**
     * Returns the string name of this <code>Case</code> instance.
     * 
     * @return {@link String}
     */
    public String getNameStr() {
        return this.nameStr;
    }
}