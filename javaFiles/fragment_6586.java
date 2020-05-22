public List<Scadenza> tutteLeScadenze() {

    final List<Scadenza> scadenze = new ArrayList<Scadenza>();

    txm.doInTransaction(new TransactionAction() {
        @Override
        public void perform() {
            scadenze.addAll(dao.getAll(Scadenza.class));
        }
    });

    return scadenze;
}