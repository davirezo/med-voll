package med.voll.api.domain.medico;

public record DadosListagemMedico(
        Boolean ativo,
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public DadosListagemMedico(Medico medico){
        this(medico.getAtivo(), medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
