logger.debug("The entry is {}.", entry);
//which expands effectively to
if (logger.isDebugEnabled()){
    // Note that it's actually *more* efficient than this - see Huxi's comment below...
    logger.debug("The entry is " + entry + "."); 
}