// fourth trial
final Object tmpArray = Array.newInstance(f.getType().getComponentType(), srcArray.length);
for (int i = 0; i < srcArray.length; i++) {
  Array.set(tmpArray, i, srcArray[i]);
}

f.set(o, tmpArray);