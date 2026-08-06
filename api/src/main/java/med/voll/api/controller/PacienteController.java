package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.repositorio.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repositorio;

    @PostMapping @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repositorio.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosCadastroPaciente> listar(Pageable paginacao){
        return repositorio.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
