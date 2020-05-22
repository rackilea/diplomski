public static Object readFile(URL url) throws IOException, ClassNotFoundException {
    try(ObjectInputStream is = new ObjectInputStream(url.openStream())) {
        Object o = is.readObject();
        return o;
    }
}

try {
    employeeList =  (TreeSet<Employee>) ListManager.readFile(getClass().getResource("/list/employeeList.txt"));
} catch (ClassNotFoundException i) {
    i.printStackTrace();
} catch (IOException i) {
    i.printStackTrace();
}