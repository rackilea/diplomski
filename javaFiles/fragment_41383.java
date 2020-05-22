for(Iterator<MyElement> it = list.iterator(); it.hasNext(); ) {
    MyElement element = it.next();
    if (some condition) {
      it.remove();
    }
}