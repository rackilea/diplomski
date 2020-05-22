package com.stackoverflow.q1747780;

import junit.framework.Assert;

import org.junit.Test;


public class UUIDFactoryTest
{
    @Test
    public void testPersonUUID()
    {
        UUIDFactory uuidFactory = new UUIDFactory();

        UUIDTyped<Person> newUUID = uuidFactory.newPersonUUID();

        Assert.assertNotNull(newUUID.value());
    }

    @Test
    public void testAddressUUID()
    {
        UUIDFactory uuidFactory = new UUIDFactory();

        UUIDTyped<Address> newUUID = uuidFactory.newAddressUUID();

        Assert.assertNotNull(newUUID.value());
    }
}