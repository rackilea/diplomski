while(current != null)
    {
        if (current.priority > previous.priority)
        {
            nodeReferencingHighestPriority = previous;
            highestPriority = current;
        }

        previous = current;
        current = current.next;
    }