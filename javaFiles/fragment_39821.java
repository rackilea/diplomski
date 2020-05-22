while(it2.hasNext()) {
     File f = it2.next();
     System.out.println(count=count+1);
     System.out.println(f.toString());
     Digest.update(f.toString().getBytes());
}