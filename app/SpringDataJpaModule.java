/**
 * Created by Sagir on 2/12/2016.
 */

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.spring.guice.module.SpringModule;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import play.db.DB;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

/**
 * Application wide behaviour. We establish a Spring application context for the dependency injection system and
 * configure Spring Data.
 */

@Singleton
public class SpringDataJpaModule extends SpringModule {

    static final String DEFAULT_PERSISTENCE_UNIT = "defaultPersistenceUnit";

    /**
     * Sync the context lifecycle with Play's.
     */
    @Inject
    public SpringDataJpaModule() {
        super((DefaultListableBeanFactory)new AnnotationConfigApplicationContext(SpringDataJpaConfiguration.class).getAutowireCapableBeanFactory());
    }

    /**
     * This configuration establishes Spring Data concerns including those of JPA.
     */

    @Configuration
    @EnableJpaRepositories("repositories")
    public static class SpringDataJpaConfiguration {

        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator() {
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            return new JpaTransactionManager();
        }

    }

}