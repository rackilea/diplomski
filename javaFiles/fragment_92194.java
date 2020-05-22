%!PS-Adobe-3.0 EPSF-3.0
%%BoundingBox: 0 0 288 288

/bits [0 0 1 0  1 0 1 1  0 1 1 0  1 1 0 0] def

/width 4 def
/height 4 def
/y 0 def

72 72 scale

height {
   /x 0 def
   width {
      bits y width mul x add get 1 eq {
         newpath
         x y moveto
         0 1 rlineto
         1 0 rlineto
         0 -1 rlineto
         closepath
         fill
      } if
      /x x 1 add def
   } repeat
   /y y 1 add def
} repeat