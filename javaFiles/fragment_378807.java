@Override
public CategoryBean clone() throws CloneNotSupportedException {
    return cloneRecursive(new HashMap<CategoryBean, CategoryBean>());    
}

private CategoryBean cloneRecursive(Map<CategoryBean, CategoryBean> categoryBeans) throws CloneNotSupportedException {
    try {
        CategoryBean clone = (CategoryBean) super.clone();
        categoryBeans.put(this, clone);
        clone.setPerimetre(getPerimetre());
        clone.setParentCategory(categoryBeans.get(getParentCategory()));

        List<CategoryBean> categoryListClone = null;
        if (getCategoryList() != null) {
            categoryListClone = new LinkedList<CategoryBean>();
            for (int i = 0; i < getCategoryList().size(); i++) {
                categoryListClone.add(getCategoryList().get(i).cloneRecursive(categoryBeans));
            }
        }
        clone.setCategoryList(categoryListClone);

        clone.setTitle(getTitle());
        clone.setState(getState());
        clone.setActivated(isActivated());
        return clone;
    } catch (CloneNotSupportedException e) {
        throw new InternalError();
    }
}