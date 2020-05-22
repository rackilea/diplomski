default:
        if (arg0.getId() < titulo.lenth) {
            final Toast toastMensaje = getToast(arg0.getId());
            toastMensaje.setGravity(Gravity.CENTER, 0, 0);
            toastMensaje.show();
        } else {
            //not a valid value
        }
        break;
}

private Toast getToast(int i) {
    return Toast.makeText(getApplicationContext(), titulo[i], Toast.LENGTH_LONG);
}