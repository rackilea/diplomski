public void setValue(TextField textField, String value) {
          if (textField.isReadOnly()) {
              textField.setReadOnly(false);
              textField.setValue(value);
              textField.setReadOnly(true);
          } else {
              textField.setValue(value);
          }
    }