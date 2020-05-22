BufferedReader reader = new BufferedReader(
    new InputStreamReader(
        new FileInputStream("...input file path..."),
        "UTF-8"
    )
);
BufferedWriter writer = new BufferedWriter(
    new OutputStreamWriter(
        new FileOutputStream("...output file path..."),
        "UTF-8"
    )
);