TableModel model = new MyTableModel();
JTable table = new JTable(model);
InsertLesson cell = new InsertLesson(day, hour, model);
…
class InsertLesson {

    TableModel model;

    public InsertLesson(String day, String hour, TableModel model) {
        this.model = model;
        …
    }
    …
}