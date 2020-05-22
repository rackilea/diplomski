FileOutputStream fout = new FileOutputStream("dev.txt");
ObjectOutputStream out = new ObjectOutputStream(fout);

p1.writeExternal(out);
p2.writeExternal(out);

out.flush();        
out.close(); <-----