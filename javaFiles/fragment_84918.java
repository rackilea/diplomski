public static void main(String... args) throws ExecutionException, InterruptedException {
    Person[] people = Person.generatePeople(5000);
    final List<List<Person>> peopleByDOB = new ArrayList<List<Person>>();
    for (Person person : people) {
        int dob = person.dateOfBirth;
        while (peopleByDOB.size() <= dob) peopleByDOB.add(new ArrayList<Person>());
        peopleByDOB.get(dob).add(person);
    }

    final int runs = 10 * 1000 * 1000;
    long start = System.nanoTime();

    int processors = Runtime.getRuntime().availableProcessors();
    ExecutorService service = Executors.newFixedThreadPool(processors);
    List<Future> futures = new ArrayList<Future>();
    for (int i = 0; i < processors; i++) {
        futures.add(service.submit(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                for (int i = 0; i < runs; i++) {
                    int dayToSearch = rand.nextInt(80 * 365);
                    for (int j = Math.max(0, dayToSearch - 7); j <= dayToSearch + 7 && j < peopleByDOB.size(); j++) {
                        List<Person> peopleWithCloseDOM = peopleByDOB.get(j);
                    }
                }
            }
        }));
    }
    for (Future future : futures) {
        future.get();
    }
    service.shutdown();
    double timeSec = (System.nanoTime() - start) / 1e9;
    double rate = processors * runs / timeSec / 1e6;
    System.out.printf("The search throughput was %.1f million per second%n", rate);
}