JAXBContext jaxbContext = JAXBContext.newInstance(UserAgent.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
// pase file, url , inputstream , string whatever you have.
                UserAgent userAgent = (UserAgent) jaxbUnmarshaller.unmarshal(file);
                //getting <template> data from last <support> tag
                List<Template> templates = userAgent.getSupport().get(3).getTemplate();
                for (Template template : templates) {
                    String wantToSeeTempalteData = String.format(
                            "Tempalt [name:%s , default:%s content:%s ]",
                            new Object[] { template.getName(),template.getDefault(), template.getContent() });
                    System.out.println(wantToSeeTempalteData);
                }