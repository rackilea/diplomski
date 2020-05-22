for(int i=0;i<listElements.size();i++){
                rec record = new rec();
                record.setId((String) listElements.elementAt(i));
                record.setName((String) listName.elementAt(i));
                record.setDate((String) listDate.elementAt(i));
                record.setPrice(((Integer) listPrice.elementAt(i)).intValue());
                record.setAbstract((String) listAbstract.elementAt(i));
                a.addElement(record);   
            }