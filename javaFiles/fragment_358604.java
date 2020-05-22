public void onManagedDrawChildren(final Camera pCamera) {
            final ArrayList<IEntity> children = this.mChildren;
            final int childCount = children.size();
            for(int i = 0; i < childCount; i++) {
                    children.get(i).onDraw(pCamera);
            }
    }