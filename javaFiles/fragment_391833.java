dateJs.addChangeListener(new ChangeListener() {
   @Override
   public void stateChanged(ChangeEvent e) {
      SpinnerModel dateModel = dateJs.getModel();
      if (dateModel instanceof SpinnerDateModel) {
         Date date = ((SpinnerDateModel)dateModel).getDate();
         // do stuff with date...
      }
   }
});