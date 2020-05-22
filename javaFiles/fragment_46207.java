package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SUT.class })
public class SUTTest {

    @Test
    public void doSomethingReturnsValueFromBufferedReader() throws Exception {
        // Arrange
        SUT sut = new SUT();
        InputStreamReader inputStreamReaderMock = mock(InputStreamReader.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);

        // Set your mocks up to be returned when the new ...Reader calls 
        // are executed in sut.doSomething()
        PowerMockito.whenNew(InputStreamReader.class).
                     withAnyArguments().thenReturn(inputStreamReaderMock);
        PowerMockito.whenNew(BufferedReader.class).
                     withArguments(inputStreamReaderMock).
                     thenReturn(bufferedReaderMock);

        // Set the value you want bReader.readLine() to return 
        // when sut.doSomething() executes
        final String bufferedReaderReturnValue = "myValue";
        doReturn(bufferedReaderReturnValue).when(bufferedReaderMock).readLine();

        // Act
        String result = sut.doSomething();

        // Assert
        assertEquals(bufferedReaderReturnValue, result);
    }
}