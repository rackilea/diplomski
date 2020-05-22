if (DialogDisplayer.getDefault().yesOrNo(
    "Do you like singletons?"
)) {
    System.err.println("OK, thank you!");
} else {
    System.err.println(
        "Visit http://singletons.apidesign.org to"
        + " change your mind!"
    );
}