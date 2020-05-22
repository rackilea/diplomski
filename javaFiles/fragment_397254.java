DynastyPQ pq = getPQ();
if (pq instanceof CustomAPQ) {
    CustomAPQ a = (CustomAPQ)pq;
    a.customAPQmethod();
} else if (pq instanceof CustomBPQ) {
    CustomBPQ b = (CustomBPQ)pq;
    b.customBPQmethod();
} else {
    // Neither a CustomAPQ nor a CustomBPQ.
}