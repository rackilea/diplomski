package de.scrum_master.aspect;

import com.test.Logger;

public aspect LogManipulator {
    void around(Object message) : execution(* Logger.logMessage(*)) && args(message) {
        proceed(message.toString().replaceAll("abc", "xyz"));
    }
}