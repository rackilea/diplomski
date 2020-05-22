package com.stackoverflow.q1747780;

import java.util.List;

import org.junit.Test;



public class PersonServiceTest
{
    @Test
    public void testFetch()
    {
        UUIDFactory uuidFactory = new UUIDFactory();
        PersonService service = new PersonService();

        Person person = service.fetch( uuidFactory.newPersonUUID() );        
    }

    @Test
    public void testSearch()
    {
        PersonService service = new PersonService();

        List< UUIDTyped<Person> > uuidList = service.search("foo");        
    }
}