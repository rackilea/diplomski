public String MakeString() {
   if (data == null)
      return "Tree is empty";

   StringBuilder sb = new StringBuilder();

   MakeString(sb);

   return sb.toString();
}

private void MakeString(StringBuilder sb) {
   if (left != null)
      left.MakeString(sb);

   sb.append(data);

   if (right != null)
      right.MakeString(sb);
}