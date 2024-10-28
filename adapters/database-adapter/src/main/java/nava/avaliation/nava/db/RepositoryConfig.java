package nava.avaliation.nava.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "nava.avaliation.nava.db")
public class RepositoryConfig {
}