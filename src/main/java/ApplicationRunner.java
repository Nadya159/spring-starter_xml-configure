import database.repository.UserRepository;
import service.CompanyService;
import service.UserService;
import database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class ApplicationRunner {
    public static void main(String[] args) throws SQLException {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {

            var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            var companyService = context.getBean("companyService", CompanyService.class);
            var company = companyService.findCompanyById(2);
            System.out.println(company);

            var userRepository = context.getBean("userRepository", UserRepository.class);
            var userService = context.getBean("userService", UserService.class);
            var user = userService.findUserById(2);
            System.out.println(user);
        }
    }
}
