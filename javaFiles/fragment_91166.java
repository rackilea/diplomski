// Assuming rows is ordered so that equals elements are close each other

public List noTriplicates(Object[] rows) {
    List results = new ArrayList();
    for (int i = 0; i < rows.length; i++) {
        boolean add = true;

        // Check for two previous
        if (i >= 2 && rows[i-2].equals(rows[i])) {
           add = false;

        // Check previous and next
        } else if (i >= 1 && i < rows.length - 1
                       && rows[i-1].equals(rows[i]) 
                       && rows[i+1].equals(rows[i])) {
           add = false;

        // Check for two next
        } else if (i < rows.length - 2 && rows[i+2].equals(rows[i])) {
           add = false;
        }
        if (add) {
            results.add(rows[i]);
        }

    }
    // Here results has no triplicates
    return results;
}