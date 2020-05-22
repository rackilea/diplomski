import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CustomDateJsonSerializerTest {

    @Mock
    private JsonGenerator gen;

    @Test
    public void testOutputDateValue() {
        CustomDateJsonSerializer serializer = new CustomDateJsonSerializer();
        serializer.serialize(new Date(), gen, null /*or whatever it needs to be*/);

        String expectedOutput = "whatever the correct output should be";
        verify(gen, times(1)).writeString(expectedOutput);
    }

}