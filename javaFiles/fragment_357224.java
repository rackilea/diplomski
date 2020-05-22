public Term nextElement()
    {
        char minElement = 'Z';
        int index = 0;
        for (int i = 0; i < terms.size(); i++)
        {
            if (terms.get(i).getElement() < minElement)
            {
                minElement = terms.get(i).getElement();
                index = i;
            }
        }
        Term temp = terms.get(index);
        terms.remove(index)
        return temp;
    }