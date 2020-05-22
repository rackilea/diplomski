exec "$JAVACMD" \
  $MAVEN_OPTS \
  -classpath "${M2_HOME}"/boot/plexus-classworlds-*.jar \
  "-Dclassworlds.conf=${M2_HOME}/bin/m2.conf" \
  "-Dmaven.home=${M2_HOME}" "-Dmaven.multiModuleProjectDirectory=${MAVEN_PROJECTBASEDIR}" \
  ${CLASSWORLDS_LAUNCHER} "$@"