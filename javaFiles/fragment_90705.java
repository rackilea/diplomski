logs = new ArrayList<File>();               
                String basedir = "/logs/xxx/production/jboss";
                String[] include = {"pvmk*/xxx-production-zzzzz*/xxx-production-zzzzz*-XXX-Metrics.log"};
                System.out.println(new Timestamp(System.currentTimeMillis()));
                System.out.println("Reading files...");
                DirectoryScanner scanner = new DirectoryScanner();
                scanner.setIncludes(include);
                scanner.setBasedir(basedir);
                scanner.setCaseSensitive( true );
                scanner.scan();
                String[] files = scanner.getIncludedFiles();
                for (String file : files) {
                    System.out.println("Loading file: " + file );
                    File log;
                    log = new File(new String ("/logs/xxx/production/jboss/" + file));
                    logs.add(log);
                }