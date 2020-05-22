boolean isContinue = true;
    while(isContinue) {
        try {
            for(SelectionKey selectionKey : selector.keys()) {
                selectionKey.channel().close();
                selectionKey.cancel();
            }
            isContinue = false; // continue till all keys are cancelled
        } catch (ConcurrentModificationException e) {
            // This should not occur. But log a debug message in case this is encountered
        }
    }