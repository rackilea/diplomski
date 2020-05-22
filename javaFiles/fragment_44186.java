long[] data = new long[(veryLargeValue+0x3f)>>0x06];//a long has 64 bits

//assign random values

int low = 400>>0x06;
int high = (veryLargeValue-400)>>0x06;
data[low] &= 0xffffffffffffffff<<(0x3f-(400&0x3f));
for(int i = low+0x01; i < high; i++) {
    data[i] = 0x00;
}
data[high] &= 0xffffffffffffffff>>(veryLargeValue-400)&0x3f));