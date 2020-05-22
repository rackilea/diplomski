run() {
    local -a java_options=(
        -Dlog4j.configurationFile=/opt/import/config/logging/log4j2_Importer.xml
        -Djava.security.egd=file:///dev/urandom
        -classpath "/opt/runner/lib/*:/opt/import/lib/*"
    )
    local app="runner.Application"
    local -a app_options=(
         --config "/opt/import/config/import.${mode}.properties"
         --workflow import
         --inputDir "/data/etl-${mode}/in"
    )

    cd /opt/import/import/current &&
    java "${java_options[@]}" $app "${app_options[@]}"
}