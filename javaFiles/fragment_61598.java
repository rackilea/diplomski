Processing 'TestQualified.dex'...
Opened 'TestQualified.dex', DEX version '035'
Class #0            -
  Class descriptor  : 'LTestQualified;'
  Access flags      : 0x0001 (PUBLIC)
  Superclass        : 'Ljava/lang/Object;'
  Interfaces        -
  Static fields     -
  Instance fields   -
  Direct methods    -
    #0              : (in LTestQualified;)
      name          : '<init>'
      type          : '()V'
      access        : 0x10001 (PUBLIC CONSTRUCTOR)
      code          -
      registers     : 1
      ins           : 1
      outs          : 1
      insns size    : 4 16-bit code units
0000e4:                                        |[0000e4] TestQualified.<init>:()V
0000f4: 7010 0300 0000                         |0000: invoke-direct {v0}, Ljava/lang/Object;.<init>:()V // method@0003
0000fa: 0e00                                   |0003: return-void
      catches       : (none)
      positions     : 
        0x0000 line=1
      locals        : 
        0x0000 - 0x0004 reg=0 this LTestQualified; 

    #1              : (in LTestQualified;)
      name          : 'someMethod'
      type          : '()V'
      access        : 0x0002 (PRIVATE)
      code          -
      registers     : 1
      ins           : 1
      outs          : 0
      insns size    : 1 16-bit code units
0000fc:                                        |[0000fc] TestQualified.someMethod:()V
00010c: 0e00                                   |0000: return-void
      catches       : (none)
      positions     : 
        0x0000 line=4
      locals        : 
        0x0000 - 0x0001 reg=0 this LTestQualified; 

  Virtual methods   -
    #0              : (in LTestQualified;)
      name          : 'otherMethod'
      type          : '()V'
      access        : 0x0001 (PUBLIC)
      code          -
      registers     : 1
      ins           : 1
      outs          : 1
      insns size    : 7 16-bit code units
000110:                                        |[000110] TestQualified.otherMethod:()V
000120: 7010 0200 0000                         |0000: invoke-direct {v0}, LTestQualified;.someMethod:()V // method@0002
000126: 7010 0200 0000                         |0003: invoke-direct {v0}, LTestQualified;.someMethod:()V // method@0002
00012c: 0e00                                   |0006: return-void
      catches       : (none)
      positions     : 
        0x0000 line=7
        0x0003 line=8
        0x0006 line=9
      locals        : 
        0x0000 - 0x0007 reg=0 this LTestQualified; 

  source_file_idx   : 3 (TestQualified.java)