nativeSelect.addListener(new Property.ValueChangeListener() {

        @Override   
        public void valueChange(ValueChangeEvent event) {
            Locale loc = (Locale) event.getProperty().getValue();
            UI.getCurrent().setLocale(loc);
        }

  });