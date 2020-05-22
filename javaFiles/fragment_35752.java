<step id="chunkOrientedStep">
    <tasklet>
        <chunk 
            reader="itemReader"
            writer="itemWriter" 
            commit-interval="#{jobParameters['commit.interval']}">
        </chunk>
    </tasklet>
</step>