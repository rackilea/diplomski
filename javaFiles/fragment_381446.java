if type -p java; then
    echo found java executable in PATH
   _java=java
fi
if [[ "$_java" ]]; then
    version=$("$_java" -version 2>&1 | awk -F '"' '/version/ {print $2}')
    echo version "$version"
    if [[ "$version" > "YOUR_SUPPORTED_JAVA_VERSION" ]]; then
       echo SUPPORTED_VERSION
    else
       echo NOT_SUPPORTED_VERSION
    fi
fi