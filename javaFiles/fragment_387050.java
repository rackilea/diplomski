//                                                  ',' indicates decimals
//                                                      v           v
final NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
final String line = "O5555 5555555555       4711,17         420110315SEK";
final Number parsed = formatter.parse(line.substring(17, 30).trim());
//                                                          ^     ^
//                                                          trimmed