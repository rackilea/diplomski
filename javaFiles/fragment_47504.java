private TransformationSet[] readDescriptors(String[] descriptors)
        throws MojoExecutionException {

    List descriptorSets = new ArrayList();
    // add all the existing transformationSets
    if (transformationSets != null && transformationSets.length != 0) {
        descriptorSets.addAll(Arrays.asList(transformationSets));
    }

    for (int i = 0; i < descriptors.length; i++) {
        getLog().info(
                "Reading transformation descriptor: " + descriptors[i]);

        Location location = getLocation(descriptors[i]);

        Reader reader = null;
        try {
            reader = new InputStreamReader(location.getInputStream(),
                    "UTF-8");

            Xpp3Dom dom = Xpp3DomBuilder.build(reader);

            descriptorSets.addAll(parseTransformationSets(dom));
        } catch (IOException e) {
            throw new MojoExecutionException(
                    "Error reading transformation descriptor: "
                            + descriptors[i], e);
        } catch (XmlPullParserException e) {
            throw new MojoExecutionException(
                    "Error parsing transformation descriptor: "
                            + descriptors[i], e);
        } finally {
            IOUtil.close(reader);
        }
    }

    return (TransformationSet[]) descriptorSets
            .toArray(new TransformationSet[descriptorSets.size()]);
}

/**
 * Create transformationSets from the Xpp3Dom.
 * TODO use plexus utilities to resolve these elegantly?
 */
private List parseTransformationSets(Xpp3Dom dom) {
    // TODO validation of the input files!
    Xpp3Dom[] setDoms = dom.getChildren("transformationSet");

    List sets = new ArrayList();
    for (int i = 0; i < setDoms.length; i++) {
        TransformationSet set = new TransformationSet();
        set.setDir(new File(setDoms[i].getChild("dir").getValue()));
        set.setStylesheet(new File(setDoms[i].getChild("stylesheet")
                .getValue()));

        Xpp3Dom outDom = setDoms[i].getChild("outputDir");

        if (outDom != null) {
            set.setOutputDir(new File(outDom.getValue()));
        }

        sets.add(set);
    }
    return sets;
}