package me;

@Component
public class Target implements Runnable {   
    @Autowired
    private Properties properties;

    public Target(){}

    @PostConstruct
    public void init() {
        properties.getProperty('my.property');
    }

    public void run() {
      //do stuff
   }