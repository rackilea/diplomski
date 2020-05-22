or(
    or(
        and(value("A"), value("B")),
        and(value("C"), value("D"))
    ), and(
        or(value("A"), value("B")),
        or(value("C"), value("D"))
    )
);