if(dataSize.size()>0){

        for (int i = 0; i < dataSize.size(); i++) {

            if (dataSize.get(i)==0){
                continue;
            }else {
                ids= ids+String.valueOf(dataSize.get(i))+",";
            }

        }

        Toast.makeText(this, ids, Toast.LENGTH_SHORT).show();

    }