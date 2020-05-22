@Service
public class MyServiceImpl extends Observable implements MyService {

    @Override
    public void manageResponse(String response) {

      this.setChanged();
      this.notifyObservers(response);               
    }
}