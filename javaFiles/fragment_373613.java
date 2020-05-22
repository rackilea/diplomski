StringRazmatazer extends Razmatazer{

  Interface RazmatazStringAsync extends RazmatazAsync<String>{}
  Interface RazmatazString extends Razmataz<String>{}

  razmatazAsyncRPC = GWT.create(RazmatazString.class);
}