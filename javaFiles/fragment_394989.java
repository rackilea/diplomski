function(INSTALL_JAR _TARGET_NAME _DESTINATION)
    get_property(__FILES
        TARGET ${_TARGET_NAME}
        PROPERTY INSTALL_FILES
    )

    if (__FILES)
        install(FILES ${__FILES}
                DESTINATION ${_DESTINATION}
        )
    else (__FILES)
        message(SEND_ERROR "The target ${_TARGET_NAME} is not known in this scope.")
    endif (__FILES)
endfunction(INSTALL_JAR _TARGET_NAME _DESTINATION)