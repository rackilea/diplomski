public class ProcessesdResult extends AppCompatActivity {

   TextView tvProcessedText;
   Bitmap image;
   String photoPath;
   Mat imageMat;
   ImageView ProcessedImage;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       OpenCVLoader.initDebug();

       setContentView(R.layout.activity_processesd_result);

       Intent intenttakeattendance = getIntent();
       String fname = intenttakeattendance.getStringExtra("fname");

       String root = Environment.getExternalStorageDirectory().toString();
       File myDir = new File(root);

       photoPath = myDir+"/sams_images/"+ fname;
       BitmapFactory.Options options = new BitmapFactory.Options();
       options.inPreferredConfig = Bitmap.Config.ARGB_8888;
       image = BitmapFactory.decodeFile(photoPath, options);

       ProcessedImage = findViewById(R.id.processedimage);

       // tvProcessedText = findViewById(R.id.tvprocessedtext);
       //imageProcess(image);
       imageCrop(image);
   }


   public void imageCrop(Bitmap bitmap){

       imageMat=new Mat();

       Utils.bitmapToMat(bitmap,imageMat);
       Mat imgSource=imageMat.clone();

       Mat imageHSV = new Mat(imgSource.size(), CvType.CV_8UC4);
       Mat imageBlurr = new Mat(imgSource.size(),CvType.CV_8UC4);
       Mat imageA = new Mat(imgSource.size(), CvType.CV_32F);
       Imgproc.cvtColor(imgSource, imageHSV, Imgproc.COLOR_BGR2GRAY);
       Imgproc.GaussianBlur(imageHSV, imageBlurr, new Size(5,5), 0);
       Imgproc.adaptiveThreshold(imageBlurr, imageA, 255,Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,7, 5);

       List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
       Imgproc.findContours(imageA, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);

       Vector<Mat> rectangles = new Vector<Mat>();

       for(int i=0; i< contours.size();i++){
           if (Imgproc.contourArea(contours.get(i)) > 50 )
             {
               Rect rect = Imgproc.boundingRect(contours.get(i));
               if ((rect.height > 30 && rect.height < 120) && (rect.width > 120 && rect.width < 500))
                 {
                    Rect rec = new Rect(rect.x, rect.y, rect.width, rect.height);
                    Mat roi = imageMat.submat(rec);
                    String filename = myDir.toString() + "/" + i + ".png";
                    Imgcodecs.imwrite(filename, roi);
                    rectangles.add(new Mat(imgSource, rec));
                    Imgproc.rectangle(imgSource, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255));

                 }
            }
       }

       Bitmap analyzed=Bitmap.createBitmap(imgSource.cols(),imgSource.rows(),Bitmap.Config.ARGB_8888);
       Utils.matToBitmap(imgSource,analyzed);

       saveTempImage(analyzed);
       ProcessedImage.setImageBitmap(analyzed);

   }


/*------------------------------------ Store Image -------------------------------------------*/
   public void saveTempImage(Bitmap bitmap) {
        if (isExternalStorageWritable()) {
            saveImage(bitmap);
        }else{
               Toast.makeText(this, "Please provide permission to write on the Storage!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveImage(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/sams_images");

        if (! myDir.exists()){
            myDir.mkdir();
           // If you require it to make the entire directory path including parents,
           // use directory.mkdirs(); here instead.
       }

       String  timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
       String fname = timeStamp +".jpg";

       File file = new File(myDir, fname);
       if (file.exists()) file.delete ();
       try {
           FileOutputStream out = new FileOutputStream(file);
           finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
           out.flush();
           out.close();

       } catch (Exception e) {
           e.printStackTrace();
         }
   }

   /* Checks if external storage is available for read and write */
   public boolean isExternalStorageWritable() {
       String state = Environment.getExternalStorageState();
       if (Environment.MEDIA_MOUNTED.equals(state)) {
           return true;
       }
       return false;
   }
/*------------------------------------ ************* -----------------------------------------*/


}