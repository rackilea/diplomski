boolean inChapter = false;

  try (
      BufferedReader reader = new BufferedReader(new FileReader(bookName +textExtension));
  ) {
      while ((fileContent = reader.readLine()) != null) {

            if ( inChapter ) {
                if ( fileContent.isEmpty() ) {
                    return;
                }
                System.out.println( fileContent );
            } else {
                if ( fileContent.equals("CHAPTER "+chapterNumber ) {
                   inChapter = true;
                   System.out.println( fileContent );
                }
            }
      }               
  } catch (Exception e) {

    e.printStackTrace();
  }