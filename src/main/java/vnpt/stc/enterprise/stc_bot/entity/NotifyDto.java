package vnpt.stc.enterprise.stc_bot.entity;

public class NotifyDto {
    private String conversationId;
    private String body;

    public NotifyDto() {
    }

    public NotifyDto(String conversationId, String body) {
        this.conversationId = conversationId;
        this.body = body;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
