class Resource

    Uri localUri;
    volatile int state; // REMOTE, FETCHING, LOCAL

    Resource()
        if local
            localUri = ...;
            state = LOCAL;
        else
            state = REMOTE

    URI requestResource()

        if(state==LOCAL)  // volatile read
            return localUri;
        if(state==FETCHING)
            return null;

        synchronized(lock)
            if(state==LOCAL)
                return localUri;
            if(state==FETCHING)
                return null;

            // REMOTE, and it's my job to initiate fetching
            state=FETCHING;
            // do actaul fetching outside synchronized block

        schedule fetching...

    void onFetchingDone()

        synchronized(lock)

            if error
                state=REMOTE; // to retry.
                // if we consider error unrecoverable,
                // we need an ERROR state.
            else
                ...
                loalUri = ...;
                state = LOCAL;  // volatile write