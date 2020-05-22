Entity entity = new Entity();


                  while(cellIterator.hasNext())
                  {
                      Cell cell=cellIterator.next();
                      if(cell.getColumnIndex()==0)
                      {
                          continue;
                      }
                      switch(cell.getCellType())
                      {
                         case Cell.CELL_TYPE_BOOLEAN:
                              entity.setBooleanValue(cell.getBooleanValue);
                              break;
                         ...
                      }

                  }