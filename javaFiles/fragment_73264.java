StringBuilder subject = new StringBuilder(items.size() * 80);

    for (Itprojekte project : items) {
        ...
    }
    if (subject.length() < 1500) {
        Logger.getLogger(ProjectsResultjForm.class.getName()).log(Level.WARN,
                "*** Mail body: {0}", subject);
    }