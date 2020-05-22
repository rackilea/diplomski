finally {
            if (removeGroup) {
                this.remove(group);
            }
            lock.unlock();
        }