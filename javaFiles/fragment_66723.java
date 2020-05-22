// `params` matches a JavaScript string
def httpPost(where: String, params: String): Try[String] = {
  // ...
}

// `params` matches a JavaScript object
def httpPost(where: String, params: java.util.Map[_, _]): Try[String] = {
  // ...
}