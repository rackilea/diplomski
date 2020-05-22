public class CreateSaveImage extends AppCompatActivity {
    private EditText editText;
    private File file;
    Bitmap bmp; // defined Bitmap
    ImageView imgShowOuput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_voice);
        file = new File(Environment.getExternalStorageDirectory() + File.separator + "saveimage");
        file.mkdirs();
        editText = (EditText) findViewById(R.id.edtTextView);
        imgShowOuput = (ImageView) findViewById(R.id.imgShowOuput);
        findViewById(R.id.btnSaveImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmp = getBitmapFromView(editText);
                String path = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + "_image" + ".jpg";
                saveBitmapToFile(bmp, path, 100);
                imgShowOuput.setImageBitmap(bmp);
                Toast.makeText(CreateSaveImage.this, "Image Saved!!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btnSaveImageFromText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmp = writeTextOnImage(CreateSaveImage.this, editText.getText().toString());
                String path = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + "_drawImage" + ".jpg";
                saveBitmapToFile(bmp, path, 100);
                imgShowOuput.setImageBitmap(bmp);
            }
        });
    }
    /**
     * @param view
     * @return
     */
    public static Bitmap getBitmapFromView(View view) {
        view.clearFocus();
        view.setPressed(false);
        view.setFocusable(false);
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    public static String saveBitmapToFile(
            Bitmap bitmap, String path, int quality) {
        File imageFile = new File(path);
        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e("BitmapToTempFile", "Error writing bitmap", e);
        }
        return imageFile.getAbsolutePath();
    }
    public Bitmap writeTextOnImage(Context mContext, String mText) {
        try {
            Resources resources = mContext.getResources();
            float scale = resources.getDisplayMetrics().density;
            /// Here you need to give your default image
            Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.t_img);
            android.graphics.Bitmap.Config bitmapConfig = bitmap.getConfig();
            if (bitmapConfig == null) {
                bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            }
            bitmap = bitmap.copy(bitmapConfig, true);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            // Change Text Size & Color based on your requirement
            paint.setColor(Color.BLACK);
            paint.setTextSize((int) (21 * scale));
            paint.setShadowLayer(20f, 0, 0, Color.LTGRAY);
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            // Change position based on your requirement
            int x = 20;
            int y = 20;
            canvas.drawText(mText, x * scale, y * scale, paint);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }
}