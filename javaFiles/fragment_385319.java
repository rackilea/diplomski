Date thisDate = this.getDocuments()
                .stream()
                .map(Document::getCreateDate)
                .max(Date::compareTo)
                .orElseGet(Date::new);
        Date otherDate = o.getDocuments()
                .stream()
                .map(Document::getCreateDate)
                .max(Date::compareTo)
                .orElseGet(Date::new);