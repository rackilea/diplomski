String[] command = {"/bin/bash",
                    "/usr/local/bin/ticketer/ticketer_robot", 
                    "test",
                    "testoce",
                    "2 - Medium",
                    "2 - Medium",
                    "Error while reading file",
                    "Error While reading file in Job . Please check log NotfnLOG for more details",
                    "testtestets",
                    "testtesttest",
                    "/data/mars/logs/tesst.log",
                    "test@test.com"
};

ProcessBuilder pb = new ProcessBuilder(command);
pb.start();