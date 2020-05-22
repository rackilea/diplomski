package de.scrum_master.aspect;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

public aspect DetectEnumPersistencePolicy {
    pointcut ordinalEnumPersistence() :
        set(@Enumerated(value=EnumType.ORDINAL) * *) ||
        get(@Enumerated(value=EnumType.ORDINAL) * *);

    declare warning : ordinalEnumPersistence() :
        "Please consider using string persistence of enumerated types instead.";
}