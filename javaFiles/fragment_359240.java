JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choosertitle");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    {

        Map<String, Integer> result = new HashMap<String, Integer>();
        File directory = new File(choosers.getSelectedFile().getAbsolutePath()); //This is where you need to change.
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isFile())
            {
                Scanner scanner = new Scanner(new FileReader(file));
                int lineCount = 0;
                try
                {
                    for (lineCount = 0; scanner.nextLine() != null; lineCount++)
                        ;
                } catch (NoSuchElementException e)
                {
                    result.put(file.getName(), lineCount);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : result.entrySet())
        {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
    }