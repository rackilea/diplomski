#!/bin/sh                                                                                                                                                                                                                                    
shopt -s extglob
shopt -s globstar
for x in **/*.jar ; do
    zip -d $x 'com/ibm/icu/impl/data/*_zh*' >/dev/null 2>&1 && echo "Removed corrupted files from $x"
done