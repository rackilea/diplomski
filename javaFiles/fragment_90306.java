for (ArrayList<Bitmap> arr : imgs) {
            arrayList = new ArrayList<Integer> ();
            for (Bitmap img : arr) {
                if (img != null) {
                    arrayList.add(img.getHeight());
                }
                else {
                    arrayList.add(null);
                }
            }
            heights.add(arrayList);
       }