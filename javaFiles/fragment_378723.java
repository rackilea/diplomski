boolean noiseIsAdded = Math.random() > 0.5; //50% prob add, 50% prob subtract
double noise = Math.random() * actualDelta; //scales down the 0-1 range to 0-actualDelta

double newProbability;
if (noiseIsAdded) newProbability = myProbability + noise;
else newProbability = myProbability - noise;