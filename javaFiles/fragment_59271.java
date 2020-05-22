String classpathStr = System.getProperty("java.class.path");
if (classpathStr.contains("jrxtx.1.0.1.jar")) {
    return new JRxTxCommPortIdentifier();
} else {
    return new PureJavaCommCommPortIdentifier();
}