Arrays.sort(arr, new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
        Integer.compare(o1.getIdNumber(), o2.getIdNumber());
    }
});