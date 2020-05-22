import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class QuestionTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    interface A {
        String execute(Map<String, Object> map);
    }

    @Test
    public void test() {
        // Given a map with missed identifiers.
        final Map<String, Object> givenIncorrectMap = new HashMap<>();
        givenIncorrectMap.put("firstIdentifier", null);
        givenIncorrectMap.put("secondIdentifier", null);

        // Given a mocked service
        final A mockedA = Mockito.mock(A.class);

        // which throws an exception exactly for the given map.
        when(mockedA.execute(Mockito.eq(givenIncorrectMap)))
                .thenThrow(new IllegalArgumentException("1"));


        // Now 2 test cases to compare behaviour:


        // When execute with correct map no exception is expected
        mockedA.execute(Collections.singletonMap("firstIdentifier", "any correct value"));

        // When execute with incorrect map the IllegalArgumentException is expected
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("1");

        mockedA.execute(givenIncorrectMap);
    }
}