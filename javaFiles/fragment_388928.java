function findTopObject (elements) {
    var top = Number.POSITIVE_INFINITY;
    var obj = null;

    Array.from(elements).forEach(function (o) {
        var t = o.getBoundingClientRect(o).top;
        if (t > 0.0 && top > t) {
            obj = o;
            top = t;
        }
    });

    return obj;
}