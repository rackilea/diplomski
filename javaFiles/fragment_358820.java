List<String> fileNames = new ArrayList<>();
 for (Part part : request.getParts()) {
            String fileName =extractFileName(part);

            // refines the fileName in case it is an absolute path

            if (fileName != null && !"".equals(fileName)) {

                fileName = new File(fileName).getName();
                part.write(savePath + File.separator +""+daformat+""+fileName);
                fileNAmes.add(fileName);
            }
        }
        request.setAttribute("message", "Upload has been done successfully!");

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String featured = request.getParameter("featured");
        String image = request.getParameter("image");

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setCategory(category);
        p.setFeatured(featured);
        p.setImage(StringUtils.join(fileNames , ','));