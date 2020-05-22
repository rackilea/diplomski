class ClientController extends Thread {

    private final ObjectInputStream dataInput;
    private final ObjectOutputStream dataOutput;
    private boolean loggedIn = false;

    ClientController(ObjectInputStream dataInput, ObjectOutputStream dataOutput) {
      this.dataInput = dataInput;
      this.dataOutput = dataOutput;
    }

    @Override
    public void run() {
      try {
        boolean stayConnected = true;
        while (stayConnected) {
          Object data = dataInput.readObject();
          if (data instanceof LoginAction) {
//          check data an do login
            this.loggedIn = true;
            dataOutput.write(new LoginResponse(/* response data */));
          }
          if (data instanceof RequestChatDataAction) {
            if (this.loggedIn) {
              dataOutput.write(new NotLoggedInResponse());
            } else {
              dataOutput.write(new ChatDataResponse(/* chat data.. */));
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }