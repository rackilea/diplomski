final List<Cours> items=Arrays.asList(new Cours("Analyse", "3"), 
          new Cours("Analyse TP", "4"), 
          new Cours("Thermo", "5"),
          new Cours("Thermo TP", "7"),
          new Cours("Chimie", "8"));
this.coursData = FXCollections.observableArrayList(new Callback<Cours, Observable[]>() {

    @Override
    public Observable[] call(Cours param) {
        return new Observable[] {param.checkedProperty()};
    }
});
coursData.addAll(items);