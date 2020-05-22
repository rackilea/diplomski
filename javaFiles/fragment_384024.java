./gradlew runSuite1 -i --rerun-tasks &
pids[0]=$!

./gradlew runSuite2 -i --rerun-tasks &
pids[1]=$!

for pid in ${pids[*]}; do
    wait $pid
done