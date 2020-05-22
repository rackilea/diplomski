Set visited = new HashSet();   // all visited objects
Queue next = new ArrayDeque(); // objects whose subobjects are to be visited

// NOTE: At all times, the objects in "next" are contained in "visited"

// add the first object
visited.add(obj);

Object nextObject = obj;

while (nextObject != null)
{
    // do stuff to nextObject

    for (Object o : nextObject.subobjects)
    {
        boolean fresh = visited.add(o);

        if (fresh)
        {
            next.add(o);
        }
    }

    nextObject = next.poll(); // removes the next object to visit, null if empty
}

// Now, "visited" contains all the visited objects