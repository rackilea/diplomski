public void write(ObservableList<EmployeeEntity> personObservalble) {
    try {
        // write object to file
        FileOutputStream fos = new FileOutputStream("Objectsavefile.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new ArrayList<EmployeeEntity>(personsObservable));
        oos.close();


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}