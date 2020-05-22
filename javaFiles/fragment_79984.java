@PostMapping("/getbyId")
public GetDataByIdCardResponse invokeGetbyIdCard(@RequestBody IdCardCredentials IdCardRequest) {

    ObjectFactory factory = new ObjectFactory();


    GetDataByIdCard IdcardReq = new GetDataByIdCard();

    JAXBElement<String> idNo = factory.createGetDataByIdCardIdNumber(IdCardRequest.getIdNumber());
    JAXBElement<String> log = factory.createGetDataByIdCardLog(IdCardRequest.getLog());
    JAXBElement<String> pass = factory.createGetDataByIdCardPass(IdCardRequest.getPass());


    IdcardReq.setLog(log);
    IdcardReq.setPass(pass);
    IdcardReq.setPass(idNo);

    return client.getById(IdcardReq);
}