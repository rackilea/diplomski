int ix = a.indexOf(a.charAt(i), i+1);
        if(ix >= 0)
        {
            ans[j++]=i;                           //storing new positions in ans array
            ans[k--]=ix;
            a=a.substring(0,i+1)+a.substring(i+1, ix) + "*" + a.substring(ix+1);
        }