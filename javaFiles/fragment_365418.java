Queue letterQueue;
Queue numberQueue;

for (every character in the string) {
    if (it's a letter) {
        if (numberQueue is not empty) {
            add the letters alternating into the buffer (stringbuilder), and purge buffers
        }
        add newest letter to letterqueue
    }
    if (it's a number) {
        add newest letter to numberqueue
    }
}
add any remaining unprocessed letters to the queue (this will happen most of the time)

return contents of string buffer