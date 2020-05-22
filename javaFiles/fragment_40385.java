public class MultiPropertyValueFactory<B,T> implements Callback<TableColumn.CellDataFeatures<B, T>, ObservableValue<T>> {

    private String propriedade;

    public MultiPropertyValueFactory(String propriedade) {
        this.propriedade = propriedade;
    }

    @Override
    public ObservableValue<T> call(TableColumn.CellDataFeatures<B, T> dados) {
        Object elemento=dados.getValue();
        String propriedades[]=propriedade.split("\\.");
        for(int indice=0;indice<propriedades.length;indice++){
            elemento=recuperarElemento(elemento,propriedades[indice]);
        }
        return new SimpleObjectProperty<T>((T) elemento);
    }

    private Object recuperarElemento(Object elemento,String propriedade) {
        try {

            /*using reflection here*/

            Method metodo = RecuperadorMetodos.recuperarMetodoGetPeloNomeDaPropriedade(elemento.getClass(),propriedade);
            return metodo.invoke(elemento);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object();
    }
}