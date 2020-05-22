public void stopTrailer() { 
    PlatformImpl.startup(new Runnable() {
        @Override
        public void run() {
            remove(jfxPanel);
            webEngine.load(null);
        }
    });
}