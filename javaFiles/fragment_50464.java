/Oldsetpagedevice /setpagedevice load def

/setpagedevice {
  dup /PageSize known {
    dup /PageSize get
    dup 0 get 20 string cvs exch 1 get 20 string cvs exch
    (Requested Media Size is ) print print (points by ) print print (points\n) print
  } if
  Oldsetpagedevice
} bind def