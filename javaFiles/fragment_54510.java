switch (Gdx.app.getType()) {
    case ApplicationType.Android:
        // android specific code
        break;
    case ApplicationType.Desktop:
        // desktop specific code
        break;
    case ApplicationType.WebGl:
        // HTML5 specific code
        break;
    case ApplicationType.iOS:
        //iOS specific code
        break;
     case ApplicationType.HeadlessDesktop:
        //Headless desktop specific code
        break;
     case ApplicationType.Applet:
        //Applet specific code
        break;
    default:
        // Other platforms specific code
}