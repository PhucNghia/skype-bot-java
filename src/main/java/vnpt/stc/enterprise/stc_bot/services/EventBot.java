package vnpt.stc.enterprise.stc_bot.services;

import com.google.gson.Gson;
import com.microsoft.bot.builder.ActivityHandler;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EventBot extends ActivityHandler {
    private static final Logger logger = LoggerFactory.getLogger(EventBot.class);

    @Autowired
    private Gson gson;

    /*
        Method xử lý khi bot được mention
     */
    @Override
    protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        Activity activity = turnContext.getActivity();
        logger.info("onMessageActivity, activity: {}", gson.toJson(activity));

        String content = activity.getText();

        if(content.contains("all")) {
            logger.info("Reloaded, content: " + content);
            return null;
        }

        String user = activity.getFrom().getName();
        String contentForRep;

        if(user.contains("Đặng Quí Long") || user.contains("Bui Minh Yen")) {
            contentForRep = String.format("Hê's lô phó's lãnh đạo %s (happyeyes)", user);
        } else if(user.contains("Trung Nguyen")) {
            contentForRep = String.format("Hê's lô sếp %s (happyeyes)", user);
        } else {
            contentForRep = String.format("Hê's lô bạn %s (happyeyes)", user);
        }

        // phản hồi lại user
        return turnContext
                .sendActivity(MessageFactory.text(contentForRep))
                .thenApply(sendResult -> null);
    }

    /*
        Method xử lý khi bot được Thêm hoặc Xóa khỏi nhóm
     */
    @Override
    public CompletableFuture<Void> onTurn(TurnContext turnContext) {
        List<ChannelAccount> membersAdded = turnContext.getActivity().getMembersAdded();
        // Thêm bot vào nhóm
        if(membersAdded != null && !membersAdded.isEmpty()) {
            logger.info("add member activity: {}", gson.toJson(turnContext.getActivity()));
            logger.info("group ID: {}", turnContext.getActivity().getConversation().getId());
        }
        return super.onTurn(turnContext);
    }
}
