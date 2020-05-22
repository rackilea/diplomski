try
   {
        File myFile = new File("/sdcard/logger.file");
        Scanner scanner = new Scanner(myFile);
        String bigWord = "";
        while (scanner.hasNextLine()) {
            Scanner wordScanner = new Scanner(scanner.nextLine());
            while (wordScanner.hasNext()) {
                String str = wordScanner.next();
                if(str.length() > bigWord.lenght())
                    bigWord = str;
            }
        }
        show.setText(bigWord);
        Toast.makeText(getBaseContext(),
                "Done reading SD 'mysdfile.txt'",
                Toast.LENGTH_SHORT).show();
   }
   catch (Exception e) 
   {
        Toast.makeText(getBaseContext(), e.getMessage(),
                Toast.LENGTH_SHORT).show();
   }
}