package saga.sample.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;

@Configuration
@Import({ TramEventSubscriberConfiguration.class, TramJdbcKafkaConfiguration.class })
public class BookEventConfiguration {

    @Bean
    public BookEventConsumer bookEventConsumer() {
        return new BookEventConsumer();
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(BookEventConsumer bookEventConsumer,
            DomainEventDispatcherFactory domainEventDispatcherFactory) {
        return domainEventDispatcherFactory.make("ProducerEvents", bookEventConsumer.domainEventHandlers());
    }

}
