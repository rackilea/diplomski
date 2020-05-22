public Boolean Exists(String search)
  {
    if(data.equals(search))
        return true;
    else
    {
        if (search.compareToIgnoreCase(data) < 0 && leftchild != null)
        {
            return leftchild.Exists(search);
        }
        else if (search.compareToIgnoreCase(data) > 0 && rightchild != null)
        {
            return rightchild.Exists(search);
        }       
    }
    return false;
 }