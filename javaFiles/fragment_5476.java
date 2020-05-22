package com.geistware.studentbudgetapp;

import android.provider.BaseColumns;

public class  DatabaseConstants {

    //Variables for DDL statements and such
    public static final String crT = "CREATE TABLE ";
    public static final String inI = "INSERT INTO ";
    public static final String val = " VALUES ";

    //Table Names
    public static final String CAT_BUD_TAB = "CAT_BUD_TAB";
    public static final String TWO_WEE_TAB = "TWO_WEE_TAB";

    //columns from the category_budget_table
    public static final String CAT_ITEM = "CAT_ITEM";
    public static final String IN_OUT = "IN_OUT";
    public static final String BUDGET_AMOUNT = "BUDGET_AMOUNT";
    public static final String ACTUAL_AMOUNT = "ACTUAL_AMOUNT";
    public static final String AMOUNT_STRAYED = "AMOUNT_STRAYED";
    public static final String OVERBUDGET_TF = "OVERBUDGET_TF";
    public static final String AUTOSPEND_TF = "AUTOSPEND_TF";

    //Initial DDL Statements and Initial INSERT statements to populate table
    public static final String createCATBUDTAB = (crT + CAT_BUD_TAB + 
            "(_id INTEGER PRIMARY KEY, CAT_ITEM TEXT, IN_OUT TEXT, BUDGET_AMOUNT REAL, ACTUAL_AMOUNT REAL, AMOUNT_STRAYED REAL, OVERBUDGET_TF INTEGER, AUTOSPEND_TF INTEGER);");
    public static final String createTWOWEETAB = (crT + TWO_WEE_TAB + 
            "(_id INTEGER PRIMARY KEY, SUB_CAT_ITEM TEXT, CAT_ITEM TEXT, COST REAL, ESSENTIAL_TF INTEGER, CURRENT_LAST TEXT, WEEK_ID INTEGER);");

    public static String[] catInsertArray = new String[13];

    // you still need to to put this code into a static initializer block
    static
    {
        catInsertArray[0] = inI + CAT_BUD_TAB + val + "(null, 'Student Loan', 'in', 0.00, 0.00, 0.00, 0, 0 );";
    }

}