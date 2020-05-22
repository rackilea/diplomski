#!/bin/bash
#
# Hook simply validates whether the corporate pom is used 
# and rejects the commit when the corporate pom is absent

 echo "### Validate commit against Company rules... ####"

 corppom_artefactId='corporate-pom'

 oldrev=$1
 newrev=$2
 refname=$3

 while read oldrev newrev refname; do

    pom=`git ls-tree --full-name -r ${newrev} | grep pom.xml |  awk '{ print $3 }'`

   # Project seems not to be a maven project. So it's okay that the corporate pom is missing
    if [ -z ${pom} ];
    then
        continue;
    else
        git cat-file blob ${pom} | grep $corppom_artefactId >> /dev/null
        if [[ $? -ne 0 ]];
        then
            echo "### NO CORPORATE POM... Bye Bye ###"
            # Rejecting commit
            exit 1;
        else
            echo "### CORPORATE POM IS USED. GREAT! ###"
        fi
    fi
done