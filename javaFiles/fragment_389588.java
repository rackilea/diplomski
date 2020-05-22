// Draw both Text and Block with transparency
DrawPartition part1 = new DrawPartition(Color.blue, 0, 0, 110, 100, "part1");
part1.setBounds(5, 5, 110, 100);

DrawJob job1 = new DrawJob(Color.green, 0, 0, 110, 100, "Job 1");
job1.setBounds(5, 15, 110, 100);
snapPanel.add(job1);

snapPanel.add(part1);