Node searchRec(Node Temp,int key)
    {
        if(Temp != null)
        { 
            if(key>Temp.item)
            {
                return  searchRec(Temp.right,key);  
            }
            if(key<Temp.item)
            {
                return searchRec(Temp.left,key);
            }
            if(key==Temp.item)
                return Temp;
        }
        return Temp;
    }