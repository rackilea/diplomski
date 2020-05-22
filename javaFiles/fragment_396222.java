private DefaultListModel createModel() {
    Random random = new Random();
    DefaultListModel model = new DefaultListModel();
    for (int i = 0; i < 20; i++) {
        long horaInicio = random.nextLong();
        long horaTermino = random.nextLong();
        Time timeInicio = new Time(horaInicio);
        Time timeTermino = new Time(horaTermino);
        Paciente paciente = new Paciente("Paciente " + i);
        Cita cita = new Cita(i, "blah", timeInicio, timeTermino, paciente,
                "blah", "blah", "blah", "blah", "blah");
        model.addElement(cita);
    }
    return model;

}
......
private void sortModel(DefaultListModel model) {
    List<Cita> list = new ArrayList<>();
    for (int i = 0; i < model.size(); i++) {
        list.add((Cita) model.get(i));
    }
    Collections.sort(list);
    model.removeAllElements();
    for (Cita s : list) {
        model.addElement(s);
    }
}