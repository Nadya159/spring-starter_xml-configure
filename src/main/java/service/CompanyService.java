package service;

import database.model.Company;
import database.repository.CompanyRepository;

import java.sql.SQLException;
import java.util.Optional;

public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findCompanyById(Integer id) throws SQLException {
        return companyRepository.findCompanyById(id);
    }
}
