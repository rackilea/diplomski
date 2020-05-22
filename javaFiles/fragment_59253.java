rs.moveToInsertRow();
rs.updateObject(...)
rs.updateObject(...)
rs.updateObject(...)
...
rs.insertRow();

rs.last();
return rs.getObject("ID");