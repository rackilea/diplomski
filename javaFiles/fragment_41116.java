FileOutputStream stream = new FileOutputStream(target);
        JarOutputStream jOS = new JarOutputStream(stream);

        LinkedList<File> fileList = new LinkedList<File>();
        buildList(directory, fileList);

        JarEntry entry;

        String basePath = directory.getAbsolutePath();
        byte[] buffer = new byte[4096];
        for(File file : fileList)
        {
            String path = file.getPath().substring(basePath.length() + 1);
            path = path.replace("\\", "/");
            entry = new JarEntry(path);
            entry.setTime(file.lastModified());
            jOS.putNextEntry(entry);
            FileInputStream in = new FileInputStream(file);
            while(true)
            {
                int nRead = in.read(buffer, 0, buffer.length);
                if(nRead <= 0)
                    break;
                jOS.write(buffer, 0, nRead);
            }
            in.close();
            jOS.closeEntry();
        }
        jOS.close();
        stream.close();