Bson filter = and(
                and(fullname),
                or(
                        and(bd),                  // no "eq" here
                        eq("document", document)
                )
        );