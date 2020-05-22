//ProgressBar/Install
                System.out.println("FILELOCATION:\n----------");
                System.out.println(flocation);
                String URL_LOCATION = "http://www.futureretrogaming.tk/gamefiles/ProfessorPhys.iso";
                String LOCAL_FILE = (flocation + "\\ProfessorPhys\\");
                File localfile = new File(LOCAL_FILE);
                if (localfile.exists()) {
                    System.out.println("Directory exists!");
                }
                else {
                    System.out.println("Directory doesn't exist! Creating...");
                    localfile.mkdir();
                    if (localfile.exists())
                        System.out.println("Directory created!");
                }
                System.out.println("LOCALFILE:\n-------");
                System.out.println(LOCAL_FILE);
                URL website = new URL(URL_LOCATION);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(LOCAL_FILE+"\\ProfessorPhys.iso\\");
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("--------\nDone Downloading\n---------");