public enum CellType {
      TbComboBox {
         @Override
         public UIComponent newComponent() {
            return new xxx();
         }
      },
      TbDate {
         @Override
         public UIComponent newComponent() {
            return new xxx();
         }
      }

      public abstract UIComponent newComponent();
}