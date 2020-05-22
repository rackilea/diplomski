List<String> nameList = new ArrayList<>();
List<String> jobList = new ArrayList<>();
for (String line : lines) {
    String[] tokens = line.split(";");
    nameList.add(tokens[0]);
    jobList.add(tokens[1]);
}