public class TestCase {
    Data data;

    @Factory(dataProvider = "Data")
    public TestCase(Data data){
        this.data=data;
    }

    @Test(priority = 1)
    public void Open() throws InterruptedException {
        System.out.println("Step 1");
        this.module.open(data);
    }

    @Test(priority = 2)
    public void CheckElementExists(Data data) {
        System.out.println("TWO");
    }
}