response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        for (Images o : IM.getAllImages()) {
            InputStream is = o.getImg();
            byte[] imageBytes = getBytes(is);
            out.write(imageBytes);
            response.setContentLength(imageBytes.length);
            response.getOutputStream().write(imageBytes);

        }
out.close();