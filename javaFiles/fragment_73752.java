public class MainActivity extends Activity {

private ImageView button;
private BitmapFactory.Options mBitmapOptions;
private Bitmap mBitmap;
private TextView mTime;
private ProgressBar bar;
private LruCache<String, Bitmap> mMemoryCache;
private SeekBar seekbar;
private Button change;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    button = (ImageView) findViewById(R.id.logo);
    mTime = (TextView) findViewById(R.id.time);
    bar = (ProgressBar) findViewById(R.id.bar);
    seekbar = (SeekBar) findViewById(R.id.seekbar);
    change = (Button) findViewById(R.id.change);
    mBitmapOptions = new BitmapFactory.Options();
    mBitmapOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher,
            mBitmapOptions);
    mBitmap = Bitmap.createBitmap(mBitmapOptions.outWidth,
            mBitmapOptions.outHeight, Config.ARGB_8888);
    mBitmapOptions.inJustDecodeBounds = false;
    mBitmapOptions.inBitmap = mBitmap;
    mBitmapOptions.inSampleSize = 1;
    BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher,
            mBitmapOptions);
    button.setImageBitmap(mBitmap);     
    // Use 1/8th of the available memory for this memory cache.
    final int cacheSize = 20 * 1024 * 1024;
    mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
        @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
        @Override
        protected int sizeOf(String key, Bitmap bitmap) {
            // The cache size will be measured in kilobytes rather than
            // number of items.
            return bitmap.getByteCount();
        }
    };
    int i = 0;
    System.out.println(mMemoryCache.size());
    System.out.println(mMemoryCache.evictionCount());
    bar.setMax(Images.imageThumbUrls.length - 1);
    seekbar.setMax(Images.imageThumbUrls.length - 1);
    bar.setProgress(0);
    seekbar.setProgress(0);
    for (String string : Images.imageUrls) {
        String position = String.valueOf(i);
        BitmapWorkerTask task = new BitmapWorkerTask(position);
        task.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, string);          
        i++;
    }
    seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            if (Images.imageUrls.length > progress) {
                if (getBitmapFromMemCache(String.valueOf(progress)) != null) {
                    button.setImageBitmap(getBitmapFromMemCache(String
                            .valueOf(progress)));
                } else {
                    // BitmapWorkerTask task = new
                    // BitmapWorkerTask(String.valueOf(progress));
                    // task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,Images.imageUrls[progress]);
                }
            }

        }
    });
    change.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            mMemoryCache.evictAll();
            System.out.println(mMemoryCache.size());
            System.out.println(mMemoryCache.evictionCount());
            bar.setMax(Images.imageUrls.length - 1);
            seekbar.setMax(Images.imageThumbUrls.length - 1);
            bar.setProgress(0);
            seekbar.setProgress(0);
            int i = 0;                              
            for (String string : Images.imageUrls) {
                String position = String.valueOf(i);
                BitmapWorkerTask task = new BitmapWorkerTask(position);
                task.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, string);                  
                i++;
            }

        }
    });
}

@SuppressLint("NewApi")
public void addBitmapToMemoryCache(String position, Bitmap bitmap) {
    if (getBitmapFromMemCache(position) == null) {
        mMemoryCache.put(position, bitmap);
    }
}

public void loadBitmap(int resId, ImageView imageView) {
    final String imageKey = String.valueOf(resId);

    final Bitmap bitmap = getBitmapFromMemCache(imageKey);
    if (bitmap != null) {
        button.setImageBitmap(bitmap);
    } else {
        button.setImageResource(R.drawable.ic_launcher);
    }
}

@SuppressLint("NewApi")
public Bitmap getBitmapFromMemCache(String imageKey) {
    return mMemoryCache.get(imageKey);
}

class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
    private String position = null;

    // Decode image in background.
    public BitmapWorkerTask(String position) {
        this.position = position;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        URL url;
        try {
            url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setConnectTimeout(200);
            connection.setReadTimeout(1000);
            int v = connection.getContentLength() > 0 ? connection
                    .getContentLength() : 0;
            if (v > 0) {                    
                InputStream in = new BufferedInputStream(
                        connection.getInputStream(), 32 * 1024);
                return decodeSampledBitmapFromResource(in, 1000, 1000);
            }
        } catch (MalformedURLException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            addBitmapToMemoryCache(position, result);
            // button.setImageBitmap(getBitmapFromMemCache(position));
            mTime.setText(position);
            bar.setProgress(Integer.parseInt(position));
      //                System.out.println(result);
        }
    }
}

public Bitmap decodeSampledBitmapFromResource(InputStream in, int reqWidth,
        int reqHeight) throws IOException {

    // First decode with inJustDecodeBounds=true to check dimensions
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    in.mark(in.available());
    BitmapFactory.decodeStream(in, null, options);
    // Calculate inSampleSize
    options.inSampleSize = calculateInSampleSize(options, reqWidth,
            reqHeight);
    in.reset();
    // Decode bitmap with inSampleSize set
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(in, null, options);
}

public static int calculateInSampleSize(BitmapFactory.Options options,
        int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and
        // keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}

 }