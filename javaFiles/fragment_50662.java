package org.eclipse.persistence.platform.database;

public class AccessPlatformDelimiterConfig extends AccessPlatform {

    private static final long serialVersionUID = 7034590043310425678L;

    public AccessPlatformDelimiterConfig() {
        super();
        this.tableQualifier = "";
        this.startDelimiter = "[";
        this.endDelimiter = "]";
    }
}