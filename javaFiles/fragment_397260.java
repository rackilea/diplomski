public interface HealthService {
   DeviceHealth checkDeviceHealth(int id);
}

public class DefaultHealthService implements HealthService {
    public DeviceHealth checkDeviceHealth(int id) {}
}