/**
 * Wraps a ListItemModel in a CompoundPropertyModel.
 * 
 * @param model
 * @param index
 * @return a CompoundPropertyModel wrapping a ListItemModel
 */
@Override
protected IModel<T> getListItemModel(final IModel<? extends List<T>> model, final int index)
{
    return new CompoundPropertyModel<T>(super.getListItemModel(model, index));
}