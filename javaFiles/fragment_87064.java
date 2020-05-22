#!/bin/bash

QVIM_FILENAME="$(mktemp /tmp/qvim-XXXXXXXXXX)";

if [[ "$QVIM_VERBOSE" == '1' ]]; then
    vim - "${@/#/-c}" -c "wq! $QVIM_FILENAME";
else
    vim - "${@/#/-c}" -c "wq! $QVIM_FILENAME" >/dev/null 2>&1;
fi;
rc=$?;

if [[ -e "$QVIM_FILENAME" ]]; then
    cat -- "$QVIM_FILENAME";
    rm -f -- "$QVIM_FILENAME";
fi;

exit $rc;