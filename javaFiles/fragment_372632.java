if (response.isSuccessful()) {
            Data data = response.body();
            StringBuilder attrs = new StringBuilder();
            for (Movie Movie : data.getData()) {
                Attributes attributes = movie.getAttributes();
                Log.i("INFO", attributes.getName());
                attrs.append(attributes.getName() + ", ");
            }
             textGeners.setText(attrs.toString());
        }