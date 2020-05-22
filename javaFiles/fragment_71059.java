// If we really have something to write
    if (cnt > 0) {
        // real write to the adapter
        outputChunk.setBytes(buf, off, cnt);
        try {
            coyoteResponse.doWrite(outputChunk);
        } catch (IOException e) {
            // An IOException on a write is almost always due to
            // the remote client aborting the request. Wrap this
            // so that it can be handled better by the error dispatcher.
            throw new ClientAbortException(e);
        }
    }