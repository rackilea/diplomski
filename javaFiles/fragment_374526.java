HashMap<String, Integer> temp = null; // <-- why create one?
List<Integer> toRemove = new ArrayList<>();

for(int iter : keys) {
    temp = holder.get(iter); 
    if (temp == null || temp.size() == 0) {
          toRemove.add(iter);
    }
}
keys.removeAll(toRemove);