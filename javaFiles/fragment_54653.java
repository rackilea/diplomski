// Assuming data contains "/instance/org.eclipse.wb.core/design.palette.flyout.width=192"
String[] parts = data.split("=");

// Get the parts
String key = parts[0];   // /instance/org.eclipse.wb.core/design.palette.flyout.width
String value = parts[1]; // 192 

// Or just directly use the map
map.put(parts[0], parts[1]);