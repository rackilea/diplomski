Object around() : calculation() {
        long start = System.nanoTime();
        Object result = proceed();
        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", thisJoinPointStaticPart.getSignature(),
                (end - start)));
        return result;
    }