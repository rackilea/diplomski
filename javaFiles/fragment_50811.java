ls -R /path/to/source1 | grep '.java\|.js\|.css' | grep -v ':$' >allfiles.txt
ls -R /path/to/source2 | grep '.java\|.js\|.css' | grep -v ':$' >>allfiles.txt
cat allfiles.txt | sort | uniq -d > same_files.txt
cat allfiles.txt | sort | uniq -u > different_files.txt

# This will compare the same files one-by-one
for i in `cat same_files.txt`; do 
    FILE1=`find /path/to/source1 -name $i`; 
    FILE2=`find /path/to/source2 -name $i`;
    diff -q $FILE1 $FILE2 
done