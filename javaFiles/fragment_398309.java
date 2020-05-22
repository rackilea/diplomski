if(pChar[Stelle]=='-')
        {
            Mybaum rTree=this.getRightTree();
            Stelle++;
            rTree.insert(pBuchstabe,pChar,Stelle);
            this.baum.**setLeftTree**(rTree.baum);
        }