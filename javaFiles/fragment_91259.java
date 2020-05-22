1B 2A n ml mh converted data 1B 4A 00

1B 2A -- begin the block

n - printing mode
  a) Q110 support 4 kinds of printing modes,as follow：

    n=0x21: 24-point double-density;

    n=0x20: 24-point single-density;

    n=0x01: 8-point double-density;

    n=0x00: 8-point single-density；

  b) NXP only support n=0x21: 24-point double-density;

converted data

1B 4A 00 end the block and execute print (print start)