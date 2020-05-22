// Traverse both array
    while (i < left.length && j < right.length) {
        if (left[i].compareTo(right[j]) <= 0)
            out[k++] = left[i++];
        else
            out[k++] = right[j++];
    }