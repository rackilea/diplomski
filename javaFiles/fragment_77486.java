private ChangeListener<Month> setChoiceBoxIncomeMonthsBehaviour(){
    ChangeListener<Month> months = (ObservableValue<? extends Month> observable, Month oldValue, Month newValue) -> {
        if (!lastMonthValuesFired) {
            incomesData.clear();
            Year selectedYear = choiceBoxIncomeYears.getSelectionModel().getSelectedItem();
            ObservableList<IncomeFX> temp = incomeManager.getIncomesOf(selectedYear, newValue);
            ObservableList<IncomeFX> temp2 = FXCollections.observableList(new ArrayList<IncomeFX>());

            for (IncomeFX t : temp) {
                temp2.add(t);
            }
            incomesData.clear();
            incomesData.addAll(temp2);
        }
    };
    return months;
}