coded_string = "/bfbKNk="
bytes_val = base64.decodesbytes(coded_string.encode())
bval = "".join("{0:08b}".format(c) for c in bytes_val)
intval = int(bval, 2)
if bytes_val[0] & 0x70 != 0:           # manually takes the two's complement
    intval -= int('1' + '00' * len(bytes_val), 16)
print(intval)