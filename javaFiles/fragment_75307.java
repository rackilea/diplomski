public class CarLoader {

    private Properties sourceProperties;

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();
        for (Object key : sourceProperties.keySet()) {
            // Do the parsing - naive approach
            String[] values = sourceProperties.getProperty((String) key).split(",");
            // Create bean wrapper and set the parsed properties... will handle data convesions with 
            // default property editors or can use custom ConversionService via BeanWrapper#setConversionService
            BeanWrapper wrappedCar = PropertyAccessorFactory.forBeanPropertyAccess(new Car());
            wrappedCar.setPropertyValue("name", values[0].split(":")[0]); // Getting rid of the `:type`
            wrappedCar.setPropertyValue("category", values[2].split(":")[0]); // Getting rid of the `:type`
            // Phase 3 - prosper
            cars.add((Car) wrappedCar.getWrappedInstance());
        }
        return cars;
    }

    public void setSourceProperties(Properties properties) {
        this.sourceProperties = properties;
    }

}