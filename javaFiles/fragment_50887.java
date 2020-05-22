@RequestMapping("/geral")
        public ResponseEntity<InputStreamResource> relatorioAdministrador(EdicaoCadastroMovimentacaoWrapper wrapper, @AuthenticationPrincipal Usuario usuario) {

            byte[] arquivo = gerarReportService.relatorioParaAdmin(wrapper.getContaId(), usuario);

            return ResponseEntity
                    .ok()
                    .contentLength(arquivo.length)
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .header("Content-Disposition", "attachment; filename=relatorio.pdf")
                    .body(new InputStreamResource(new ByteArrayInputStream(arquivo)));
        }