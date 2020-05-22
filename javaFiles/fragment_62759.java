@Override
protected boolean canEdit(Object element) {
    YourObject obj = (YourObject)element;
    if(IT_IS_THE_ELEMENT_YOU_SEEK)
        return false;
    else
        return true;
}