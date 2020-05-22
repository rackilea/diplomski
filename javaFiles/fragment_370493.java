1812    public int More ...getActiveCount() {
1813        final ReentrantLock mainLock = this.mainLock;
1814        mainLock.lock();
1815        try {
1816            int n = 0;
1817            for (Worker w : workers)
1818                if (w.isLocked())
1819                    ++n;
1820            return n;
1821        } finally {
1822            mainLock.unlock();
1823        }
1824    }