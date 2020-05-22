static int contaNosPrivado(Arvbin r) {
    if (r == null)
        return 1;
    else
        return contaNosPrivado(r.esc) + contaNosPrivado(r.dir);
}