public class TestMe{
    public static void main(String[] args) {

            GasEngine myGasEngine = new GasEngine();

            ArrayList<Car<Engine>> carlist = new ArrayList<Car<Engine>>();

            CarList.createCarWithEngineAndAddToCarList(myGasEngine, carlist);
        }
    }