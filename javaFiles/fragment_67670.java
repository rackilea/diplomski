for (String line : lines) {
    String[] parts = line.split(" ");
    if (studentMarks.get(parts[0]) == null) {
        studentMarks.put(parts[0], new ArrayList<>());
    }
    studentMarks.get(parts[0]).add(Integer.parseInt(parts[1]));
}