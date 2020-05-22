try
    {
        byte buffer[] = new byte[BUFFER_SIZE];
        // Open archive file
        FileOutputStream stream = new FileOutputStream(archiveFile);
        JarOutputStream out = new JarOutputStream(stream, new Manifest());

        for (int i = 0; i < tobeJared.length; i++)
        {
            if (tobeJared[i].toString().endsWith(CLASS))
            { 
                // the .replace \\ with / is a java JDK bug that requires all
                    // paths to use / and end in / for a jar to properly be made

                LOG.info("Adding "
                        + getPackageNameModified().replace(
                                DOUBLE_BACKSLASH, FORWARD_SLASH) + FORWARD_SLASH + tobeJared[i].getName()
                        + " to the temporary JAR.");

                // Add archive entry
                JarEntry jarAdd = new JarEntry(
                        getPackageNameModified().replace(DOUBLE_BACKSLASH,
                                FORWARD_SLASH) + FORWARD_SLASH + tobeJared[i].getName());
                jarAdd.setTime(tobeJared[i].lastModified());
                out.putNextEntry(jarAdd);

                // Write file to archive
                FileInputStream in = new FileInputStream(tobeJared[i]);
                while (true)
                {
                    int nRead = in.read(buffer, 0, buffer.length);
                    if (nRead <= 0) break;
                    out.write(buffer, 0, nRead);
                }
                in.close();
            }
        }

        out.close();
        stream.close();
        LOG.info("Adding complete --> Success");
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
        LOG.error("Error: " + ex.getMessage());
    }