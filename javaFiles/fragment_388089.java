import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;

import org.junit.Test;

public class ServiceFactoryTest
{
    @Test
    public void serviceFactoryShouldReturnAServiceForEachFoo()
    {
        Foo foo = mock( Foo.class );
        Service service = new AService( foo );
        Service[] expected = { service, service, service };
        Service[] tooFew = { service, service };
        Service[] tooMany = { service, service, service, service };

        ServiceFactory factory = new ServiceFactory();

        assertThat( factory.createServices( foo, foo, foo ), containsInAnyOrder( expected ) );
        assertThat( factory.createServices( foo, foo, foo ), not( containsInAnyOrder( tooFew ) ) );
        assertThat( factory.createServices( foo, foo, foo ), not( containsInAnyOrder( tooMany ) ) );
    }

    interface Foo
    {}

    interface Service
    {}

    class AService implements Service
    {
        Foo foo;

        public AService( Foo foo )
        {
            this.foo = foo;
        }

        @Override
        public boolean equals( Object that )
        {
            return EqualsBuilder.reflectionEquals( this, that );
        }
    }

    class ServiceFactory
    {
        Collection<? extends Service> createServices( Foo... foos )
        {
            Collection<Service> list = new ArrayList<>();

            for ( Foo foo : foos )
            {
                list.add( new AService( foo ) );
            }

            return list;
        }
    }
}