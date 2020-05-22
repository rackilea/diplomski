System.out.println("ITERATIONS: " + iterations);
System.out.println("LEN: " + stranica.length());
System.out.println("LAST 50 chars: "
        + stranica.substring(stranica.length() - 50, stranica
                .length()));

FileOutputStream fos = openFileOutput("tmp-and.txt",
        Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);

System.out.println(getFileStreamPath("tmp-and.txt")
        .getAbsolutePath());

fos.write(stranica.getBytes());
fos.close();