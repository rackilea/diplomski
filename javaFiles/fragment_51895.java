coursData.addListener(new ListChangeListener<Cours>() {

    @Override
    public void onChanged(ListChangeListener.Change<? extends Cours> c) {
        while (c.next()) {
            if (c.wasUpdated()) {
                System.out.println("Cours "+items.get(c.getFrom()).getCours()+" changed value to " +items.get(c.getFrom()).isChecked());
            }
          }
    }
});