ArrayList<Integer> years = new ArrayList<Integer>()
{
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size() - 1; i++) {
            sb.append(get(i));
            sb.append(", ");
        }
        sb.append(get(size() - 1));
        return sb.toString();
    }
};