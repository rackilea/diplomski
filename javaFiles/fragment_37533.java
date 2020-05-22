app=github(?=(?:[^"]|"[^"]*")*\s+user=(?<user>\S+))?(?=(?:[^"]|"[^"]*")*\s+repo=(?<repo>\S+))?
BnM. Boyer-Moore (BMP only version) (length=10)
  app=github
Ques. Greedy optional quantifier
  Pos. Positive look-ahead
    GroupHead. local=0
    Prolog. Loop wrapper
    Loop [1889ca51]. Greedy quantifier {0,2147483647}
      GroupHead. local=1
      Branch. Alternation (in printed order):
        CharProperty.complement. S̄:
          BitClass. Match any of these 1 character(s):
            "
        ---
        Single. Match code point: U+0022 QUOTATION MARK
        Curly. Greedy quantifier {0,2147483647}
          CharProperty.complement. S̄:
            BitClass. Match any of these 1 character(s):
              "
          Node. Accept match
        Single. Match code point: U+0022 QUOTATION MARK
        ---
      BranchConn [7e41986c]. Connect branches to sequel.
      GroupTail [47e1b36]. local=1, group=0. --[next]--> Loop [1889ca51]
    Curly. Greedy quantifier {1,2147483647}
      Ctype. POSIX (US-ASCII): SPACE
      Node. Accept match
    Slice. Match the following sequence (BMP only version) (length=5)
      user=
    GroupHead. local=3
    Curly. Greedy quantifier {1,2147483647}
      CharProperty.complement. S̄:
        Ctype. POSIX (US-ASCII): SPACE
      Node. Accept match
    GroupTail [732c7887]. local=3, group=2. --[next]--> GroupTail [6c9d2223]
    GroupTail [6c9d2223]. local=0, group=0. --[next]--> Node [4ea5d7f2]
    Node. Accept match
  Node. Accept match
Ques. Greedy optional quantifier
  Pos. Positive look-ahead
    GroupHead. local=4
    Prolog. Loop wrapper
    Loop [402c5f8a]. Greedy quantifier {0,2147483647}
      GroupHead. local=5
      Branch. Alternation (in printed order):
        CharProperty.complement. S̄:
          BitClass. Match any of these 1 character(s):
            "
        ---
        Single. Match code point: U+0022 QUOTATION MARK
        Curly. Greedy quantifier {0,2147483647}
          CharProperty.complement. S̄:
            BitClass. Match any of these 1 character(s):
              "
          Node. Accept match
        Single. Match code point: U+0022 QUOTATION MARK
        ---
      BranchConn [21347df0]. Connect branches to sequel.
      GroupTail [7d382897]. local=5, group=0. --[next]--> Loop [402c5f8a]
    Curly. Greedy quantifier {1,2147483647}
      Ctype. POSIX (US-ASCII): SPACE
      Node. Accept match
    Slice. Match the following sequence (BMP only version) (length=5)
      repo=
    GroupHead. local=7
    Curly. Greedy quantifier {1,2147483647}
      CharProperty.complement. S̄:
        Ctype. POSIX (US-ASCII): SPACE
      Node. Accept match
    GroupTail [71f111ba]. local=7, group=4. --[next]--> GroupTail [9c304c7]
    GroupTail [9c304c7]. local=4, group=0. --[next]--> Node [4ea5d7f2]
    Node. Accept match
  Node. Accept match
LastNode.
Node. Accept match