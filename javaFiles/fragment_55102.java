while(fin.hasNext())  // CHECK IF WE HAVE ONE MORE TOKEN
{  
 first_ = fin.nextLine();      // FETCH THREE
 last_ = fin.nextLine();
 publisher_ = fin.nextLine();
 Author temp = new Author(first_, last_, publisher_);
 array[x] = temp;
 x++;
}