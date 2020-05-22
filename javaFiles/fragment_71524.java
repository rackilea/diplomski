seq.addMetaEventListener(new MetaEventListener() {

            @Override
            public void meta(MetaMessage metaMsg) {
                if (metaMsg.getType() == 0x2F) {
                    seq.close();
                }
            }
        });