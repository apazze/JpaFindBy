package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FuncionarioRepositoryTest {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Test
    void deveBuscarPorNomeEAtivo(){
        Funcionario f = new Funcionario("Jose", false);
        Funcionario f2 = new Funcionario("Maria", false);
        Funcionario f3 = new Funcionario("Jose", true);
        Funcionario f4 = new Funcionario("", true);
        Funcionario f5 = new Funcionario("jose", false);
        Funcionario f6 = new Funcionario("Jose", false);
        funcionarioRepository.saveAll(List.of(f,f2,f3,f4,f5,f6));
        List<Funcionario> buscados = funcionarioRepository.findByNomeAndAtivo("Jose", false);

        assertThat(buscados).hasSize(2);
    }
}