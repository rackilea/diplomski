// ListView Listener, changes text fields for the selected B.C in ViewList

            listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BusinessCard>() {
                @Override
                public void changed(ObservableValue<? extends BusinessCard> arg0, BusinessCard oldval,BusinessCard newVal) {
                    if(newVal == null) return;
                    setDataFields(newVal.getUI());      
                }
            });