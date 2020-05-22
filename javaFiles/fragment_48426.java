final Map<String, String> result = Arrays.stream(style.split(";")) //
          .map(String::trim)
          .map(s->s.split(":")) //
          .filter(s -> s.length <= 2) //
          .collect(Collectors.toMap(s -> s[0].trim(),
              s -> s.length > 1 ? s[1] : ""));