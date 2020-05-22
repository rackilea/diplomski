#!/bin/bash
SOURCE="${BASH_SOURCE[0]}"
while [ -h "$SOURCE" ]; do
    DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
    SOURCE="$(readlink "$SOURCE")"
    [[ $SOURCE != /* ]] && SOURCE="$DIR/$SOURCE"
done
DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"

cd "$DIR"
cd ..

echo "$(pwd)"

for file in *
do
    if [ -f "$file" ]
    then
        if [[ "$file" =~ .*.jar ]]
        then
            java -jar "$file"
        fi
    fi
done