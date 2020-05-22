case R.id.btLogin:
    try {
        doGetRequest("http://myurl/api/");
    } catch (IOException e) {
        e.printStackTrace();
    }
    break;