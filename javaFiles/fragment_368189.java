IMethodBinding binding = inv.resolveMethodBinding();
if (binding.getModifiers() & Modifier.STATIC > 0) {
  // method is static method
} else {
  // method is not static
}