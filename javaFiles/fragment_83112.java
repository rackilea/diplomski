import com.jniwrapper.win32.system.MemoryStatus;

...

private void test() {
  MemoryStatus mStatus = new MemoryStatus();
  System.out.println("TotalVirtual: " + getBytesInMB(mStatus.getTotalVirtual()) + " MB");
  System.out.println("AvailVirtual: " + getBytesInMB(mStatus.getAvailVirtual()) + " MB");
  System.out.println("UsedVirtual:  " + getBytesInMB(mStatus.getTotalVirtual() - mStatus.getAvailVirtual()) + " MB");
}

private long getBytesInMB(final long input) {
  return input / 1024 / 1024;
}