int totalBytes = 0;
while(iterator.hasNext()){
   Node node = session.getNode(iterator.nextNode().getPaath());
   Resource res = resourceResolver = resourceResolver.getResource(node.getPath());
   byte[] result = null;
   try { 
      Node ntFileNode = getSession().getNode("Path"); 
      Node ntResourceNode = ntFileNode.getNode("jcr:content");
      InputStream is = ntResourceNode.getProperty("jcr:data").getBinary().getStream();
      BufferedInputStream bin = new BufferedInputStream(is);
      result = IOUtils.toByteArray(bin);

      totalBytes = totalBytes + result;

      bin.close();
      is.close(); 
      System.out.print("Bytes of Image "+ result ); // here I am getting bytes of images but in individual. I want to get the totoal count of bytes of all images.

      result=null; //optional - just to be sure.
  }  // while loop ends

  System.out.print("Total bytes of all images= "+ totalBytes);