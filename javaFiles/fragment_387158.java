Detector detector;
List<Detector> detectors = new ArrayList<Detector>();
detectors.add(new ZipContainerDetector());
detectors.add(new POIFSContainerDetector());

detectors.add(new MultipartSignedDetector());

detectors.add(MimeTypes.getDefaultMimeTypes());
detector = new CompositeDetector(detectors);
String mimetype = detector.detect(TikaInputStream.get(new File(args[0])), new Metadata()).toString();