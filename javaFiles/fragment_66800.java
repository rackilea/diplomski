for f in src/*.java; do 
  file=`basename $f`; 
  if [[ src/$file -nt build/${file//.java/} ]]; then 
     echo src/$file; 
  fi; 
done