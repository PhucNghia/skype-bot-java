package vnpt.stc.enterprise.stc_bot.common;

import com.microsoft.bot.schema.ConversationAccount;
import com.microsoft.bot.schema.ConversationReference;

public class CommonUtil {

    public static ConversationReference getConversationReference(String conversationId) {
        ConversationReference reference = new ConversationReference();
        reference.setActivityId(String.valueOf(System.currentTimeMillis()));
        ConversationAccount conversation = new ConversationAccount();
        conversation.setIsGroup(true);
        conversation.setId(conversationId);  // set conversationId (ex: skype group Id)
        reference.setConversation(conversation);
        reference.setChannelId("skype");
        reference.setLocale("en-US");
        reference.setServiceUrl("https://smba.trafficmanager.net/apis/");
        return reference;
    }
}
