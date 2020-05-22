Map<String, Object> properties = new HashMap<String, Object>();

// border around a cell
properties.put(CellUtil.BORDER_TOP, CellStyle.BORDER_MEDIUM);
properties.put(CellUtil.BORDER_BOTTOM, CellStyle.BORDER_MEDIUM);
properties.put(CellUtil.BORDER_LEFT, CellStyle.BORDER_MEDIUM);
properties.put(CellUtil.BORDER_RIGHT, CellStyle.BORDER_MEDIUM);

// Give it a color (RED)
properties.put(CellUtil.TOP_BORDER_COLOR, IndexedColors.RED.getIndex());
properties.put(CellUtil.BOTTOM_BORDER_COLOR, IndexedColors.RED.getIndex());
properties.put(CellUtil.LEFT_BORDER_COLOR, IndexedColors.RED.getIndex());
properties.put(CellUtil.RIGHT_BORDER_COLOR, IndexedColors.RED.getIndex());

// Apply it to a cell     
CellUtil.setCellStyleProperties(cell, properties);