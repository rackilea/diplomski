Configuration config =
                ServiceBusConfiguration.configureWithSASAuthentication(
                        "abc-ns",
                        "RootManageSharedAccessKey",
                        "ABCdefg123!@#=",
                        ".servicebus.windows.net"
                );