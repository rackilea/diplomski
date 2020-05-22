SyncOnSubscribe.createSingleState(() => {
    try {
        InputStream in = getClass().getResourceAsStream("/trial.txt");
        return new BufferedReader(new InputStreamReader(in));
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
},
(s, o) -> {
    try {
        String line = s.readLine();
        if (line == null) {
            o.onCompleted();
        } else {
            o.onNext(line);
        }
    } catch (IOException ex) {
        s.onError(ex);
    }
},
s -> {
    try {
       s.close();
    } catch (IOException ex) {
    }
});