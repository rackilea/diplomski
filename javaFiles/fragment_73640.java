JTextArea ta = new JTextArea(30,100);
public void updateView() {
    ta.setText("");
    for (String course : model.getCurrentStudentCourses())
    ta.append(course+"\n");
    view.getNameField().setText(model.getCurrentStudent().getName());
    view.getRegisteredPane().setViewportView(ta);
}