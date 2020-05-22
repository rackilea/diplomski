@Override
public int compareTo(Packet other) {
    int cmp = 0;
    if (this.packetNum < other.packetNum) {
        cmp = -1;
    }
    if (this.packetNum == other.packetNum) {
        cmp = 0;
    }
    else {
        cmp = 1;
    }
    return cmp;
}