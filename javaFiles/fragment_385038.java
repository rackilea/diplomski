0.01%    0.01%  ↗  0x00007f65588d8260: mov    %edx,%r9d
  0.01%           │  0x00007f65588d8263: nopw   0x0(%rax,%rax,1)
 11.99%   11.38%  │  0x00007f65588d826c: data16 data16 xchg %ax,%ax  ;*iconst_0
                  │                                                ; - org.openjdk.LoopInc::indirectInc@11 (line 34)
                  │  0x00007f65588d8270: mov    0xf0(%r8),%r10d    ;*invokevirtual getInt
                  │                                                ; - java.util.concurrent.ThreadLocalRandom::current@9 (line 222)
                  │  0x00007f65588d8277: test   %r10d,%r10d
                  │  0x00007f65588d827a: je     0x00007f65588d8331  ;*ifne
                  │                                                ; - java.util.concurrent.ThreadLocalRandom::current@12 (line 222)
  0.01%           │  0x00007f65588d8280: movabs $0x9e3779b97f4a7c15,%r10
 11.80%   11.49%  │  0x00007f65588d828a: add    0xe8(%r8),%r10     ;*ladd
                  │                                                ; - java.util.concurrent.ThreadLocalRandom::nextSeed@24 (line 242)
  0.01%    0.01%  │  0x00007f65588d8291: mov    %r10,0xe8(%r8)     ;*invokevirtual putLong
                  │                                                ; - java.util.concurrent.ThreadLocalRandom::nextSeed@27 (line 241)
                  │  0x00007f65588d8298: mov    %r9d,%edx
  0.01%    0.01%  │  0x00007f65588d829b: inc    %edx
 11.12%   12.40%  │  0x00007f65588d829d: mov    %r10,%rcx
           0.01%  │  0x00007f65588d82a0: shr    $0x21,%rcx
  0.03%           │  0x00007f65588d82a4: xor    %r10,%rcx
  0.06%    0.03%  │  0x00007f65588d82a7: movabs $0xff51afd7ed558ccd,%r10
 12.38%   13.94%  │  0x00007f65588d82b1: imul   %r10,%rcx          ;*lmul
                  │                                                ; - java.util.concurrent.ThreadLocalRandom::mix32@9 (line 182)
  0.03%    0.01%  │  0x00007f65588d82b5: mov    %rcx,%r10
                  │  0x00007f65588d82b8: shr    $0x21,%r10
           0.03%  │  0x00007f65588d82bc: xor    %rcx,%r10
 11.43%   12.62%  │  0x00007f65588d82bf: movabs $0xc4ceb9fe1a85ec53,%rcx
           0.01%  │  0x00007f65588d82c9: imul   %rcx,%r10
  0.34%    0.30%  │  0x00007f65588d82cd: shr    $0x20,%r10
  0.85%    0.76%  │  0x00007f65588d82d1: mov    %r10d,%r10d
 11.81%   11.51%  │  0x00007f65588d82d4: and    $0x1,%r10d
  2.16%    1.78%  │  0x00007f65588d82d8: cmp    $0x1,%r10d
  3.45%    3.00%  │  0x00007f65588d82dc: cmovne %r9d,%edx         <----- HERE IT IS
 17.55%   15.86%  │  0x00007f65588d82e0: inc    %r11d              ;*iinc
                  │                                                ; - org.openjdk.LoopInc::indirectInc@56 (line 33)
                  │  0x00007f65588d82e3: cmp    $0x3e8,%r11d
                  ╰  0x00007f65588d82ea: jl     0x00007f65588d8260  ;*if_icmpge
                                                           ; - org.openjdk.LoopInc::indirectInc@8 (line 33)