class Pair {
    String sBody;
    String fBody;

    public String getsBody()
    {
        return sBody;
    }

    public String getfBody()
    {
        return fBody;
    }
}

boolean check(List<Pair> list, String sBody, String fBody) {
    for (Pair pair : list) {
        if (pair.getsBody().equals(sBody) && pair.getfBody().equals(fBody)) {
            return true;
        }
    }

    return false;
}