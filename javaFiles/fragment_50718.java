public static <T extends SugarOrmItem> void  insert_bookmark(
    String prop, T record, ImageView imageView, Class<T> clazz)
{
    List<T> thisitem = Select.from(clazz).
            where(Condition.prop(prop).eq(record.get_id())).list();
    if (thisitem.size() > 0) {
        thisitem.get(0).delete();
        imageView.setImageResource(R.drawable.ic_bookmark_normal);
    } else {
        imageView.setImageResource(R.drawable.ic_bookmarkfill);
    }
}