private void NextBtnActionPerformed(java.awt.event.ActionEvent evt)
{
  try
  {
     if (rs == null)
     {
        fetchResultSet();
     }
     if (rs!=null)
     {
        if (rs.next())
        {
            TxtStockid.setText(rs.getString("StockId"));
            TxtItem.setText(rs.getString("ItemName"));
            TxtQuantity.setText(rs.getString("Quantity"));
            TxtUnitprice.setText(rs.getString("UnitPrice"));
            TxtNetprice.setText(rs.getString("NetPrice"));
            TxtUnitweight.setText(rs.getString("UnitWeight"));
            TxtNetweight.setText(rs.getString("Netweight"));
            TxtDescription.setText(rs.getString("Description"));         
        }
       else
       {
          rs = null;
       }
     }
  }catch(Exception ex){System.out.println(ex);}
}