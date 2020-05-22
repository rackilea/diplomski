long ops = 0;

for(String filename : files) {
    // ...
    while ((line = input.readLine()) != null) {
        // insert some stuff...

        ops ++;

        if(ops % 1000 == 0) {
            c.commit();
        }
    }
}

c.commit();