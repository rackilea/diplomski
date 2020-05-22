for(int i = nElems; i > 0; i--) {
        if (a[i] == a[i + 1]) {
            delete(a[i]);
         // nElems--; // Not needed here. (You're already doing this in delete())
        }
    }