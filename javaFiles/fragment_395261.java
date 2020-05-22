Compiled method (c2)     647   64             java.lang.StringBuilder::toString (17 bytes)
 total in heap  [0x000000010aae8610,0x000000010aae8d80] = 1904
 relocation     [0x000000010aae8730,0x000000010aae8760] = 48
 main code      [0x000000010aae8760,0x000000010aae8a40] = 736
 stub code      [0x000000010aae8a40,0x000000010aae8a58] = 24
 oops           [0x000000010aae8a58,0x000000010aae8a80] = 40
 scopes data    [0x000000010aae8a80,0x000000010aae8b60] = 224
 scopes pcs     [0x000000010aae8b60,0x000000010aae8d20] = 448
 dependencies   [0x000000010aae8d20,0x000000010aae8d28] = 8
 handler table  [0x000000010aae8d28,0x000000010aae8d70] = 72
 nul chk table  [0x000000010aae8d70,0x000000010aae8d80] = 16
Decoding compiled method 0x000000010aae8610:
Code:
[Entry Point]
[Constants]
  # {method} 'toString' '()Ljava/lang/String;' in 'java/lang/StringBuilder'
  #           [sp+0x50]  (sp of caller)
  0x000000010aae8760: mov    0x8(%rsi),%r10d
  0x000000010aae8764: shl    $0x3,%r10
  0x000000010aae8768: cmp    %r10,%rax