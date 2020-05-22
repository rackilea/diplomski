#!/bin/bash

# Total memory in KB
totalMemKB=$(awk '/MemTotal:/ { print $2 }' /proc/meminfo)

# Percentage of memory to use for Java heap
usagePercent=95

# heap size in KB
let heapKB=$totalMemKB*$usagePercent/100

# heap size in MB
let heapMB=$heapKB/1024

module add apps/java/1.6 
java -Xmx${heapMB}m HelloWorld