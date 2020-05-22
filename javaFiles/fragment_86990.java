// Make table above all this, so you can add rows afterwards
model = (DefaultTableModel) jTable1.getModel();      
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
jTable1.setDefaultRenderer(String.class, centerRenderer);

int sum = 0; // You can maintain sum here, then "For-loop" can be skipped
// Now if checkBox is checked just add the row into table
if(lblfried.isSelected())
{  
   int qty = Integer.parseInt(qty_fried.getText());
   model.addRow(new Object[]
    {         
        lblfried.getText(), // name 
        12,                 // price  
        qty_fried.getText(),// quantity <- replace this 
        qty * 12           // total
    }); 
    sum += qty * 12;
}
if(lblfish.isSelected())
{
   int qty = Integer.parseInt(qty_fish.getText());
    model.addRow(new Object[]
    {         
        lblfish.getText(), 
        15,                   
        qty_fish.getText(),               
        qty * 15
    });  
    sum += qty * 15;
}
if(lblchicken.isSelected())
{
   int qty = Integer.parseInt(qty_chicken.getText());
    model.addRow(new Object[]
    {         
        lblchicken.getText(), 
        25,                   
        qty_chicken.getText(),               
        qty * 25
    });    
    sum += qty * 25;
}   

txtsub.setText(Integer.toString(sum));