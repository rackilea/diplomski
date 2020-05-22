#!/usr/bin/env bash
case $BASH_VERSION in ''|[123].*) echo "ERROR: Bash 4.0+ needed" >&2; exit 1;; esac

declare -A pairs=( )

while IFS=$',\r' read -r var1 var2 _ ; do
    pairs[$var1]=$var2
done <"$input"

for ip1 in "${!pairs[@]}"; do
  ip2=${pairs[$ip1]}
  # Using printf %q causes nonprintable characters to be visibly shown
  printf 'Processing pair: %q and %q\n' "$ip1" "$ip2" >&2
done