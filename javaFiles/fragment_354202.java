function launchApplication(jnlpfile) {
            dtjava.launch({
                url: 'MD.jnlp',
                params: {'name':'value'}
            },
            {
                javafx: '2.2+'
            },
            {}
            );
            return false;
        }