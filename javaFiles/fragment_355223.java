public class Test {

    public static void main(String[] args) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"One"}, 1);
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("isEventDispatchingThread - " + EventQueue.isDispatchThread());
            }
        });

        model.setValueAt("Test", 0, 0);

    }

}