#!/bin/bash
for i in "$@"; do
  if [[ "${i}" == sun.applet.PluginMain ]]; then
    exec "$0.orig" -Xmx512m "$@"
  fi
done
exec "$0.orig" "$@"