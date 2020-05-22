String input = "12B17T"; // according to the other SO-post

int pivotYear = 2032;
DateTimeParser monthParser =
    new DateTimeParser() {

        @Override
        public int estimateParsedLength() {
            return 1;
        }

        @Override
        public int parseInto(DateTimeParserBucket bucket, String text, int position) {
            DateTimeField field = ISOChronology.getInstance().monthOfYear();
            char c = text.charAt(position);

            if (c >= '1' && c <= '9') {
                int value = c - '0';
                bucket.saveField(field, value);
                return position + 1;
            }

            switch (c) {
                case 'A' :
                    bucket.saveField(field, 10);
                    break;
                case 'B' :
                    bucket.saveField(field, 11);
                    break;
                case 'C' :
                    bucket.saveField(field, 12);
                    break;

                default :
                    return ~position;
            }
            return position + 1;
        }
    };

DateTimeFormatter f =
  new DateTimeFormatterBuilder().appendTwoDigitYear(pivotYear - 50).append(monthParser)
  .appendDayOfMonth(2).appendLiteral('T').toFormatter();

LocalDate date = f.parseLocalDate(input);
System.out.println(date); // output: 2012-11-17