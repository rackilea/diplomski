if (this.instance == null) {
    // threads can swap out here (after first if but before synchronized)
    synchronized(Instance.class) {
        if (this.instance == null) {
            // but only one thread will get here
            this.instance = new Instance();
        }
    }
}