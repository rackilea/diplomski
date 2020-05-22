char[] c = a.toCharArray();
    int n= c.length;  
    int ans[]=new int[n];  // for storing new positions after shifting
    int j=0,k=n-1,count=0;
    boolean flag=false;
    for(int i=0; i < n; i++)
    {
        char ch = c[i];
        if(ch=='*')
            continue;        //for skipping already shifted  chars
        int ix = i;
        do {
            ++ix;
        } while (ix < n && c[ix] != ch);
        if(ix < n)
        {
            ans[j++]=i;                          
            ans[k--]=ix;
            c[ix] = '*';
        }
        else
        {
            count++;        //number of unique chars which can only be 1 or 0
            if(count<=1 && n%2==1)
            {
                ans[(int)n/2]=i;
                c[i] = '*';
            }
            else
            {
                System.out.println("-1");   //if more than one unique char, palindrome not possible
                flag=true; // shows not possible
                break;
            }
        }

    }