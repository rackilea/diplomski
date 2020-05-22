if(a.substring(i+1).contains(a.substring(i,i+1)))
        {
            ans[j++]=i;                           //storing new positions in ans array
            ans[k--]=a.substring(i+1).indexOf(a.charAt(i))+1+i;
            a=a.substring(0,i+1)+a.substring(i+1).replaceFirst(a.substring(i,i+1),"*");                 //replacing the shifted char with *
        }