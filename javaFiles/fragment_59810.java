@KafkaListener(topics = "myTopic")
@Service
public class MultiListenerBean {

@KafkaHandler
public void listen(Cat cat) {
    ...
}

@KafkaHandler
public void listen(Hat hat) {
    ...
}

@KafkaHandler(isDefault = true)
public void delete(Object obj) {
    ...
   }

}