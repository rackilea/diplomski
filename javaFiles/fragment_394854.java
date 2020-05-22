public static void main(String[] args) {
    Report report = new Report();
    List<Class<? extends Producer>> producers = new ArrayList<>();
    producers.add(Producer1.class);
    producers.add(Producer2.class);
    producers.forEach((p) -> {
      try {
        report.addProducer(p.newInstance());
      } catch (InstantiationException | IllegalAccessException ex) {
        System.out.print("Ooops");
      }
    });
    report.produce();
  }