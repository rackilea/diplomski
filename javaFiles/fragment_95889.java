int p = /* key to find */
int index = -1;
for (int i = 0; i < list.size(); ++i) {
    if (list.get(i).containsKey(p)) {
        index = i;
        break;
    }
}