package vnpt.stc.enterprise.stc_bot.services;

import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.schema.ConversationReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vnpt.stc.enterprise.stc_bot.common.CommonUtil;
import vnpt.stc.enterprise.stc_bot.endpoints.NotifyEndpoint;
import vnpt.stc.enterprise.stc_bot.entity.NotifyDto;

@Service
public class BotService {
    private static final Logger logger = LoggerFactory.getLogger(NotifyEndpoint.class);
    private final BotFrameworkHttpAdapter adapter;
    private final String appId;

    public BotService(BotFrameworkHttpAdapter adapter, Configuration configuration) {
        this.adapter = adapter;
        this.appId = configuration.getProperty("MicrosoftAppId");
    }

    public boolean sendNotify(NotifyDto notifyDto) {
        // Create conversation
        ConversationReference conversation = CommonUtil.getConversationReference(notifyDto.getConversationId());

        // Send notify to group
        try {
            adapter.continueConversation(
                    appId, conversation, turnContext -> turnContext.sendActivity(notifyDto.getBody()).thenApply(resourceResponse -> null)
            );
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
        return true;
    }
}
