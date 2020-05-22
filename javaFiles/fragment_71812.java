if (outputFileCache.exists())
        {
            connection.setAllowUserInteraction(true);
            connection.setRequestProperty("Range", "bytes=" + outputFileCache.length() + "-");
        }

        connection.setConnectTimeout(14000);
        connection.setReadTimeout(20000);
        connection.connect();

        if (connection.getResponseCode() / 100 != 2)
            throw new Exception("Invalid response code!");
        else
        {
            String connectionField = connection.getHeaderField("content-range");

            if (connectionField != null)
            {
                String[] connectionRanges = connectionField.substring("bytes=".length()).split("-");
                downloadedSize = Long.valueOf(connectionRanges[0]);
            }

            if (connectionField == null && outputFileCache.exists())
                outputFileCache.delete();

            fileLength = connection.getContentLength() + downloadedSize;
            input = new BufferedInputStream(connection.getInputStream());
            output = new RandomAccessFile(outputFileCache, "rw");
            output.seek(downloadedSize);

            byte data[] = new byte[1024];
            int count = 0;
            int __progress = 0;

            while ((count = input.read(data, 0, 1024)) != -1 
                    && __progress != 100) 
            {
                downloadedSize += count;
                output.write(data, 0, count);
                __progress = (int) ((downloadedSize * 100) / fileLength);
            }

            output.close();
            input.close();
       }