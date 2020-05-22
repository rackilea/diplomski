dimensionName.getItems().forEach(comboData1 ->
            {
                if(comboData1.getId().equals(DimensionCountCombo.getDimensionId()))
                {
                    dimensionName.getSelectionModel().select(comboData1);
                }
            });