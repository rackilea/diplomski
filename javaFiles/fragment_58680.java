private CompressionType compressionType = null;

public enum CompressionType {
    Compress,
    GZip;
}

public void setCompressionType(CompressionType compressionType) {
    this.compressionType = compressionType;
}