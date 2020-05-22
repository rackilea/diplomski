System.out.println(adapter);

  I got value like below ....

    "{name=SanDeigo}"


  based on that....


    Intent intent = new Intent(PredefinedLocation.this, MainActivity.class);
            int length = "{name=".length();
            String str = adapter.getItem(position).toString();
            if (str != null)
                if (str.length() > 0)
                    str = str.substring(length, str.length() - 1);

            for (int i = 0; i < places.length; i++) {
                if (places[i].equals(str)) {
                    intent.putExtra("nearLocation", places[i]);
                    //System.out.println("Near Location = " + places[i]);
                    intent.putExtra("latitude", lat[i]);
                    //System.out.println("LATITUDE = " + lat[i]);
                    intent.putExtra("longitude", lon[i]);
                    //System.out.println("LONGITUDE = " + lon[i]);
                    intent.putExtra("zipcode", zipCode[i]);
                    //System.out.println("ZIP CODE = " + zipCode[i]);
                    PredefinedLocation.this.startActivity(intent);
                    break;
                }
            }