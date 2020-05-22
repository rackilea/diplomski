public void print() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < Hash.length; i++) {
        sb.append(i).append(" : ");

        MapEntry<K, V> temp = Hash[i];
        while (temp != null) {
            sb.append(temp.key).append(" -> ").append(temp.value).append(" , ");
            temp = temp.next;
        }

        sb.append("\n");
    }
    System.out.println(sb.toString());
}