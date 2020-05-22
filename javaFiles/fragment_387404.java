Downloader{

  private static volatile Downloader iDownloader=null; 
  private Downloader(){
  }

 public static Downloader createDownloader(){
     if(iDownloader==null){
     synchronized(Downloader.class){
      if(iDownloader==null)
       iDownloader=new Downloader();
       }
      }
  return iDownloader; 
}