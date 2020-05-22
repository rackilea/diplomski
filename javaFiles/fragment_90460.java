unset prev
for i in part.*
do if [ -n "${prev}" ]
  then 
    tail -c 1000 ${prev} > part.temp
    cat ${i} >> part.temp
    mv part.temp ${i}
  fi
  prev=${i}
done