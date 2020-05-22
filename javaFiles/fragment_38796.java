@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Gilda gilda = (Gilda) o;
    if (nome != null ? !nome.equals(gilda.nome) : gilda.nome != null) return false;

    return true;
}