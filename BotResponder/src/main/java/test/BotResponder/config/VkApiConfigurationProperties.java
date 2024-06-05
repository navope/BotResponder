package test.BotResponder.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@PropertySource(value = "classpath:application.properties")
public class VkApiConfigurationProperties {
    @Value("${vk.api.access-token}")
    private String accessToken;
    @Value("${vk.api.v}")
    private Double v;
    @Value("${vk.api.secret}")
    private String secret;
    @Value("${vk.api.confirmation}")
    private String confirmation;
}