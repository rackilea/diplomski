parser grammar formatterParser;

options {   tokenVocab = formatterLexer; }

source_stream
 : segments EOF
 ;

 segments
 : segment*
 ;

 segment
 : (text | replacement_field)
 ;

 text
 : CHAR_NOCURLY+
 ;

 replacement_field
 : OPEN_RF field_name? (EXLM conversion)? (COLON format_spec)? CLOSE_RF
 ;

 field_name 
 : arg_name ((DOT attribute_name) | LIX element_index RIX)*
 ;

 arg_name
 : (identifier | INTEGER)? 
 ;

 attribute_name
 : identifier
 ;

element_index
: INTEGER | index_string
;

index_string
: CHAR_NORIGHTB+
;

identifier
: NAME
;

conversion
: LS
;

format_spec
: (fill? align)? sign? hash? zero? width? dash? precision? type?
;

fill
: CHAR
;

align
: LT | MT | EQ | EXP
;

sign
: PLUS | MINUS | SPACE
;

hash
: HASH
;

zero
: ZERO
;

width
: INTEGER
;

precision
: INTEGER
;

type
: TYPE
;

dash
: COMMA
;