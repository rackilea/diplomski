private void filtreData(String pr) {
    if (pr == null || pr.isEmpty()) {
        filtredList.setPredicate(null);
    } else {
         final StringConverter<S> converter = ((ComboBoxTablePopup<S>) getSkinnable()).getConverter();

         final String data = pr.toLowerCase();
         filtredList.setPredicate(object -> {
            String s = converter.toString(object);
            return s != null && s.toLowerCase().contains(data);
         });
    }
}