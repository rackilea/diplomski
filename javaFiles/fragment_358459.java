public class TreetableWithoutSelectionBackground extends VerticalLayout {
    public TreetableWithoutSelectionBackground() {
        // standard tree table setup
        TreeTable treeTable = new TreeTable();
        treeTable.setSelectable(true);
        treeTable.setItemCaptionMode(AbstractSelect.ItemCaptionMode.ID);
        treeTable.setItemCaptionPropertyId("caption");

        // cell style generator to decide whether the item should or should not have a background
        // since we'll be using a bean item container, the itemIds will be the beans themselves so we can use those directly
        treeTable.setCellStyleGenerator((source, itemId, propertyId) -> ((MyBean) itemId).shouldHaveBackground() ? null : "no-background");

        // standard container
        BeanItemContainer<MyBean> container = new BeanItemContainer<>(MyBean.class);
        treeTable.setContainerDataSource(container);

        // add some dummy data
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean shouldHaveBackground = random.nextBoolean();
            container.addItem(new MyBean("Item - " + i + " [" + shouldHaveBackground + "]", shouldHaveBackground));
        }

        addComponent(treeTable);
    }

    // basic bean
    public static class MyBean {
        private String caption;
        private boolean shouldHaveBackground;

        public MyBean(String caption, boolean shouldHaveBackground) {
            this.caption = caption;
            this.shouldHaveBackground = shouldHaveBackground;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public boolean shouldHaveBackground() {
            return shouldHaveBackground;
        }
    }
}