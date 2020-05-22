while (it.hasNext() == true) {
            Map.Entry pairs = (Map.Entry)it.next();

            odt.getTableList().get(0).getCellByPosition("A" + i).setDisplayText((String) pairs.getKey()) ;
            odt.getTableList().get(0).getCellByPosition("B" + i).setDisplayText((pairs.getValue().toString())) ;
            it.remove(); // avoids a ConcurrentModificationException
            i++ ;
            }