val logPattern =
  raw"^(.*)\s"                                    + // timestamp
  raw"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\s%\S+\s" +
  raw"(\w+)?\s\w+\s"                              + // action
  raw"(\w+)?\s\w*\s*"                             + // protocol
  raw"(\d+)?\s.*outside:"                         + // connection ID
  raw"(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})/"      + // src IP
  raw"(\d+).*:"                                   + // src port
  raw"(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})/"      + // dst IP
  raw"(\d+)"                                        // dst port

val logRE = logPattern.r.unanchored  // only once