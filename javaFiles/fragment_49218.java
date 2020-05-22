class MyException extends Exception {
    ...

public void addInDB() throws MyException {
    if (isInBase()){
        throw new MyException ("[ReqFamily->addInDB] requirment already in base");
    }
    ...

void addReq(Requirement req){
    ReqFamily pReqParent = (ReqFamily) selectedNode.getData();
    req.setParent(pReqParent);

    try {
        req.addInDB();
    } catch (MyException ex){
        ex.printStackTrace();
    }

    DefaultTreeNode newReqNode = new DefaultTreeNode(req,selectedNode);
    if (pReqParent!=null){
        pReqParent.addRequirement(req);
    }
}