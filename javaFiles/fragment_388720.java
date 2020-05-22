if(lexer.peekToken().getType() == TokenType.QUOTE) {
            // Here we know there will be one or more children and that the sequence starts and ends with a "quote command"
            List<ParseTree> children = new ArrayList<>();
            ParseTree child = Cmd(); // The initial "quote command" - just ignore
            while ((child = Cmd()) != TokenType.QUOTE) {
                // Will stop looping when the second quote is found
                children.add(child);
            }
            return new CMDNode(t.getType(), children); // Yes, you need to create a new constructor
        }
        else {
            // Here we know there will only one child
            ParseTree child = Cmd();
            return new CMDNode(t.getType(), child);
        }