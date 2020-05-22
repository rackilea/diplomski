package de.incompleteco.spring.batch.item.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.ldap.core.DirContextOperations;

public class LdapItemProcessor implements ItemProcessor<DirContextOperations, DirContextOperations> {

    public DirContextOperations process(DirContextOperations item) throws Exception {
        //do some update
        item.setAttributeValue(null, null);
        //return
        return item;
    }

}