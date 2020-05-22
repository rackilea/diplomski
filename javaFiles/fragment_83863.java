double rand = Math.random(); // generate a random number in [0,1]
F=0;
// you test if rand is in [F(1)+..+F(i):F(1)+..+F(i)+F(i+1)] it is in this rnge with proba P(i) and therefore if it is in this range you return i
for (int i=1,i<array.size();i++ ){
   F+=F(i);
   if rand < F
       return i;
}
return array.size(); // you went through all the array then rand==1 (this probability is null) and you return n