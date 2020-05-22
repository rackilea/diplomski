StringBuilder sb = new StringBuilder();
sb.append("aapt add -f");
sb.append(getApplicationContext().getCacheDir());
sb.append("/apk/MyProject.apk.unaligned ");
sb.append(getApplicationContext().getCacheDir());
sb.append("/tmp/classes.dex");
sb = Runtime.getRuntime().exec(sb.toString());