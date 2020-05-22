public Polinom(List<Integer> koeficienti)
{
    // Generally not best practice to just remember the list passed in; instead,
    // make a *defensive copy* of it so this instance doesn't share the list with
    // the caller. (Or accept an immutable list.)
    this.koeficienti = new ArrayList<Integer>(koeficienti);
}