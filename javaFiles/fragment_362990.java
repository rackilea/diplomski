comboBox.addValueChangeListener(new ValueChangeListener() {

   private static final long serialVersionUID = 1L;

   @Override
   public void valueChange(ValueChangeEvent event) {
      twincolselect.updateDataSource(newDataSource);
   }
});