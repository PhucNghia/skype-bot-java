package vnpt.stc.enterprise.stc_bot.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.bot.builder.Bot;
import org.springframework.context.annotation.Bean;
import vnpt.stc.enterprise.stc_bot.services.EventBot;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Bot getBot() {
        return new EventBot();
    }

    @Bean
    public Gson getGson() {
        return new GsonBuilder().create();
    }
}
