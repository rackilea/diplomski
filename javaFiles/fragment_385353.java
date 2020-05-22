try
    {
        str.insert(str.length(), current.element().toString() + " ");
        current = fList.next(current);
    }
    catch(Exception e){
       throw new IllegalStateExcception(super.toString(), e);
    }