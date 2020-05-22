public void bubbleSort(){
   int out, in;
   for(out = nElems -1;out>=1;out--){
       for(in =0; in<out; in++){
           if(a[in]>a[in+1])
               swap(in,in+1);
       }
   }
}