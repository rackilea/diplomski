package com.codingbat.practice;

public class SleepIn {

    public SleepIn() {
    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
}