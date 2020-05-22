for (int i =0; i<this.degree; i++)
 {
     this.evaluation= Math.pow(value,i) *this.coefficient[i];
     this.evaluation+= evaluation;

 }

 return evaluation;