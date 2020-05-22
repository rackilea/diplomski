public static class SNMPInterface {
    private final SimpleStringProperty ifIndex;
    private final SimpleStringProperty ifDescr;

    SNMPInterface( String ifIndex, String ifDescr ) {
        this.ifIndex = new SimpleStringProperty( ifIndex );
        this.ifDescr = new SimpleStringProperty( ifDescr );
    }

    public String getIfIndex() {
        return ifIndex.get();
    }

    public void setIfIndex( String index ) {
        ifIndex.set( index );
    }

    public String getIfDescr() {
        return ifDescr.get();
    }

    public void setIfDescr( String descr ) {
        ifDescr.set( descr );
    }
}