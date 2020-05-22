@Service
    class Sender {

        @Autowired
        private ApplicationEventPublisher applicationEventPublisher;

        @EventListener
        public void applicationStarted(ContextRefreshedEvent event) {
            applicationEventPublisher.publishEvent(new MyEvent());
        }


    }