public void save() throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
        for (Tasks o : (getTasks())) {
            bw.write(o.getTask() + ";" +
                    o.getDeadline().toString() + ";" +
                    o.getDescription().replace("\n", "\\n"));
            bw.newLine();
        }
    }
}

public void load() throws IOException, ParseException {
    File file = new File(path);
    if (file.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Tasks> tempTasks = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String task = parts[0];
                LocalDate deadline = LocalDate.parse(parts[1]);
                String desc = parts[2].replace("\\n", "\n");
                tempTasks.add(new Tasks(task, deadline, desc));
            }
            tasks.clear();
            tasks.addAll(tempTasks);
        }
    } else
        tasks.clear();
}