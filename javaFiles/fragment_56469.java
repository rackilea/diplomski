public class LegacyValueFactory<T, F> implements Callback<CellDataFeatures<T, F>, ObservableValue<F>> {
    private String propertyName;
    public LegacyValueFactory(String propertyName) {
        this.propertyName = propertyName;
    }
    @Override
    public ObservableValue<F> call(CellDataFeatures<T, F> param) {
        try {
            return JavaBeanObjectPropertyBuilder.create().name(propertyName).bean(param.getValue()).build();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}