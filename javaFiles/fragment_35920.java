Process p1 = new Process("P1", new Date(11111111113L));
Process p2 = new Process("P2", new Date(11111111111L));
Process p3 = new Process("P3", new Date(11111111112L));

ArrayList<Process> processes = new ArrayList<Process>();
processes.add(p1);
processes.add(p2);
processes.add(p3);

Collections.sort(processes);