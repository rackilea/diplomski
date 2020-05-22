public int findItem(String name)
    {
        int max = contactList.size();

        //you might have to subtract this by one 
        //I'm not sure off the top
        int descCnt = max;


        for(int cnt = 0; cnt <= max/2; cnt++)
        {
            if(contactList.get(cnt).getName().equals(name)) return cnt;
            if(contactList.get(descCnt).getName().equals(name)) return descCnt;
            --descCnt;
        }

    }