logger.log(LEVEL.FINE, "data buffer = {0}", 
    new Object() {
        @Override public String toString() {
            return CommonUtils.prepareDataBufferString(dataBuffer));
        }
    });