InetAddress ip = null;
@RequestMapping("/getAllFiles")
    public ResponseEntity<List<String>> getAllFiles(@RequestParam String panelName) {

        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<String> fileNamesList = panelFileListMap.get(panelName);
        if (fileNamesList != null) {
            List<String> allFiles = fileNamesList.stream()
                    .map(fileName -> MvcUriComponentsBuilder
                            .fromMethodName(ContentResource.class, "getFile", fileName, panelName)
                            .host(ip.getHostAddress()).build().toString())
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(allFiles);
        } else {
            throw new RuntimeException("No images are uploaded in category = " + panelName);
        }
    }