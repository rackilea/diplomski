# true | true; echo "${PIPESTATUS[@]}"
0 0
# false | true; echo "${PIPESTATUS[@]}"
1 0
# false | true; echo "${PIPESTATUS[0]}"
1
# true | false; echo "${PIPESTATUS[@]}"
0 1