Map<String, Object> themeHash = (Map<String, Object>)theme.getTheme("Theme");
for(String k : themeHash.keySet()) {
   if(k.endsWith("font")) {
       themeHash.put(k, largeFont);
   }
}
UIManager.getInstance().setThemeProps(h);
Display.getInstance().getCurrent().refreshTheme();