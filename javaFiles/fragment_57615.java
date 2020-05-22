@Bean
public Step step1() {
  return stepBuilderFactory.get("step1")
      .<Client, Subscription> chunk(1000)
      .reader(new ListItemReader<Client>(new ArrayList<Client>() {
        {
          add(Client.builder().id("1").subscriptionCode("AA").activated(true).build());
          add(Client.builder().id("2").subscriptionCode("BB").activated(true).build());
          add(Client.builder().id("3").subscriptionCode("AA").activated(false).build());
          add(Client.builder().id("4").subscriptionCode("AA").activated(true).build());
        }
      }))
      .processor(new ItemProcessor<Client, Subscription>() {
        private List<Subscription> subscriptions;

        public Subscription process(Client item) throws Exception {
          for (Subscription s : subscriptions) { // try to retrieve existing element
            if (s.getSubscriptionCode().equals(item.getSubscriptionCode())) { // element found
              if(item.getActivated()) {
                s.getActivatedUserCount().incrementAndGet(); // increment user count
                log.info("Incremented subscription : " + s);
              }                             
              return null; // existing element -> skip
            }
          }
          // Create new Subscription
          Subscription subscription = Subscription.builder().subscriptionCode(item.getSubscriptionCode()).activatedUserCount(new AtomicInteger(1)).build();
          subscriptions.add(subscription);
          log.info("New subscription : " + subscription);
          return subscription;
        }

        @BeforeStep
        public void initList() {
          subscriptions = Collections.synchronizedList(new ArrayList<Subscription>());
        }

        @AfterStep
        public void clearList() {
          subscriptions.clear();
        }
      })
      .writer(new ItemWriter<Subscription>() {                  
        public void write(List<? extends Subscription> items) throws Exception {
          log.info(items);
          // do write stuff
        }                   
      })
      .build();
}