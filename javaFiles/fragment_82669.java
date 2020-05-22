class ReadonlyInfo implements Info {
    final Info instance;
    ReadonlyInfo(Info info) { 
         if (null == info) { throw new InvalidArgumentException(); } 
         instance = info; 
    }
    String getInfoA() { return instance.getInfoA(); }
    void setInfoA(String infoA) { /** silent ignore */ }
    String getInfoB() { return instance.getInfoB(); }
    void setInfoB(String infoA) { throw new IllegalStateException(); }
}