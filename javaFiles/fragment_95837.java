public class Test {

    private static Map<Integer, Object> clientTypesInitiated = new ConcurrentHashMap<Integer, Object>();

    /* to process client request we need to 
       create corresponding client type data.
       on the first signal we create that data, 
       on the second - we process the request*/

void onClientRequestReceived(int clientTypeIndex) {
    Object clientTypeData = clientTypesInitiated.get(clientTypeIndex);
    if (clientTypeData == null) {
        synchronized (clientTypesInitiated) {
          clientTypeData = clientTypesInitiated.get(clientTypeIndex);
          if (clientTypeData == null) {
              //new client type index arrived, this type was never processed
              //process data for that client type and put it into the map of types
              clientTypeData = createClientTypeData(clientTypeIndex);
              clientTypesInitiated.put(clientTypeIndex, clientTypeData);
          }
        }
    }
    processClientUsingClientTypeData(clientTypeData);
}

Object createClientTypeData(int clientIndex) {return new Object();}

void processClientUsingClientTypeData(Object clientTypeData) {}