@Service
class TopicService {
   private final List<String> topics;

   TopicService(@Topics final List<String> topics) {
      this.topics = topics;
   }

   ...
}