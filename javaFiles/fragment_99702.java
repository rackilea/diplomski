#!/bin/sh

#Specify your Java class here (must contain a main method)
JAVA_CMD="java MyApp"

#JAR variant (a more common approach)
#JAVA_CMD="java -jar myjar.jar"

#Map script arguments to java app arguments. Use flag specific variables, if it's more convinient for you.
while getopts "f:o:s" opt; do
  case $opt in
    f)
      JAVA_CMD="$JAVA_CMD -f $OPTARG"
      ;;
    o)
      JAVA_CMD="$JAVA_CMD -o $OPTARG"
      ;;
    s)
      JAVA_CMD="$JAVA_CMD -s"
      ;;
    *)
      echo "Invalid usage..." >&2
      exit 1;
      ;;
  esac
done

#Additional validation (required options etc.)
#...

echo "Launching Java: $JAVA_CMD"
$JAVA_CMD