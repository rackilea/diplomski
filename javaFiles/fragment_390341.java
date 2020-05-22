Random r = new Random();

int generated = r.nextInt(299); // generate 0..299
if(generated >= 124) {
    generated++; // skip 124
}
// now you can send the number