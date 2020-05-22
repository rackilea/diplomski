public class Response {

        private Boolean approval_rules_overwritten;
        private List<Rule> rules;

        public static class Rule {
            private Integer id;
            private String name;
            private String rule_type;
            private Integer approvals_required;
            private List<Approval> approved_by;
            private Boolean approved;

            public static class Approval {
                private String id;
                private String name;
                private String username;
                private String state;
            }
        }
    }