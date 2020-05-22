#!/bin/sh

run() {
    cd /opt/import/import/current &&
    java -Dlog4j.configurationFile=/opt/import/config/logging/log4j2_Importer.xml \
         -Djava.security.egd=file:///dev/urandom \
         -classpath /opt/runner/lib/*:/opt/import/lib/* \
         runner.Application \
         --config "/opt/import/config/import.${mode}.properties" \
         --workflow import \
         --inputDir "/data/etl-${mode}/in"
}

mode=$1

case "$mode" in
    prod|simu) 
        run 
        ;;
    *)  echo "error: invalid mode" >&2
        exit 1
        ;;
esac