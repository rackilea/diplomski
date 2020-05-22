l3.addall(l1);
for(int i=0;i<l2.size();i++){
   for(int j=0;j<l3.size();j++){
      if(l2.get(i).id!=l3.get(j).id)
          l3.add(l2.get(i);
      else{
         l3.get(j).num2=l2.get(i).num2;
      }
   }
}