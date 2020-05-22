switch(getString("type")){

    case "chat":
        System.out.println("User said" + getString("message"));
        break;

    case "xfer":
        File f = new File(getString("fileName"));
        f.write(getString("data"));
        break;

    ...
}