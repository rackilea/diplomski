import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassUsingDataProvider {
    @Test(dataProvider = "dp")
    public void testMethod(String name, int age) {
        Assertions.assertThat(name).isNotEmpty();
        Assertions.assertThat(age).isGreaterThan(0);
    }

    @DataProvider(name = "dp")
    public Object[][] getData() {
        return new Object[][]{
                {"Jack Daniels", 10},
                {"Napolean", 15}
        };
    }
}