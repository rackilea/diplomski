public static void main(String[] args) throws Exception {
    String[] patterns = new String[] {
        // This will remove empty elements that look like <ElementName/>
        "\\s*<\\w+/>", 
        // This will remove empty elements that look like <ElementName></ElementName>
        "\\s*<\\w+></\\w+>", 
        // This will remove empty elements that look like 
        // <ElementName>
        // </ElementName>
        "\\s*<\\w+>\n*\\s*</\\w+>"
    };

    String xml = "    <form1>\n" +
                    "        <GenInfo>\n" +
                    "            <Section1>\n" +
                    "                <EmployeeDet>\n" +
                    "                    <Title>999990000</Title>\n" +
                    "                    <Firstname>MIKE</Firstname>\n" +
                    "                    <Surname>SPENCER</Surname>\n" +
                    "                    <CoName/>\n" +
                    "                    <EmpAdd>\n" +
                    "                        <Address><Add1/><Add2/><Town/><County/><Pcode/></Address>\n" +
                    "                    </EmpAdd>\n" +
                    "                    <PosHeld>DEVELOPER</PosHeld>\n" +
                    "                    <Email/>\n" +
                    "                    <ConNo/>\n" +
                    "                    <Nationality/>\n" +
                    "                    <PPSNo/>\n" +
                    "                    <EmpNo/>\n" +
                    "                </EmployeeDet>\n" +
                    "            </Section1>\n" +
                    "        </GenInfo>\n" +
                    "    </form1>";

    for (String pattern : patterns) {
        Matcher matcher = Pattern.compile(pattern).matcher(xml);
        xml = matcher.replaceAll("");
    }

    System.out.println(xml);
}