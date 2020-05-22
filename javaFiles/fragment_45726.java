Process backup = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                backup = runtime.exec("mysqldump -uroot -pdbpass --add-drop-database -B dbname -r " + "filepath" + "Filename" + ".sql");//change the dbpass and dbname with your dbpass and dbname

                int dumpCompleted = backup.waitFor();

                if (dumpCompleted == 0) {

                    System.out.println("Backup created successfully!");

                } else {
                    System.out.println("Backup created successfully!");("Could not create the backup");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }