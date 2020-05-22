coded_string = "/bfbKNk="
bytes_val = base64.decodestring(coded_string)
bval = "".join("{0:08b}".format(ord(c)) for c in bytes_val)
intval = int(bval, 2)
if ord(bytes_val[0]) & 0x70 != 0:      # manually takes the two's complement
    intval -= int('1' + '00' * len(bytes_val), 16)
print intval