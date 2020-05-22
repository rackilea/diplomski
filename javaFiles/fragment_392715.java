package com.stackoverflow.q1747780;

import junit.framework.Assert;

import org.junit.Test;

public class UUIDFactoryTest
{
    @Test
    public void testNewUUID()
    {
        UUIDFactory uuidFactory = new UUIDFactory();

        UUIDTyped<Person> newUUID = uuidFactory.newUUID();        
        UUIDTyped<Address> addressUUID = uuidFactory.newUUID();

        Assert.assertNotNull(newUUID.value());
        Assert.assertNotNull(addressUUID.value());
    }    
}