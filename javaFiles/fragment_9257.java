public Polinom(int[] entries)
{
    this.koeficienti = new ArrayList<Integer>(entries.length);
    for (int entry : entries) {
        this.koeficienti.add(entry);
    }
}