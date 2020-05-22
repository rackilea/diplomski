#!/bin/bash

REPOS="$1"
TXN="$2"

CHECKSTYLEJAR=/path/to/checkstyle-5.7/checkstyle-5.7-all.jar
CHECKSTYLECONFIG=/path/to/javadoc_check.xml

SVNLOOK=/usr/bin/svnlook
JAVA=/usr/bin/java

EXITSTATUS=0
ERRORMARKER=__ERROR_MARKER__

# Create temporary dir
TMPDIR=$(mktemp -d)

# Iterate on the files commited
while read changeline;
do
    # Get the filename
    file=${changeline:4}

    # Check if it's an Updated or Added java file
    if [[ $file == *.java && ($changeline == U* || $changeline == A*) ]] ; then
        # Get the file content in a temporary file
        $SVNLOOK cat -t "$TXN" "$REPOS" "$file" > $TMPDIR/${file##*/}

        echo -e "\n=> Checking $file"
        # Check the file with checkstyle
        ( $JAVA -jar $CHECKSTYLEJAR -c $CHECKSTYLECONFIG $TMPDIR/${file##*/} 2>&1 || echo "$ERRORMARKER" 1>&2 ) | sed -e "s{$TMPDIR/{{"

        # Delete the temporary file
        rm $TMPDIR/${file##*/}
    fi
done < <($SVNLOOK changed -t "$TXN" "$REPOS") 3>&2 2>&1 1>&3 | grep "$ERRORMARKER" && EXITSTATUS=1 # Check for errors

# Delete temporary dir
rmdir $TMPDIR

exit $EXITSTATUS