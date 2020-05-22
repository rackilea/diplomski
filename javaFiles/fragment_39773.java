//  Load two ints using a 64-bit load.  {x, y, 0, 0}
movq        xmm2,mmword ptr arr[rcx]  

//  Shuffle the data into this form.
punpckldq   xmm2,xmm2           xmm2 = {x, x, y, y}
movdqa      xmm3,xmm2           xmm3 = {x, x, y, y}

//  Mask out index 1 and 3.
pand        xmm2,xmm0           xmm2 = {x, 0, y, 0}

//  Arithmetic right-shift to copy sign-bit across the word.
psrad       xmm3,1Fh            xmm3 = {sign(x), sign(x), sign(y), sign(y)}

//  Mask out index 0 and 2.
pand        xmm3,xmm1           xmm3 = {0, sign(x), 0, sign(y)}

//  Combine to get sign-extended values.
por         xmm3,xmm2           xmm3 = {x, sign(x), y, sign(y)}
                                xmm3 = {x, y}

//  Add to accumulator...
paddq       xmm6,xmm3