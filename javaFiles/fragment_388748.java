#! /bin/bash -eu

edit=
tempfile=

if [ "${EXAMPLE_EDITOR:+set}" = set ]
then
    edit="${EXAMPLE_EDITOR}"
elif [ "${EDITOR:+set}" = set ]
then
    edit="${EDITOR}"
else
    edit='vi'
fi

function cleanup {
    [ -z "${tempfile}" ] || rm -f "${tempfile}"
}

trap cleanup EXIT

tempfile="$(mktemp)"

cat <<EOF > "${tempfile}"
# Please edit this file to contain your list of noble wishes, then
# save and exit the editor.  If you decide to abort the process,
# delete everything and save an empty file.
EOF

${edit} "${tempfile}" || {
    echo "Editing command '${edit} ${tempfile}' is not working or" \
         "was aborted on purpose" >&2
    exit 1
}

if [ ! -s "${tempfile}" ]
then
    echo "Aborting due to empty wish list" >&2
    exit 1
fi

# Do something with the list of noble wishes...