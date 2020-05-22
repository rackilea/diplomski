public Set<String> getGraphics() {
    // Still needed as the constructor of LinkedHashSet will iterate
    // over iGraphicSectors 
    synchronized (iGraphicSectors) {  
        return new LinkedHashSet<String>(iGraphicSectors);
    }
}