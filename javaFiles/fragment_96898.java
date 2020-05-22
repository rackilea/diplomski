JFrame a = new JFrame("A");

JFrame b = new JFrame("B");

a = b = new JFrame("C");

System.out.println(a.getTitle() + " - " + b.getTitle());

a.setTitle("D");

System.out.println(a.getTitle() + " - " + b.getTitle());