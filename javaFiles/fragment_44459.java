ArrayList<Item> mDATA = new ArrayList<>();

/******   add values in array list  ****/

                Intent i = new Intent(CLASS_A.this, CLASS_B.class);
                i.putParcelableArrayListExtra("ARRAY_DATA", mDATA);
                startActivity(i);