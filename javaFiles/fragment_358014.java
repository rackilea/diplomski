List<UIComponent> panelTabs= panelTabSetRef.getChildren();

// Selecting tab to set focus

PanelTab focusTab = (PanelTab) panelTabs.get(tabSelectedIndex);
String tabId = focusTab.getId();

//---