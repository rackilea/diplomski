fun addCallTo(lambda: (View) -> Unit): (View) -> Unit {
  return { 
    hideKeyboard(it)
    lambda(it)
  }
}

// usage:
tvLogin.setOnClickListener(addCallTo { view -> login() })