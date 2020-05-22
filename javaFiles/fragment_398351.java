val pattern = """\\x([0-9A-F]{2})""".r

pattern.replaceAllIn(x, m => m.group(1) match {
  case "5C" => """\\""" //special case for backslash
  case hex => Integer.parseInt(hex, 16).toChar.toString
})