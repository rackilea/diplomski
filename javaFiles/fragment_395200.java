#!/bin/bash

GENERATED="<changeme>/application_5.2.0_generated"
OLD="<changeme>/application_5.2.0_old"
#DECOMPILER="javap -c"
DECOMPILER="java -jar <changeme>/procyon-decompiler-0.5.30.jar"

for plugin in $GENERATED/plugins/*; do
    echo "$plugin"
    base=$(basename "$plugin")
    old_plugin="$OLD/plugins/$base"

    zipcmp $plugin $old_plugin

    if [ $? -ne 0 ]; then
        mkdir -p "$GENERATED/unzip/$base" && cd "$GENERATED/unzip/$base" && jar xf $plugin
        mkdir -p "$OLD/unzip/$base" && cd "$OLD/unzip/$base" && jar xf $old_plugin

        for class in $(zipcmp $plugin $old_plugin | grep ".class" | awk '{print $4;}' | uniq); do
            diff <($DECOMPILER "$GENERATED/unzip/$base/$class") <($DECOMPILER "$OLD/unzip/$base/$class") > /tmp/output
            if [ $? -ne 0 ]; then
                echo "diff <($DECOMPILER $GENERATED/unzip/$base/$class) <($DECOMPILER $OLD/unzip/$base/$class)"
                cat /tmp/output
            fi
        done
    fi
done