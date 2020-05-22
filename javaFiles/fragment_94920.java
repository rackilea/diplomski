public static int[] mergeArrays(int[] a, int[] b)
        {
            int a_size = a.length;
            int b_size = b.length;
            int[] c = new int[a_size + b_size];
            int i = 0 , j = 0, x = -1;
            for(; i < a_size && j < b_size;)
            {
                if(a[i] <= b[j])
                {
                    c[++x] = a[i];
                    ++i;
                    }
                else          
                {
                    if(c[x] != b[j])
                    {
                        c[++x] = b[j]; // avoid duplicates
                    }
                    ++j;
                    }
                    }
                    --i; --j;
                    while(++i < a_size)
                    {
                        c[++x] = a[i];
                    }
                    while(++j < b_size)
                    {
                        c[++x] = b[j];
                    }
                    return c;
                    }