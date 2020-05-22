if (smaller_than.size() == i)
    return smaller_than.get(i);
else if (smaller_than.size() < i)
    return search(greater_than, i-smaller_than.size());
else
    return search(smaller_than, i);