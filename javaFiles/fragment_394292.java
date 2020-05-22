public class FormatData_cs extends ParallelListResourceBundle
{
    @Override
    protected final Object[][] getContents() {
        return new Object[][] { { "MonthNames", 
        { "ledna", "\u00fanora", "b\u0159ezna", "dubna", "kv\u011btna", "\u010dervna", "\u010dervence", "srpna", "z\u00e1\u0159\u00ed", "\u0159\u00edjna", "listopadu", "prosince", "" } }, 
        { "standalone.MonthNames", { "leden", "\u00fanor", "b\u0159ezen", "duben", "kv\u011bten", "\u010derven", "\u010dervenec", "srpen", "z\u00e1\u0159\u00ed", "\u0159\u00edjen", "listopad", "prosinec", "" } }, 
        { "MonthAbbreviations", { "Led", "\u00dano", "B\u0159e", "Dub", "Kv\u011b", "\u010cer", "\u010cvc", "Srp", "Z\u00e1\u0159", "\u0158\u00edj", "Lis", "Pro", "" } }, 
        { "standalone.MonthAbbreviations", { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "" } }, 
        { "MonthNarrows", { "l", "\u00fa", "b", "d", "k", "\u010d", "\u010d", "s", "z", "\u0159", "l", "p", "" } },
        { "standalone.MonthNarrows", { "l", "\u00fa", "b", "d", "k", "\u010d", "\u010d", "s", "z", "\u0159", "l", "p", "" } }, 
        { "DayNames", { "Ned\u011ble", "Pond\u011bl\u00ed", "\u00dater\u00fd", "St\u0159eda", "\u010ctvrtek", "P\u00e1tek", "Sobota" } }, 
        { "standalone.DayNames", { "ned\u011ble", "pond\u011bl\u00ed", "\u00fater\u00fd", "st\u0159eda", "\u010dtvrtek", "p\u00e1tek", "sobota" } }, 
        { "DayAbbreviations", { "Ne", "Po", "\u00dat", "St", "\u010ct", "P\u00e1", "So" } }, 
        { "standalone.DayAbbreviations", { "ne", "po", "\u00fat", "st", "\u010dt", "p\u00e1", "so" } }, 
        { "DayNarrows", { "N", "P", "\u00da", "S", "\u010c", "P", "S" } }, 
        { "standalone.DayNarrows", { "N", "P", "\u00da", "S", "\u010c", "P", "S" } },
        { "AmPmMarkers", { "dop.", "odp." } }, 
        { "Eras", { "p\u0159.Kr.", "po Kr." } }, 
        { "short.Eras", { "p\u0159. n. l.", "n. l." } }, 
        { "narrow.Eras", { "p\u0159.n.l.", "n. l." } }, 
        { "NumberElements", { ",", " ", ";", "%", "0", "#", "-", "E", "\u2030", "\u221e", "\ufffd" } }, 
        { "TimePatterns", { "H:mm:ss z", "H:mm:ss z", "H:mm:ss", "H:mm" } }, 
        { "DatePatterns", { "EEEE, d. MMMM yyyy", "d. MMMM yyyy", "d.M.yyyy", "d.M.yy" } }, 
        { "DateTimePatterns", { "{1} {0}" } }, 
        { "DateTimePatternChars", "GuMtkHmsSEDFwWahKzZ" } };
    }
}