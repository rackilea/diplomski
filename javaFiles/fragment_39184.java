boolean sent_join = false;
boolean joined = false;

while ((line = getInput().readLine()) != null) {
    if (!sent_join) {
        getOutput().println("JOIN #PrinZ");
        getOutput().println("JOIN #Trinorae");
        sent_join = true;
    }

    if (line.contains("JOIN :#prinz")) {
        System.out.println("JOINED #prinz = true");
        joined = true;
    }
}