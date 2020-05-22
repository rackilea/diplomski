int i = System.identityHashCode(str); // returns 0 for null, non zero for all other values, you can also use unsafe getaddr
// converts 0 to 0, any non-zero value to 1:
int b = ((i >>> 16) & 0xffff) | (i & 0xffff);
b = ((b >>> 8) & 0xff) | (b & 0xff);
b = ((b >>> 4) & 0xf) | (b & 0xf);
b = ((b >>> 2) & 0x3) | (b & 0x3);
b = ((b >>> 1) & 0x1) | (b & 0x1);

return func[b].call();