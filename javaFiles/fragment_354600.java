@Override
public void actionPerformed(ActionEvent e) {
    long id = getIdInGui();
    String name = getNameInGui();
    StudentAddedEvent event = new StudentAddedEvent(id, name);
    for (StudentAddedListener listener : studentAddedListeners) {
        listener.studentAdded(event);
    }
}