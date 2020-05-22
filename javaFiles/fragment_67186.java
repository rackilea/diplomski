IJavaElement element = delta.getElement();

        if(element.getElementType() != IJavaElement.COMPILATION_UNIT)
            return;

        ICompilationUnit compilationUnit = (ICompilationUnit)element;

        try
        {

            IType type = compilationUnit.findPrimaryType();
            IMethod[] methods = type.getMethods();
            for(IMethod method : methods)
            {                
                ASTParser parser = ASTParser.newParser(AST.JLS3);                
                parser.setSource(compilationUnit);
                parser.setSourceRange(method.getSourceRange().getOffset(), method.getSourceRange().getLength());
                //parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
                //parser.setSource(method.getSource().toCharArray());
                //parser.setProject(method.getJavaProject());                
                parser.setResolveBindings(true);
                CompilationUnit cu = (CompilationUnit)parser.createAST(null);
                cu.accept(new ASTMethodVisitor());

                // If the visitor visit the right VariableDeclarationFragment,
                // then the right IMethod is the current 'method' variable

            }                        
        }
        catch(JavaModelException e)
        {         
            e.printStackTrace();
        }