package com.stackoverflow.q1747780;

import java.util.UUID;

public class UUIDFactory
{
    public static class PersonUUID implements UUIDTyped<Person>{

        /* (non-Javadoc)
         * @see com.stackoverflow.q1747780.UUIDTyped#value()
         */
        @Override
        public UUID value() {
        return UUID.randomUUID();
        }};


    public static class AddressUUID implements UUIDTyped<Address>{


        /* (non-Javadoc)
         * @see com.stackoverflow.q1747780.UUIDTyped#value()
         */
        @Override
        public UUID value() {
        return UUID.randomUUID();
        }};


    public <T> UUIDTyped<T> newUUID() {
    return new UUIDTyped<T>()
    {        
        /**
         * There is no difference on how Person and Address UUIDs are generated
         */
        @Override
        public UUID value() {
        return UUID.randomUUID();
        }
    };        
    }

    public UUIDTyped<Person> newPersonUUID(){
    return new PersonUUID();
    }

    public UUIDTyped<Address> newAddressUUID(){
    return new AddressUUID();
    }
}