public void actionPerformed(ActionEvent actionEvent)
{
       Thread t = new Thread(new Runnable() {
         public void run() {
           YouTubeViewer a = new YouTubeViewer();
         }
       });
       t.start();
}