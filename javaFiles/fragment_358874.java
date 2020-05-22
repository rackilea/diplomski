public initGroupSorted() {
   // Temporary list, since we don't know the size once filtered 
   List<String> labels = new ArrayList<>();
   for (accDetails ad : in_groups) {
      if (ad._is_system) {
        groups.add(ad.group_label);
      }
   }
   in_group_sorted = labels.toArray(new String[labels.size()]);
}