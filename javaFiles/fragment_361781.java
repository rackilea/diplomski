private ArrayList<Article> articles;
private LayoutInflater mInflater;
private Resources mResource = null;
private static final int SIZE = 5 * 1024*1024;
private DiskLruImageCache imageCache = null;
private ViewHolder mViewHolder = null;

public ArticleAdapter(Context context, ArrayList<Article> articles){
    mInflater = LayoutInflater.from(context);
    this.articles = articles;
    this.mResource = context.getResources();
    this.imageCache = new DiskLruImageCache(context, "ArticleList", SIZE, CompressFormat.JPEG, 70);
}

@Override
public int getCount() {
    // TODO Auto-generated method stub
    return articles.size();
}

@Override
public Object getItem(int pos) {
    // TODO Auto-generated method stub
    return articles.get(pos);
}

@Override
public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

public ViewHolder getViewHolder(){
    return mViewHolder;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    if(convertView == null){
        convertView = mInflater.inflate(R.layout.ligne, null);
        mViewHolder = new ViewHolder();
        mViewHolder.mImage = (ImageView)convertView.findViewById(R.id.photo);
        mViewHolder.mAuteur = (TextView)convertView.findViewById(R.id.auteur);
        mViewHolder.mTitre = (TextView)convertView.findViewById(R.id.titre);
        mViewHolder.mContenu = (TextView)convertView.findViewById(R.id.contenu);
        mViewHolder.mDate = (TextView)convertView.findViewById(R.id.date);

        convertView.setTag(mViewHolder);
    }else{
        mViewHolder = (ViewHolder)convertView.getTag();
    }

    Article a = (Article)getItem(position);
    if(a != null){
        if(mViewHolder.mBitmap != null){
            a.setPhoto(mViewHolder.mBitmap);
        }
        if(a.getPhoto() != null) mViewHolder.mImage.setImageBitmap(a.getPhoto());
        mViewHolder.mAuteur.setText(a.getAuteur());
        mViewHolder.mContenu.setText(wrapWord(position));
        mViewHolder.mDate.setText(a.getDate());
        mViewHolder.mTitre.setText(a.getTitre());
        mViewHolder.mUrl = a.getUrl();

        new ImageTask().execute(mViewHolder);
    }

    return convertView;
}

private String wrapWord(int pos){
    String retour = "";
    String val = mResource.getString(R.string.size_article_list);
    int n = Integer.valueOf(val).intValue();
    Article article = (Article)getItem(pos);
    String a = article.getContenu();

    if(a.length() > n) retour = a.substring(0, n)+"...";
    else retour = a;

    return retour;
}


public class ViewHolder{
    private ImageView mImage;
    private TextView mTitre;
    private TextView mContenu;
    private TextView mAuteur;
    private TextView mDate;
    private Bitmap mBitmap;
    private String mUrl;
}

public class ImageTask extends AsyncTask<ViewHolder, Void, ViewHolder>{
    Bitmap image = null;
    @Override
    protected ViewHolder doInBackground(ViewHolder... holder) {
        // TODO Auto-generated method stub
        ViewHolder ele = holder[0];
        String key = ele.mUrl.replace("http://", "").replace("/", "_").replace("?", "_").replace(".", "_");
        if(imageCache.containsKey(key)){
            ele.mBitmap = imageCache.getBitmap(key);
        }else{
            try {
                byte[] bytes = IOUtils.toByteArray(new URL(ele.mUrl));
                image = ImageResizer.decodeSampleBitmap(bytes, 400, 400);
                ele.mBitmap = image;
                imageCache.put(key, image);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ele;
    }

    protected void onPostExecute(ViewHolder holder){
        if(holder.mBitmap != null) holder.mImage.setImageBitmap(holder.mBitmap);
    }

}}