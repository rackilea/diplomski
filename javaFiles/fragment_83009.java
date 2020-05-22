public static List<String> reconstructDockerfile(DockerClient cl, String imageIdOrTag) throws Exception {
    Image img = null;
    Map<String, Image> idToImage = new HashMap<String, Image>();
    for (Image image: cl.listImagesCmd().withShowAll(true).exec()) {
        idToImage.put(image.getId(), image);
        if (image.getId().equals(imageIdOrTag))
            img = image;
        if (image.getRepoTags() != null)
            for (String imageTag : image.getRepoTags())
                if (imageTag.equals(imageIdOrTag))
                    img = image;
    }
    if (img == null)
        throw new IllegalArgumentException("Image id or tag wasn't found: " + imageIdOrTag);
    List<String> cmds = new ArrayList<String>();
    String fromTag = null;
    while (true) {
        InspectImageResponse iir = cl.inspectImageCmd(img.getId()).exec();
        String[] cmd = iir.getContainerConfig().getCmd();
        String cmdLine;
        if (cmd.length == 3 && cmd[0].equals("/bin/sh") && cmd[1].equals("-c")) {
            cmdLine = cmd[2];
            if (cmdLine.startsWith("#(nop) ")) {
                cmdLine = cmdLine.substring(7);
            } else {
                cmdLine = "RUN " + cmdLine;
            }
        } else {
            cmdLine ="Unexpected command format: " + Arrays.asList(cmd);
        }
        cmds.add(0, cmdLine + "    #### ---> " + img.getId());
        String imageId = img.getParentId();
        if (imageId == null || imageId.trim().isEmpty())
            break;
        img = idToImage.get(imageId);
        if (img.getRepoTags().length >= 1 && !img.getRepoTags()[0].equals("<none>:<none>")) {
            fromTag = img.getRepoTags()[0];
            break;
        }
    }
    if (fromTag != null)
        cmds.add(0, "FROM " + fromTag);
    return cmds;
}