static int indexOf(char[] source, int sourceOffset, int sourceCount,
                   char[] target, int targetOffset, int targetCount,
                   int fromIndex) {
if (fromIndex >= sourceCount) {
        return (targetCount == 0 ? sourceCount : -1);
}
    if (fromIndex < 0) {
        fromIndex = 0;
    }
    ...