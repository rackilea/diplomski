void backupFileAttributes(File dir, BufferedWriter writer) throws IOException
{
    try
    {
        String[] files = dir.list();
        if (files != null)
        {
            for (String s : files)
            {
                String path;
                if (s.equals(".") == true)
                {
                    path = s;
                }
                else
                {
                    path = dir.getPath() + File.separator + s;
                }

                File f = new File(path);
                if (f.canRead() != false)
                {
                    Path p = f.toPath();
                    BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
                    if (f.isDirectory() == true)
                    {
                        writer.append((getFileData(p, attr)));
                        writer.newLine();
                        backupFileAttributes(f, writer);
                    }
                    else if (f.isFile() == true)
                    {
                        writer.append(getFileData(p, attr));
                        writer.newLine();
                    }
                }
            }
        }
    }
    catch (java.nio.file.AccessDeniedException e)
    {
        System.out.println("Access was denied on path: " + dir.getAbsolutePath());
    }
}