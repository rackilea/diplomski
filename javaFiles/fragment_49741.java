public static void main(String[] args) {
    Worker a = new Worker();
    a.execute();
    System.out.println("Doing swing stuff");
    JOptionPane.showConfirmDialog(null, "Cancel", "Cancel this task?", JOptionPane.DEFAULT_OPTION);
}