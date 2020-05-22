float topH, botH;
// Calculate heights
topH = (1 - slider.getPercent()) * parentTable.getHeight();
botH = slider.getPercent() * parentTable.getHeight();

// Apply heights to exterior table cells
subTable.getCells().get(0).height(topH);
subTable.getCells().get(2).height(botH);

// Update label text
label.setText(slider.getValue());