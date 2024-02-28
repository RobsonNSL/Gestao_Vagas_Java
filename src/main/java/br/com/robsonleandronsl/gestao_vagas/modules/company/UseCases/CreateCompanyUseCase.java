package br.com.robsonleandronsl.gestao_vagas.modules.company.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robsonleandronsl.gestao_vagas.exceptions.UserFoundException;
import br.com.robsonleandronsl.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.robsonleandronsl.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                .findByusernameOrEmail(companyEntity.getName(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}
