// Output file stream
   FileOutputStream dest = new FileOutputStream( "c:/test/test.tar" );

   // Create a TarOutputStream
   TarOutputStream out = new TarOutputStream( new BufferedOutputStream( dest ) );

   // Files to tar
   File[] filesToTar=new File[2];
   filesToTar[0]=new File("c:/test/myfile1.txt");
   filesToTar[1]=new File("c:/test/myfile2.txt");

   for(File f:filesToTar){
      out.putNextEntry(new TarEntry(f, f.getName()));
      BufferedInputStream origin = new BufferedInputStream(new FileInputStream( f ));

      int count;
      byte data[] = new byte[2048];
      while((count = origin.read(data)) != -1) {
         out.write(data, 0, count);
      }

      out.flush();
      origin.close();
   }

   out.close();