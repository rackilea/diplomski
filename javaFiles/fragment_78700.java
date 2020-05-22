loop(n+1 to n.length)
{ sumd0+= abs(pcm[n]); 
  sumd1+= abs(pcm[n]-pcm[n-1]); 
}

wNoiseRatio = ?0.8; //quite easily discovered, bit tricky to calculate.

if((sumd1/sumd0)<wNoiseRatio)
{ /*not like noise*/ }