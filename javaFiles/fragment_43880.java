if (first > middle && first > last) {
    return first;
}
if (middle > first && middle > last) {
    return middle;
}
return last;