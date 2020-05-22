ParcelFileDescriptor file = dMgr.openDownloadedFile(downloadId);
            File dbFile = getDatabasePath(Roads.DATABASE_NAME);

            InputStream fileStream = new FileInputStream(file.getFileDescriptor());
            OutputStream newDatabase = new FileOutputStream(dbFile);

            byte[] buffer = new byte[1024];
            int length;

            while((length = fileStream.read(buffer)) > 0)
            {
                newDatabase.write(buffer, 0, length);
            }

            newDatabase.flush();
            fileStream.close();
            newDatabase.close();