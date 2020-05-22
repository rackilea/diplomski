if (a.v1 < b.v1) return -1;
else if (a.v1 > b.v1) return 1;
else
  if (a.v2 < b.v2) return -1;
  else if (a.v2 > b.v2) return 1;
  else
    if (a.v3 < b.v3) return -1;
    else if (a.v3 > b.v3) return 1;
    else
      return 0;