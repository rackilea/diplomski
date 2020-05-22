// assuming the JButtons are in an hashmap
public void setButtonEnabled(String buttonMapKey, boolean enabled) {
   JButton button = buttonMap.get(buttonMapKey);
   if (button != null) {
      button.setEnabled(enabled);
   }

}