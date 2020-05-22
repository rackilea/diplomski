public class SerialObject implements Serializable
{
    private static final long serialVersionUID = -3975620301776205681L;

    public List<PictureBean> myItems;
}

SerialObject sb = new SerialObject();
sb.myItems = mItems;
intent.putExtra(CategoryDetailPagerActivity.EXTRA_DATA_CATEGORY_DETAIL_LIST, sb);