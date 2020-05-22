final int maxWaitingTime = 10000;
                final int sleepTime = 50;
                int currentWaitingTime = 0;
                File indexHTML = new File(filePath);
                File resourcesFolder = new File(dirPath);
                while (!indexHTML.exists() || !resourcesFolder.exists()) {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                    currentWaitingTime += sleepTime;
                    if (currentWaitingTime == maxWaitingTime)
                        throw new RuntimeException(new TimeoutException("The web page could not be saved."));
                }
                event.getBrowser().dispose();