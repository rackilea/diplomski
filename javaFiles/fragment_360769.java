#!/bin/bash
case "$1" in
hibernate|suspend)
    ACTION BEFORE SUSPEND/HIBERNATE
    ;;
thaw|resume)
    ACTION AFTER RESUME
    ;;
*)
    ;;
esac
exit $?