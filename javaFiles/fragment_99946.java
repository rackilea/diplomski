class PeopleData implements Iterable<String[]> {

    final String[] headers;
    final List< String[] > data;

    public PeopleData(final String str) {
        String[] lines = str.split("\n");
        this.headers = lines[0].split("\\s?,\\s?");

        data = new ArrayList<String[] >();
        for ( int i=1; i<lines.length; i++ ) {
            data.add( lines[i].split("\\s?,\\s?") );
        }
    }

    public int size() {
        return headers.length;
    }

    public String[] getHeaders(int i) {
        return headers;
    }

    public String getHeader(int i) {
        return headers[i];
    }

    public String[] getRow(int i) {
        return data.get(i);
    }

    public String getData(int header, int i) {
        final String[] row = getRow(i);
        return row[header];
    }

    public String getData(String header, int i) {
        final int index = index(header);
        if ( index == -1 ) {
            throw new IndexOutOfBoundsException("header '" + header + "' not found");
        }
        return getData(index, i);
    }

    private int index(final String header) {
        for ( int i=0; i< headers.length; i++ ) {
            if ( header.equals( headers[i] ) ) return i;
        }
        return -1;
    }

    @Override
    public Iterator<String[]> iterator() {
        return data.iterator();
    }

}