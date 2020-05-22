// Added for Android 9+ to delete shm and wal file if they exist
                    File dbshm = new File(dbfile.getPath() + "-shm");
                    File dbwal = new File(dbfile.getPath()+ "-wal");
                    if (dbshm.exists()) {
                        dbshm.delete();
                    }
                    if (dbwal.exists()) {
                        dbwal.delete();
                    }