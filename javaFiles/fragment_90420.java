data = Import["http://unicode.org/Public/UNIDATA/NamesList.txt", "Lines"];

codes = Cases[data, 
 b_String /; StringMatchQ[
  b, ___ ~~ "LATIN " ~~ "CAPITAL" | "SMALL" ~~ " LETTER " ~~ 
   "A" | "E" | "I" | "O" | "U" ~~ " WITH " ~~ ___] :> 
    FromDigits[StringTake[b, 4], 16], Infinity];

FromCharacterCode[codes]