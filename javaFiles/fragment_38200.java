importProductsListView.setCellFactory(
    new Callback<ListView<ProviderProduct>, ListCell<ProviderProduct>>() {
        public ListCell<ProviderProduct> call(ListView<ProviderProduct> param) {
            final ListCell<ProviderProduct> cell = new ListCell<ProviderProduct>();

            final ChangeListener<BigDecimal> priceListener = new ChangeListener<BigDecimal>() {
                @Override
                public void changed(ObservableValue<? extends BigDecimal> observable,BigDecimal oldValue, BigDecimal newValue) {

                     if(providerProduct.hasPriceWarning()){
                         if(!getStyleClass().contains(Consts.CSS_ALERT)){
                              getStyleClass().add(Consts.CSS_ALERT);
                         }
                     }else{
                         getStyleClass().removeAll(Collections.singleton(Consts.CSS_ALERT));
                     }
                }
            });

            cell.itemProperty().addListener(new ChangeListener<ProviderProduct>() {
                @Override
                public void changed(ObservableValue<? extends ProviderProduct> obs, ProviderProduct oldProduct, ProviderProduct newProduct) {
                    if (oldProduct != null) {
                        oldProduct.priceListinoProperty().removeListener(priceListener);
                    }
                    if (newProduct == null) {
                        cell.setText(null);
                        cell.getStyleClass().removeAll(Collections.singleton(Consts.CSS_ALERT);
                    } else {
                        cell.setText(newProduct.toString());
                        if (newProduct.hasPriceWarning()) {
                            if (! cell.getStyleClass().contains(Consts.CSS_ALERT)) {
                                cell.getStyleClass().add(Consts.CSS_ALERT);
                            }
                        } else {
                            cell.getStyleClass().removeAll(Collections.singleton(Consts.CSS_ALERT));
                        }
                        newProduct.priceListinoProperty().addListener(priceListener);
                    }
                }
            });

            return cell ;
         }
});