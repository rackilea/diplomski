args=( "$@" )
javaProps=( )
mainclass=com.xx
server_jvmargs=( -Djava.awt.headless=true -Xms1024m -Xmx1024m "${jvmargs[@]}" )
XX_HOME="$PWD/../.."
client_classpath="$XX_HOME/lib/client/patch.jar:$XX_HOME/lib/client/xyx-xxx.jar:$clientlibs:$XX_HOME/lib/server/standard-1.1.2.jar:$publictilesource:$respath:$XX_HOME/lib/client/xxmainclass.jar"

java \
  "${server_jvmargs[@]}" \
  "${javaProps[@]}" \
  -Dxx.home="$XX_HOME" \
  -Duser.dir="$XX_HOME" \
  -cp "$client_classpath" \
  "$mainclass" "${args[@]}"