@Override
public String toString() {
    double total = 0;
    StringBuilder sb = new StringBuilder();
    for (Product p : cart) {
        sb.append(p.toString()).append("\n");
        total += p.getTotalPrice();
    }
    sb.append(String.format("%s%33.2f", "Total :", total));
    return sb.toString();
}