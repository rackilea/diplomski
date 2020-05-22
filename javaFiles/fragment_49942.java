if (index >= front) {
    return ring[ring.length + front - 1 - index];
}
else {
    return ring[front - 1 - index];
}