@Component
public class ImplementationDemoResolver  implements CommandLineRunner {

    @Autowired
    PublishingService publishingService;

    @Override
    public void run(String... strings) throws Exception {
        FacebookPubInfo fb = new FacebookPubInfo();
        TwitterPubInfo tw = new TwitterPubInfo();

        PubInfo fb2 = new FacebookPubInfo();
        PubInfo tw2 = new TwitterPubInfo();

        publishingService.publish(fb, "I think I am a interesting person, doing interesting things, look at this food!");
        publishingService.publish(tw, "I am eating interesting food. Look! #foodpicture");
        publishingService.publish(fb2, "Wasted Penguinz is the sh17");
        publishingService.publish(tw2, "Join now! #wpArmy");
    }
}