int count = a.length;

for(int increment = 2; increment < count; increment++){
    if(a[increment]) {
      for(int i = increment*2; i < count; i += increment){
          a[i] = false;
      }          
    }
}