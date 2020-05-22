String sa = {"as,asd"};    
        String qw = {"12,123,1234"};    
        String[] separated = ItemSumm.split(",");    
        String[] separateds = Itemumm.split(",");

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < separateds.length; i++) {
            if (separated.length == i + 1) {
                if(separated.length == i) {
                    sb.append(separateds[i] + "");
                } else {
                    sb.append(separated[i] + "(" + separateds[i] + ")");
                }
            } else {
                if(separated.length == i) {
                    sb.append("," + separateds[i]);
                } else {
                    sb.append(separated[i] + "(" + separateds[i] + "),");
                }
            }
        }
deleteListItem.list_summ.setText(sb.toString());