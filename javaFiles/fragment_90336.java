Employee employees[] = new Employee employees[100];

for (int i = 0; i < 100; i++) {
        String randomName = "worker" + i;
        Position p = randomPosition();
        switch (p) {
            case PROJECT_LEADER:
                employees[i] = new ProjectLeader(p, randomName, 5000);
                break;
            case DEVELOPER_LEADER:
                employees[i] = new DeveloperLeader(p, randomName, 1000);
                break;
        }
    }