List<Employee> result = new ArrayList<>();
Employee currentMax = null;
for (Employee e : list) {
    if (currentMax == null || e.compareTo(currentMax) > 0) {
        currentMax = e;
        result.clear();
        result.add(e);
    }
    else if (currentMax!= null && e.compareTo(currentMax) == 0) {
        result.add(e);
    }
}