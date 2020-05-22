File files = new File("E:\\Directory1\\" + m_jiraNumber);
    if (!files.exists()) {
        if (files.mkdirs()) {
            System.out.println("Multiple directories are created!");
            if (files.exists()) {
                System.out.println("Directory exists");
                if (files.canWrite()) {
                    String attachment = resultSet.getString("attachment_url").replace("\\", File.separator);
                    Path sourcePath = Paths.get(attachment);
                    Path destPath = Paths.get(files.getAbsolutePath() + File.separator + sourcePath.getFileName().toString());
                    Files.copy(sourcePath, destPath);
                } else {
                    System.out.println("Access denied !!!");
                }
            }
        } else {
            System.out.println("Failed to create multiple directories!");
        }
    }