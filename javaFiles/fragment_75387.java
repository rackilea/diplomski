class MyCellTable<T> extends CellTable<T> {
    interface MyResources extends CellTable.Resources {
        @Override
        @ImageOptions(flipRtl = true)
        @Source("hamsterDance.gif") // because I can :P
        ImageResource cellTableLoading();

        @Source("MyCellTableStyle.css")
        Style cellTableStyle();
    }
}