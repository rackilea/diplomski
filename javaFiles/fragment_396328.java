List<String> myList = source.stream()
            .map(item -> {
                  if (!(item.get(bar) instanceof JSONObject)) {
                      return item.get(bar).toString();
                  } else {
                      return item.getJSONObject(attribute).get("key").toString();
                  }
            })
            .collect(Collectors.toList());