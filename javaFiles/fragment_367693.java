package de.incompleteco.spring.batch.item.reader;

import java.util.Queue;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.ldap.core.DirContextOperations;

public class LdapItemReader implements ItemReader<DirContextOperations> {

    private Queue<DirContextOperations> dirContextOperations;

    public DirContextOperations read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (dirContextOperations == null) {
            synchronized (this) {
                //load up the dirContextOperations into the queue
            }//end synch
        }//end if
        //retrieve
        return dirContextOperations.poll();
    }

}