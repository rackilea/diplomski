public lList deleteInfo(String outInfo) {
        if ( nextList() != null && nextList().info == outInfo ) {
            lList link = nextList();

            nextList = link.nextList();
        }
        else if (nextList() != null){
            nextList().deleteInfo( outInfo );
        }
        return this;
    }