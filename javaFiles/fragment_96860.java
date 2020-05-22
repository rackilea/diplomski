private static int[] sImages =  { R.drawable.ic_picture};
private ImageView mImage;
public Article(int a,  View view)
{
    mImage = (ImageView) view.findViewById(R.id.image);
    mImage.setImageResource(sImages[a]);
}