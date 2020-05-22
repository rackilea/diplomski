Let a = {1, 2, 1, 1, 2, 2}

i = 0; j = 5;    1 2 1 1 2 2      
                 i         j
                                  i++

i = 1; j = 5;    1 2 1 1 2 2
                   i       j      a[i] == 2 ... swap a[i] w/ a[j]; j--
                                  a[i] == 2; i--; 
                                  i++

i = 1; j = 4     1 2 1 1 2 2
                   i     j        a[i] == 2 ... swap a[i] w/ a[j]; j--
                                  a[i] == 2; i--; 
                                  i++

i = 1; j = 3     1 2 1 1 2 2      a[i] == 2 ... swap a[i] w/ a[j]; j--
                   i   j          
                                  i++  

i = 2; j = 3     1 1 1 2 2 2
                   i j
                                  i++

i = 3; j = 3     1 1 1 2 2 2
                     i
                     j