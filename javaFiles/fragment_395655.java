weightColumn.setCellFactory(tc -> {
    TextFieldTableCell<Product, VerifiableValue<Double>> cell = new TextFieldTableCell<>();

    cell.setConverter(new StringConverter<VerifiableValue<Double>>() {

        @Override
        public String toString(VerifiableValue<Double> item) {
            return item == null ? "" : String.format("%.3f Kg", item.getValue());
        }

        @Override
        public VerifiableValue<T> fromString(String string) {
            T value = new Double(string.replace("Kg","").trim());
            VerifiableValue.VerificationState verificationState = cell.getItem() == null ? VerifiableValue.VerificationState.UNVERIFIED : cell.getItem().getVerificationState() ;
            return new VerifiableValue<>(value, verificationState);
        }

    });

    ChangeListener<VerifiableValue.VerificationState> verifiedListener = (obs, oldState, newState) -> {
        if (newState == null || newState == VerifiableValue.VerificationState.UNVERIFIED) {
            cell.setStyle("");
        } else if (newState == VerifiableValue.VerificationState.VERIFIED) {
            cell.setStyle("-fx-background-color: yellow ;");
        } else if (newState == VerifiableValue.VerificationState.ERROR) {
            cell.setStyle("-fx-background-color: red ;");
        }
    };


    cell.itemProperty().addListener((obs, oldItem, newItem) -> {
        if (oldItem != null) {
            oldItem.verificationStateProperty().removeListener(verifiedListener);
        }
        if (newItem == null) {
            cell.setStyle("");
        } else {
            if (newItem.getVerificationState() == null || newItem.getVerificationState() == VerifiableValue.VerificationState.UNVERIFIED) {
                cell.setStyle("");
            } else if (newItem.getVerificationState() == VerifiableValue.VerificationState.VERIFIED) {
                cell.setStyle("-fx-background-color: yellow ;");
            } else if (newItem.getVerificationState() == VerifiableValue.VerificationState.ERROR) {
                cell.setStyle("-fx-background-color: red ;");
            }               
            newItem.verificationStateProperty().addListener(verifiedListener);
        }
    });

    return cell ;
});