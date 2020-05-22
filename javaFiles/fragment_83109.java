public NodeObject(String ID, boolean gateInfo, boolean securityCameraInfo, boolean exposureInfo, String nodeTypeInfo){
    this.nodeID = ID;
    this.gate = gateInfo;
    this.securityCamera = securityCameraInfo;
    this.isExposed = exposureInfo;
    this.nodeType = nodeTypeInfo;
}