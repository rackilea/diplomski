package com.stackoverflow.q1747780;

import java.util.List;

import org.junit.Test;

public class AddressServiceTest
{
    @Test
    public void testFetch()
    {
        UUIDFactory uuidFactory = new UUIDFactory();
        AddressService service = new AddressService();

        Address address = service.fetch( uuidFactory.newAddressUUID() );        
    }

    @Test
    public void testSearch()
    {
        AddressService service = new AddressService();

        List< UUIDTyped<Address> > uuidList = service.search("foo");        
    }
}