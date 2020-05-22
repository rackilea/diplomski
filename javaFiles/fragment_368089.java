public class TreeElementDecoratingLabelProvider extends DecoratingLabelProvider {
   public TreeElementDecoratingLabelProvider(ILabelProvider provider,   ILabelDecorator decorator) {
      super(provider, decorator);
   }

    @Override
    public Color getForeground(Object element) {
      //return your color for element...
      return Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
   }
}