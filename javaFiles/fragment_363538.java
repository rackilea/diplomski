for (Iterator it_IDS = combobox.getItemIds().iterator(); it_IDS.hasNext();) {
        Object id = (Object) it_IDS.next();
        if(id.toString().equals(cookie.getValue().toString())){
            combo2.select(id);
            break;
        }
    }