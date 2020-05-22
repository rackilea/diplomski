if (!outputFile.renameTo(file))
        {
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            try
            {
                in = new BufferedInputStream(new FileInputStream(outputFile));
                out = new BufferedOutputStream(new FileOutputStream(file));
                Streams.copy(in, out);
            }
            finally
            {
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
            }
        }