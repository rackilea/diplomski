const JAVA_ID = /[a-zA-Z_]\w*/;

module.exports = grammar({

    name: 'clojure',

    extras: $ =>
        [/[\s,]/],

    rules: {
        program: $ =>
            repeat($._anything),

        _anything: $ =>
            choice($.symbol,
                   $.member_access,
                   $.new_class),

        symbol: $ =>
            choice($._symbol_chars,
                   $.scoped_identifier),

        // XXX: approximate, see: https://clojure.org/reader
        _symbol_chars: $ =>
            /[a-zA-Z\*\+\!\-_\?][\w\*\+\!\-\?\':]*/,

        // XXX: except $ can be used too for inner classes?
        scoped_identifier: $ =>
            token(seq(JAVA_ID,
                      repeat(seq('.', JAVA_ID)))),

        // e.g. .toUpperCase
        member_access: $ =>
            token(seq('.',
                      JAVA_ID,
                      repeat(seq('.', JAVA_ID)))),

        // e.g. java.lang.String.
        new_class: $ =>
            token(seq(JAVA_ID,
                      repeat(seq('.', JAVA_ID)),
                      '.')),

    }
});

function sep1 (rule, separator) {
    return seq(rule, repeat(seq(separator, rule)));
}