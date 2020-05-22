package org.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        App a = new App();
        a.speak("hello world");
    }

    public void speak(String message) {
        log.info(message);
    }
}