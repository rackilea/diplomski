static void find(List<String> commonKey, List<String> commonTags, int index) {

    if (index >= allDest.size())
      return;

    if (commonTags.size() < min)
      return;

    if (tagsTracker.contains(commonTags.toString()) || keysTracker.contains(commonKey.toString())) {
      return;
    }

    String dest = allDest.get(index).dest;
    commonKey.add(dest);

    for (int i = index + 1; i < allDest.size(); ++i) {

      List<String> tempKeys = new ArrayList<String>(commonKey);
      List<String> tags = allDest.get(i).tags;
      Set<String> tempTagsSet1 = new HashSet<String>(commonTags);
      Set<String> tempTagsSet2 = new HashSet<String>(tags);
      tempTagsSet1.retainAll(tempTagsSet2);
      List<String> tempTags = new ArrayList<String>(tempTagsSet1);

      if (tempTags.size() >= min)
        Collections.sort(tempTags);

      find(tempKeys, tempTags, i);

      if (tempTags.size() >= min) {
        if (!tagsTracker.contains(tempTags.toString())
            && !keysTracker.contains(tempKeys.toString())) {
          tagsTracker.add(tempTags.toString());
          keysTracker.add(tempKeys.toString());

          StringBuilder sb = new StringBuilder();
          for (int j = 0; j < tempKeys.size(); ++j) {
            sb.append(tempKeys.get(j));
            if (j + 1 < tempKeys.size())
              sb.append(",");
          }
          keysAndTags.put(sb.toString(), tempTags);
        }
      }
    }

 }