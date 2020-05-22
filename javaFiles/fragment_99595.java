# Allow 'Srcs' to not exist at configure-time
set_source_files_properties(${Srcs} PROPERTIES GENERATED TRUE)
add_library(MyLib ${Srcs})

# compile .class files
add_jar(MyJarTarget ...)

# generate .h headers
add_custom_command(TARGET MyLib PRE_BUILD COMMAND ...)

# Force 'add_jar' to be built before 'MyLib'
add_dependencies(MyLib MyJarTarget)