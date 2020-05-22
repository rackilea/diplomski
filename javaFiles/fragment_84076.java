String arch = System.getenv("PROCESSOR_ARCHITECTURE");
String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");

String realArch = arch != null && arch.endsWith("64")
                  || wow64Arch != null && wow64Arch.endsWith("64")
                      ? "64" : "32";