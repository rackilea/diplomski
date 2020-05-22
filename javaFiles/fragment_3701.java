function fibonacci(n) {
  var BigInteger = Java.type("java.math.BigInteger");
  prev = new BigInteger("0");
  if (n == 0) return prev;

  next = new BigInteger("1");
  if (n == 1) return next;

  var i, fib = null;
  for (i = 1; i < n; i++) {
    fib = prev.add(next);
    prev = next;
    next = fib;
  }
  return fib;
}

function javaToString(obj) {
    var javaToStringMethod = (new java.lang.Object()).toString;
    var call = Function.prototype.call;
    return call.call(javaToStringMethod, obj);
}

print(javaToString(fibonacci(77)))
print(javaToString(fibonacci(78)))
print(javaToString(fibonacci(79)))

var str, BigInteger = Java.type("java.math.BigInteger");
str = "9999999999999998";
print(str + ": " + javaToString(new BigInteger(str)));
str = "9999999999999999";
print(str + ": " + javaToString(new BigInteger(str)));