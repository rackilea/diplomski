public static final int ITEM_PER_AD = 3;
@Override
public int getItemCount() {
    int itemCount = capitulos.size();
    itemCount += itemCount / ITEM_PER_AD ;
    return itemCount;
}