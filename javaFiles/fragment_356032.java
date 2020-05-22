int end = 0;
while (match.find(end)) {
    end = match.end();
    System.out.println(end);
    text=text.insert(end,"INSERT");
}