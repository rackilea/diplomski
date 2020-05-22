class MyClass {
    public ActionListener createTaskListener() {
        return ae -> {
            CreateTask ct = new CreateTask();
            CreateTaskController ctc = 
                new CreateTaskController(ct, mod.getAssessments(), MyClass.this);

            ctc.loadDataToTaskView();
            ct.setVisible(true);
        };    
    }
}