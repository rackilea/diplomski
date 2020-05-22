class MyClass {

    MyWriter out;

    public void setOut(MyWriter out) {
        this.out = out;
    }

    // write to file
    public void write(String fileName, List<FigureGeneral> figuresList) {
        try {
            try {
                for (int i = 0; i < figuresList.size(); i++) {
                    out.println(figuresList.get(i).toString());
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file!");
        }
    }
}