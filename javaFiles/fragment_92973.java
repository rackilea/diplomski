@Override
public int compareTo(CompararListas o) {
    if (NumeroParte < o.NumeroParte)
        return -1;
    else if (NumeroParte > o.NumeroParte)
        return 1;
    return 0;
}