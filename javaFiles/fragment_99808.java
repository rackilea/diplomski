Map<String, List<Attraction>> ATTRACTIONS = new HashMap<>();
List<Attraction> al = new ArrayList<>();
al.add(new Attraction("Sydney Opera House",
    "Lorem ipsum ...",
    "Lorem ipsum ...",
    Uri.parse(
        "https://lh5.googleusercontent.com/-7fb5ybQhUbo/VGLWjIL4RmI/AAAAAAAAACM/2jLe_msj_tk/w600-no/IMG_0049.JPG"),
    Uri.parse(
        "https://lh3.googleusercontent.com/-EFEw6s7mT6I/VGLkCH4Xt4I/AAAAAAAAADY/ZlznhaQvb8E/w600-no/DSC_2775.JPG"),
    new LatLng(-33.858667, 151.214028), "Sydney"));
ATTRACTIONS.put("Sydney", al);