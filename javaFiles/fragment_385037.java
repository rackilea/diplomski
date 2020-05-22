╭│      0x00007fa0a82a50ff: jmp    0x00007fa0a82a5116
 11.39%   16.90%  ││ ↗    0x00007fa0a82a5101: inc    %edx               ;*iinc
                  ││ │                                                  ; - org.openjdk.LoopInc::directInc@46 (line 18)
 12.52%   23.11%  ││ │↗↗  0x00007fa0a82a5103: mov    %r10,0xe8(%r11)    ;*invokevirtual putLong
                  ││ │││                                                ; - java.util.concurrent.ThreadLocalRandom::nextSeed@27 (line 241)
 12.00%    8.14%  ││ │││  0x00007fa0a82a510a: inc    %r8d               ;*iinc
                  ││ │││                                                ; - org.openjdk.LoopInc::directInc@46 (line 18)
  0.03%    0.03%  ││ │││  0x00007fa0a82a510d: cmp    $0x3e8,%r8d
                  │╰ │││  0x00007fa0a82a5114: jge    0x00007fa0a82a50c7  ;*aload_0
                  │  │││                                                ; - org.openjdk.LoopInc::directInc@11 (line 19)
  0.80%    0.91%  ↘  │││  0x00007fa0a82a5116: mov    0xf0(%r11),%r10d   ;*invokevirtual getInt
                     │││                                                ; - java.util.concurrent.ThreadLocalRandom::current@9 (line 222)
  4.28%    1.23%     │││  0x00007fa0a82a511d: test   %r10d,%r10d
                    ╭│││  0x00007fa0a82a5120: je     0x00007fa0a82a517b  ;*ifne
                    ││││                                                ; - java.util.concurrent.ThreadLocalRandom::current@12 (line 222)
  2.11%    0.01%    ││││  0x00007fa0a82a5122: movabs $0x9e3779b97f4a7c15,%r10
  0.01%    0.07%    ││││  0x00007fa0a82a512c: add    0xe8(%r11),%r10    ;*ladd
                    ││││                                                ; - java.util.concurrent.ThreadLocalRandom::nextSeed@24 (line 242)
  7.73%    1.89%    ││││  0x00007fa0a82a5133: mov    %r10,%r9
  1.21%    1.84%    ││││  0x00007fa0a82a5136: shr    $0x21,%r9
  1.90%    0.03%    ││││  0x00007fa0a82a513a: xor    %r10,%r9
  2.02%    0.03%    ││││  0x00007fa0a82a513d: movabs $0xff51afd7ed558ccd,%rcx
  0.94%    1.82%    ││││  0x00007fa0a82a5147: imul   %rcx,%r9           ;*lmul
                    ││││                                                ; - java.util.concurrent.ThreadLocalRandom::mix32@9 (line 182)
  7.01%    2.40%    ││││  0x00007fa0a82a514b: mov    %r9,%rcx
                    ││││  0x00007fa0a82a514e: shr    $0x21,%rcx
  1.89%    0.70%    ││││  0x00007fa0a82a5152: xor    %r9,%rcx
  3.11%    2.55%    ││││  0x00007fa0a82a5155: movabs $0xc4ceb9fe1a85ec53,%r9
  0.99%    1.50%    ││││  0x00007fa0a82a515f: imul   %r9,%rcx
  7.66%    2.89%    ││││  0x00007fa0a82a5163: shr    $0x20,%rcx
  3.70%    1.97%    ││││  0x00007fa0a82a5167: mov    %ecx,%r9d
           0.11%    ││││  0x00007fa0a82a516a: and    $0x1,%r9d          ;*iand
                    ││││                                                ; - java.util.concurrent.ThreadLocalRandom::nextInt@34 (line 356)
  3.76%   11.13%    ││││  0x00007fa0a82a516e: cmp    $0x1,%r9d
                    │╰││  0x00007fa0a82a5172: je     0x00007fa0a82a5101
 10.48%   16.62%    │ ││  0x00007fa0a82a5174: test   %r9d,%r9d
                    │ ╰│  0x00007fa0a82a5177: je     0x00007fa0a82a5103  ;*lookupswitch
                    │  │                                                ; - org.openjdk.LoopInc::directInc@15 (line 19)
                    │  ╰  0x00007fa0a82a5179: jmp    0x00007fa0a82a5103  ;*aload_0
                    │                                                   ; - org.openjdk.LoopInc::directInc@11 (line 19)
                    ↘     0x00007fa0a82a517b: mov    $0xffffff5d,%esi