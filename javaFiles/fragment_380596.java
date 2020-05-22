123:         protected final boolean tryRelease(int releases) {
 124:             int c = getState() - releases;
 125:             if (Thread.currentThread() != getExclusiveOwnerThread())
 126:                 throw new IllegalMonitorStateException();
 127:             boolean free = false;
 128:             if (c == 0) {
 129:                 free = true;
 130:                 setExclusiveOwnerThread(null);
 131:             }
 132:             setState(c);
 133:             return free;
 134:         }