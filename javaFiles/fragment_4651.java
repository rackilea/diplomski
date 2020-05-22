while (al<a.length && bl<b.length)
{ //<-- bracket here

    if (a[al]<b[bl])
      c[cl++]=a[al++];


     else  
     c[cl++]=b[bl++];


    while (al<a.length)
      c[cl++]=a[al++];

    while (bl<b.length)
     c[cl++]=b[bl++];
} //<--- Bracket here