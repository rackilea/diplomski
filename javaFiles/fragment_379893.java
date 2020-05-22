Class c1 = certification.getClass().getSuperclass().getClassLoader();
while (c1 != null) {
    System.out.println(c1.getClass().getCanonicalName() + " " + c1.hashCode() + " " + c1);
    c1 = c1.getParent();
}

Class c2 = Certification.class.getClassLoader();
while (c2 != null) {
    System.out.println(c2.getClass().getCanonicalName() + " " + c2.hashCode() + " " + c2);
    c2 = c2.getParent();
}