List<Integer> pos = new ArrayList<>();

int len = 0;
for(int i = 0 ; i < arr.length ; i++)
    if(s == null)
        len++;
    else
        len = 0;

    if(len >= min_len)
        pos.add(i - min_len + 1);

return pos.get(new Random().nextInt(pos.size()));