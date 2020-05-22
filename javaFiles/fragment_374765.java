private static class MyListener implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println(e.getFirstIndex());
    }
}