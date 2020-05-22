public class Test {

        public static class Logger {

            private static final int MAX_WHITESPACES = 20;

            public static void s(String token, String lex) {
                String whitespaces = new String(new char[Math.abs(token.length()-MAX_WHITESPACES)]).replace('\0', ' ');;
                String line = String.format("token: %s"+whitespaces+"lexical unit: %s", token, lex);
                System.out.println(line);
            }

        }

        public static void main(String[] args) {
            Logger.s("accept","ACCEPT_KEYWORD");
            Logger.s("a","IDENTIFIER");
            Logger.s(".\\’n’","END_OF_INSTRUCTION");
            Logger.s("perform","PERFORM_KEYWORD");
        }


    }