public static final Pattern localePattern = Pattern.compile(
    "^(?<lang>\\p{Lower}{2,3})" + // always match lang
    "(-(?<script>\\p{Upper}\\p{Lower}{3}))?" + // optional script
    "(_(?<region>(\\p{Upper}{2}|\\p{Digit}{3})))?" + // optional region
    "(_(?<variant>\\p{Alnum}+))?" + // optional variant
    "(@.+)?$" // optional @ stuff
);