import static org.mockito.Mockito.*;
import org.junit.Test;

public class ContainingClassTest {

    @Test
    public void getInventoryFileFromProperties_MY_INVENTORY_FILE_isMissing() {

        FileAccessor fileAccessor = mock(FileAccessor.class);

        // arrange the config file to return a null value for the property
        when(fileAccessor.getProperty(ConfigProperties.MY_INVENTORY_FILE)).thenReturn(null);

        // act; call the method
        new ContainingClass(fileAccessor).getInventoryFileFromProperties();

        // assert that the file-creating method was called with a null path
        verify(fileAccessor).createFile(isNull(String.class));
    }
}