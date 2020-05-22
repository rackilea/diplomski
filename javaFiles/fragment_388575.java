middle () {
  s=$1
  echo "< $s"
  len=${#s}
  if (( $len > 2 ))
  then
      middle ${s:1:((len-2))}
  fi
  echo "$s >"
}

middle "foobar"

< foobar
< ooba
< ob
ob >
ob >
ob >