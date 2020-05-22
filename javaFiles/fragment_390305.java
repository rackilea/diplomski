seq=16
count=0
for i in $(seq 4040 $END); 
do
if lsof -Pi :$i -sTCP:LISTEN -t >/dev/null ; then
    count=`expr $count + 1`
else
    echo "not running"
fi;
done
if count == 0 <spark-submit>