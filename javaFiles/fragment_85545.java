List list = new ArrayList()

list.metaClass.count() {
    delegate.size()
}

// now call it
list.count()