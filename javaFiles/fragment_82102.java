public interface BmwModel {
    String getBMW();
}

public interface BmwModelProvider {
    BmwModel getModel();
}

class MyCar {
    public BmwModelProvider getCar() {
        return new Car();
    }

    private class Car implements BmwModelProvider {

        @Override
        public BmwModel getModel() {
            return new Model();
        }

        private class Model implemements BmwModel {

            @Override
            public String getBMW() {
                //...
            }
            //...
        }
    }
}