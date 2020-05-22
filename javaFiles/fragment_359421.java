/**
 * our ItemFactory implementation which creates the ViewHolder for our adapter.
 * It is highly recommended to implement a ViewHolderFactory as it is 0-1ms faster for ViewHolder creation,
 * and it is also many many times more efficient if you define custom listeners on views within your item.
 */
protected static class ItemFactory implements ViewHolderFactory<ViewHolder> {
    public ViewHolder create(View v) {
        return new ViewHolder(v);
    }
}

/**
 * return our ViewHolderFactory implementation here
 *
 * @return
 */
@Override
public ViewHolderFactory<? extends ViewHolder> getFactory() {
    return FACTORY;
}