File source =//
File target = //
File urls = //
 Scanner scanner = new Scanner(urls);
 while (scanner.hasNextLine()) {
 for (File child :source.listFiles())
 {
     if (child.isDirectory()) 



        String line = scanner.nextLine();

        for (File childOfchild:child.listFiles())
         {
             if (childOfchild.getAbsolutePath().contains(line))

                           FileUtils.copyFileToDirectory(childOfchild,target);

         }

        }
}