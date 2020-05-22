RepeatingView cell = new RepeatingView("cell"); 
WebMarkupContainer container = new WebMarkupContainer(cell.newChildId(), cpm);
for (String fn : fieldNames) {                    
    Label label = new Label(fn); 
    container.add(label); 
}               
cell.add(container);
item.add(cell);