loop(n+24 to n.length-16)
{ runAbsAve1 += abs(pcm[n]) - abs(pcm[n-24]); }

loop(n+24+16 to n.length)
{ runAbsAve2 += abs(pcm[n]) - abs(pcm[n-24]); }

unusualDif= 5; //a factor. tighter values for longer measures.

if(abs(runAbsAve1-runAbsAve2)>(runAbsAve1+runAbsAve2)/(2*unusualDif))
{ /*not like noise*/ }