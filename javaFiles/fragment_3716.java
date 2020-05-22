static class FileObject {
  public long sizeInBytes;
  public long modifiedDate;

  public FileObject(long sizeInBytes, long modifiedDate) {
    this.sizeInBytes = sizeInBytes;
    this.modifiedDate = modifiedDate;
  }

  public int getYear() {
    return (int) modifiedDate / 100; // only for test purpose
  }

  public int getMonth() {
    return (int) (modifiedDate % 100) / 10; // only for test purpose
  }

  public int getDay() {
    return (int) modifiedDate % 10; // only for test purpose
  }

  @Override
  public String toString() {
    return sizeInBytes + "-" + modifiedDate;
  }
}