package vnpt.stc.enterprise.stc_bot;

import com.microsoft.bot.integration.spring.BotController;
import com.microsoft.bot.integration.spring.BotDependencyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BotController.class})
public class StcBotApplication extends BotDependencyConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(StcBotApplication.class, args);
	}
}
