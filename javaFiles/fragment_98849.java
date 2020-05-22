try {
    ...
} catch (RemoteException ex) {
    if(ex instanceof AxisFault){
        logger.error("Axis Fault error: " + ((AxisFault)ex).getFaultString());
    }
}