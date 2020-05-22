URL website = new URL("http://cachefly.cachefly.net/100mb.test");
ReadableByteChannel rbc = Channels.newChannel(website.openStream());
FileOutputStream fos = new FileOutputStream("test.test");
long x = System.currentTimeMillis();
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
System.out.println(System.currentTimeMillis()-x);