JFrame frame=..;//has access to setGlassPane same applies for JDialog and JWindow
    frame.add(panel1);

    ComponentDrag cd=new ComponentDrag(frame);
    cd.registerComponent(button);
    panel1.setName("Droppable");//needed for the dragging and dropping to work correctly especailly over multiple components