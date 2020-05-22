for (Sheet sheet : wb ) {
                  for (Row row : sheet) {
                      int rowId = row.getRowNum();
                      if(rowId != 0){
                           Cell del_zone = row.getCell(0);
                           OrderInfo order_Info = new OrderInfo();
                           order_Info.setDel_zone(del_zone.getStringCellValue());
                           Cell cust_id = row.getCell(1);
                           order_Info.setCustomer_id(cust_id.getStringCellValue());
                           orderList.add(order_Info);
                      }
                  }
              }