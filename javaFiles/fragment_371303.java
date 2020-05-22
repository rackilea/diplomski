add_custom_target(
    JavaProject ALL
    DEPENDS "${PROJECT_TARGET_DIR}/${PROJECT_JAR}"
)
# Add a JAR_FILE property to the JavaProject for create_javah
set_property(
    TARGET JavaProject 
    PROPERTY JAR_FILE "${PROJECT_TARGET_DIR}/${PROJECT_JAR}"
)