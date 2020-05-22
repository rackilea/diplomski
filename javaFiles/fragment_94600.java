while(i <a.size()){
            value2 = a.get(i);
            if(value2.substring(0,prefix.length()).compareTo(prefix)!=0){
                break;
            }
            if(value2.endsWith(suffix)){
                counter++;
                setter = true;

            }
            i++;
       }