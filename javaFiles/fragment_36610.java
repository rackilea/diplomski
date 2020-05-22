while(first.size() > 0 || second.size() > 0){
        if(s != second.size() && f != first.size()){
            if(first.get(f).compareTo(second.get(s)) > 0){
                answer.add(second.get(s));
                s++;
            }

            else if(first.get(f).compareTo(second.get(s)) < 0){
                answer.add(first.get(f));
                f++;
            }
        }

        else if(f == first.size()){
            while(s != second.size()){
                answer.add(second.get(s));
                s++;
            }
        }

        else{
            while(f != first.size()){
                answer.add(first.get(f));
                f++;
            }
        }
    }