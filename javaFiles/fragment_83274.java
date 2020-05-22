Map<String,Object> productimages = new HashMap<String, Object>();
            List<String> datas = new ArrayList<String>();
            datas.add("image");
            datas.add("small_image");
            datas.add("thumbnail");

productimages.put("file_mime_type", mime);
productimages.put("file_content", encodedImage);
productimages.put("file_name", pictureName);

productimages.put("types", datas);