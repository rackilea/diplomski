for i in {1..11}
do
    if [ $i -ne 6 ] # skip server six
    then
        cat myJar.jar |ssh user@l040101-ws$i.XXXX.XX.XX \
            "cd someFolder; cat > myJar.jar; java -jar myJar.jar" &
    fi
done