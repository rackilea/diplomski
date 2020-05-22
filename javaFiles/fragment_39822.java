final int N = mManagedCursors.size();
        for (int i=0; i<N; i++) {
            ManagedCursor mc = mManagedCursors.get(i); 
            if (!mc.mReleased) {
                mc.mCursor.deactivate(); // line 3575
                mc.mReleased = true;
            }
        }