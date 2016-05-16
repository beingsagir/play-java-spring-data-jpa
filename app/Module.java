import com.google.inject.AbstractModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import services.ApplicationTimer;
import services.AtomicCounter;
import services.Counter;

import java.time.Clock;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */

@Configuration
@EnableJpaRepositories("repositories")
public class Module extends AbstractModule {

    //static final String DEFAULT_PERSISTENCE_UNIT = "defaultPersistenceUnit";

    @Override
    public void configure() {
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);
    }
/*
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
    }*/

}
