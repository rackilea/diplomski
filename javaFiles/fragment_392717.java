package com.stackoverflow.q1747780;

import java.util.List;

public class PersonService implements Service<Person>
{

    /* (non-Javadoc)
     * @see com.stackoverflow.q1747780.Service#fetch(com.stackoverflow.q1747780.UUIDTyped)
     */
    @Override
    public Person fetch(UUIDTyped<Person> uuid) {
    return null;
    }

    /* (non-Javadoc)
     * @see com.stackoverflow.q1747780.Service#search(java.lang.String)
     */
    @Override
    public List< UUIDTyped<Person> > search(String text) {
    return null;
    }
}