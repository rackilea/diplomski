public File uncompressLz4File(File lz4File) {
            File lz4output = new File(lz4File.getParent() + Constants.SYS_FILE_SEPARATOR + "lz4Output.txt");
            try (InputStream fin = Files.newInputStream(lz4File.toPath());
                 BufferedInputStream in = new BufferedInputStream(fin);
                 OutputStream out = Files.newOutputStream(Paths.get(lz4output.getAbsolutePath()));
                 FramedLZ4CompressorInputStream zIn = new FramedLZ4CompressorInputStream(in)
            ) {
                int n;
                zIn.getCompressedCount();
                byte[] b = new byte[1];
                int uncompressedLength = zIn.read(b, 0, 1) == -1 ? -1 : b[0] & 255;
                b[0] = (byte) uncompressedLength;
                final byte[] buffer = new byte[uncompressedLength];
                while (-1 != (n = zIn.read(buffer))) {
                    out.write(buffer, 0, n);
                }
                return lz4output;
            } catch (Exception e) {
                logger.warn("Failed to uncompress lz4 packages file '{}'. Exception message: '{}'", lz4File.getPath(), e.getMessage());
                logger.debug("Exception: '{}'", e);
                return null;
            }
        }