String[] command = {
    "cmd /c start",
    "cmd /k java -jar " + jar_filepath,
    tc,
    test_data,
    test_result
};

Runtime.getRuntime().exec(comand);