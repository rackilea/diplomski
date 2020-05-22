String.metaClass.trim = {
 //you could have your own trim implementation here for String class
 return "Hi"
}
x = "ok".trim()
println x