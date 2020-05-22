while (loopBool)
    {
        if (element.children() != null)
        {
            if (element.children().size() >= k)
            {
                if (!element.child(k).text().matches(regex))
                {

                    k++;
                }
                else
                {
                    element.empty();
                    loopBool = false;
                }

            }
            else
            {
                k = 0;
                element = element.child(k);
            }
        }

    }