public void populate(ScrolledComposite scroll, Composite composite, List<Photo> items) {
   composite.setRedraw(false);
   for (Photo photo : photos) {
     PhotoComposite composite = new PhotoComposite(composite, photo, SWT.NONE);
     composite.setSize(100, 100);
   }
   composite.setRedraw(true);
   composite.layout(true);

   scroll.setMinSize(composite.computeSize(scroll.getSize().x, SWT.DEFAULT));
}