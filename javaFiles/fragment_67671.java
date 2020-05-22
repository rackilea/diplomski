b1.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent d) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("RegistroVoti.txt"));

            Map<String, List<Integer>> studentMarks = new HashMap<>();

            for (String line : lines) {
                String[] parts = line.split(" ");

                if (studentMarks.get(parts[0]) == null) {
                    studentMarks.put(parts[0], new ArrayList<>());
                }
                studentMarks.get(parts[0]).add(Integer.parseInt(parts[1]));
            }

            for (String name : studentMarks.keySet()) {
                System.out.println(name + " " + studentMarks.get(name).stream().mapToInt(i -> i).average().getAsDouble());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});