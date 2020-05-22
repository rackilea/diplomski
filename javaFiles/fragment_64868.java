@RequestMapping("/")
    public String index(Model model) {
        String headshotsfileNameStrings = "";
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource[] resources;
        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources("classpath:" + "/static/images/xyz-headshots/*.jpg"); //get all files in the directory
            for (int i = 0; i < resources.length; i++) {
                String fileName = resources[i].getFilename(); //fileName gets populated now.
                headshotsfileNameStrings += fileName + ",";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("headshotsfileNameStrings", headshotsfileNameStrings);
        return "index";
    }