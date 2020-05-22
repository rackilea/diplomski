_comp_java () {
    prev=${COMP_WORDS[$COMP_CWORD - 1]}

    case $prev in
        "-jar")
            COMPREPLY=($(compgen -A file -- ${COMP_WORDS[$COMP_CWORD]}))
            ;;
        *)
            fields=($(echo ${COMP_WORDS[$COMP_CWORD]} | tr "." "\n"));
            [ "${COMP_WORDS[$COMP_CWORD]: -1}" == "." ] && lastIdx=0 || lastIdx=1
            [ ${#COMP_WORDS[$COMP_CWORD]} -eq 0 ] || [ ${lastIdx} -eq 0 ] && lastWord='' || lastWord=${fields[${#fields[@]}-1]}
            [ ${#COMP_WORDS[$COMP_CWORD]} -eq 0 ] && fields=() || fields=($(echo ${fields[*]:0:${#fields[@]}-$lastIdx}))
            [ ${lastIdx} -eq 0 ] && prefix=${COMP_WORDS[$COMP_CWORD]} || prefix=$(tr ' ' '.' <<< $(echo "${fields[@]}."))
            [ "${prefix:0}" == "." ] && prefix=""

            COMPREPLY=( $(compgen -W "$(ls $(tr ' ' '/' <<< $(echo ${fields[@]})))" -- $lastWord ))
            COMPREPLY=(${COMPREPLY[@]/#/$prefix})
            COMPREPLY=(${COMPREPLY[@]/%/.})
            COMPREPLY=(${COMPREPLY[@]/.class./})
            COMPREPLY=(${COMPREPLY[@]/.java./})
            ;;
    esac
    return 0
}

complete -o nospace -o filenames -F _comp_java java