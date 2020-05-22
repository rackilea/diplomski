@Service
public class MyService {

    private final SseEmitter emitter = new SseEmitter();

    public SseEmitter getEmitter() {
        return emitter;
    }
}