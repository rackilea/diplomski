private static class MyModel extends DefaultListModel {

    public MyModel(String[] numbers) {
        for (String string : numbers) {
            this.addElement(string);
        }
    }
}