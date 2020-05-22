if (mySpecialCase) {
    Writer writer = response.getWriter();
    writer.write("my custom response");
    return null;
} else {
     return myObject;
}