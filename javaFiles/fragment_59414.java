import java.io.File;

 File dir = new File("folder-with-images");

 File[] files = dir.listFiles();

 for( int i=0; i < files.length; i++ ){ 
   String path = files[i].getAbsolutePath();

   // check the file type and work with jpg/png files
   if( path.toLowerCase().endsWith(".jpg") || path.toLowerCase().endsWith(".png") ) {

     PImage image = loadImage( path );

     // if template_match(image), break

   }
 }
}