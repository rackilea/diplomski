0 iconst_0 // Push constant 0 (TOMAYTO)
   1 istore_0 // Pop into local var 0: int say = TOMAYTO;
   2 iload_0 // Push key for switch from local var 0
                          // Perform switch statement: switch (say) {...
                          // Low case value is 0, high case value is 1
                          // Default branch offset will goto 2
   3 tableswitch 0 to 1: default=2
            0: 24 // case 0 (TOMAYTO): goto 24
            1: 29 // case 1 (TOMAHTO): goto 29

                          // Note that the next instruction starts at address 24,
                          // which means that the tableswitch took up 21 bytes
  24 iconst_1 // Push constant 1 (TOMAHTO)
  25 istore_0 // Pop into local var 0: say = TOMAHTO
  26 goto 2 // Branch unconditionally to 2, top of while loop
  29 iconst_0 // Push constant 1 (TOMAYTO)
  30 istore_0 // Pop into local var 0: say = TOMAYTO
  31 goto 2 // Branch unconditionally to 2, top of while loop