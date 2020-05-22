int index = 0;
for (Annotation currAnnotation : annotation.getAnnotations())
{
    List<Map<String, String>> list = annotation.getList();
    ... list.get(index) ...
    index++;
}