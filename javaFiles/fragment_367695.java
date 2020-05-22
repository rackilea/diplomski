package de.incompleteco.spring.batch.item.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;

public class LdapItemWriter implements ItemWriter<DirContextOperations> {

    private LdapTemplate ldapTemplate;

    public void write(List<? extends DirContextOperations> items) throws Exception {
        for (DirContextOperations operation : items) {
            ldapTemplate.modifyAttributes(operation);
        }
    }

    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

}