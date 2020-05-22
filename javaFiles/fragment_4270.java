@WebService(targetNamespace="webservices.delta.elia.unipd")
public class DeltaUploadService {

    @WebMethod(operationName = "uploadLogData")
    public boolean uploadLogData(@WebParam(name = "deviceID") String deviceID, @WebParam(name = "experimentID") String experimentID,
                             @WebParam(name = "filename") String filename, @WebParam(name = "data") String data){
        System.out.println("Incoming data from device: " + deviceID + ", Experiment ID: " + experimentID);
        //All the parameters now work!
    }
}