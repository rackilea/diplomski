try
                {   
                    inAddress = InetAddress.getByName(host);

                    if (!inAddress.isReachable())
                    {
                       leftOverStudents++;
                       failedStudents = key + InitializeTeacherJar.getInstance().getDelimiter();
                       ApplicationLog.log("Exception :: " + host +" is not reachable as the server is down at his end.", InitializeTeacherJar.getInstance().isLoggingEnabled());
                       continue; 
                    }

                    studentSocket = new Socket(inAddress, port);
                    studentSocket.setSoTimeout(socketTimeout);
                }