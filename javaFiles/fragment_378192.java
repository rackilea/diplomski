public static void setButtonIcon(MyToggleButton button, Icon icon) {
      if (button.getIcon() == icon)
            return;

      Icon old = button.getIcon();

      // Use reflection to set the icon field
      try {
            Field f = AbstractButton.class.getDeclaredField("default_icon");
            f.setAccessible(true);
            f.set(button, icon);
      } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            return;
      }

      button.firePropertyChange(AbstractButton.ICON_CHANGED_PROPERTY, old, icon);
      button.revalidate();
      button.repaint();
}