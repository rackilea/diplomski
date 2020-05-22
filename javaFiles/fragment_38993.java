public boolean importData(TransferSupport support) {
    DataWrapper dataWrapper = (DataWrapper) support
            .getTransferable().getTransferData(
                    DataWrapperTransferable.FLAVOR);

    if (dataWrapper.getSource() == support.getComponent()) {
        //the originator and destination are the same 
    } else {
        //drop from another component
    }               

    //rest of the method
}