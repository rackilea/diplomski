public static String nullToEmpty(final String str) {
  return (null == str) ? "" : str;
}

// ...

nullToEmpty(addresses.getAddrCivicNo());