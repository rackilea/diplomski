public class AMapperImpl implements AMapper {

    @Override
    public B AtoB(A entity) {
        if ( entity == null ) {
            return null;
        }

        B b = new B();

        b.setPersons( personArrayToPersonList( entity.getPersons() ) );

        return b;
    }

    protected List<Person> personArrayToPersonList(Person[] personArray) {
        if ( personArray == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( personArray.length );
        for ( Person person : personArray ) {
            list.add( person );
        }

        return list;
    }
}