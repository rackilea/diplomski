List<String> strings = Arrays.asList("Student(name: Joe, Batch ID: 23) is updated",
        "Student(name: John, ID:0, Batch ID: 2503, Result: pass) is updated"
);
for (String string : strings) {
    System.out.println(
            string.replaceFirst(".*Batch ID:\\s+(\\d+).*", "$1")
    );
}