theSize++;
            AnyType[] newItems = new AnyType[theSize];
            for(int i = 0; i < theSize-1; i++)
                if(items[i].compareTo(x) > 0)
                {
                    newItems[i] = x;
                    newItems[i + 1] = items[i];
                    for(int j = i + 2; j < theSize; j++)
                        newItems[j] = items[j-1];
                    items = newItems;
                    return true;
                }
                else
                    newItems[i] = items[i];
            newItems[theSize-1] = x;
            items = newItems;
            return true;