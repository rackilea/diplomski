@Transactional(readOnly = true)
public class WebService {
    public void letsThrowAnException() {
        throw new XFireRuntimeException("test!");
    }
}