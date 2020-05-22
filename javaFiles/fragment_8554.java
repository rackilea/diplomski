if (index == 0)
    {
        //we're deleting the head here. You need to reassign head variable.
        //current = current.getLink(); <-- no. this doesn't change the structure.
        head = head.getLink();//here we set head to head's next. Now structure is changed.
        count--;
        return;
    }