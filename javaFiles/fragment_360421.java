BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
        ImageIOUtil.writeImage(bim, "aaa" + "-" + (page + 1) + ".png", 300);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("imagefile", new FileSystemResource("test/"+"aaa" + "-" + (page + 1) + ".png"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:5000/api/text_from_image", request, String.class);
        System.out.println(stringResponseEntity.toString());