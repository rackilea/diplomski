@JoinTable(name = "LSFCFTB", joinColumns = {
                    @JoinColumn(name = "LSFOC_LSFCF_CODLSC", referencedColumnName = "LSFOC_CODLSC"),
                    @JoinColumn(name = "LSFOC_LSFCF_CODFOC", referencedColumnName = "LSFOC_CODFOC"),
                    @JoinColumn(name = "LSFOC_LSFCF_CODSOC", referencedColumnName = "LSFOC_CODSOC") }, 
        inverseJoinColumns = { @JoinColumn(name = "LSFOR_LSFCF_CODLSC", referencedColumnName = "LSFOR_CODLSC"),
                    @JoinColumn(name = "LSFOR_LSFCF_CODFOR", referencedColumnName = "LSFOR_CODFOR"),
                    @JoinColumn(name = "LSFOR_LSFCF_CODSOC", referencedColumnName = "LSFOR_CODSOC") })