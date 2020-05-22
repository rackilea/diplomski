import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsSame;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JacksonTest {

    @JsonTypeInfo(
                  use = JsonTypeInfo.Id.CLASS,
                  include = JsonTypeInfo.As.PROPERTY,
                  property = "@class")

    @JsonSubTypes({ @JsonSubTypes.Type(value = B.class) })
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
    public static abstract class A {
        public A member;
    }

    public static class B extends A {
    }

    @Test
    public void testCirularPolymorphicSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // set up fixture
        List<A> list = new ArrayList<A>();
        B instance1 = new B();
        B instance2 = new B();
        instance1.member = instance2;
        list.add(instance1);
        list.add(instance2);

        CollectionType listType = mapper.getTypeFactory().constructCollectionType(list.getClass(), A.class);
        String serialized = mapper.writerFor(listType).writeValueAsString(list);
        list = mapper.readValue(serialized, listType);

        assertThat(list.size(), is(2));
        assertThat(list.get(0).member, sameInstance(list.get(1)));
    }
}