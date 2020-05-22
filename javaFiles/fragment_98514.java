i = Math.max(-1, Math.min(i, doc.getNumberOfPages()));

// remove all pages with indices higher than i
for (int j = doc.getNumberOfPages()-1; j > i; j--) {
    doc.removePage(j);
}

// remove all pages with indices lower than i
for (int j = i-1; j >= 0; j--) {
    doc.removePage(j);
}