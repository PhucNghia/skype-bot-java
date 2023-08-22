package vnpt.stc.enterprise.stc_bot.services;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnpt.stc.enterprise.stc_bot.endpoints.NotifyEndpoint;
import vnpt.stc.enterprise.stc_bot.entity.NotifyDto;

@Service
public class NotifyService {
    private static final Logger logger = LoggerFactory.getLogger(NotifyEndpoint.class);
    private final Gson gson;
    private final BotService botService;

    public NotifyService(Gson gson, BotService botService) {
        this.gson = gson;
        this.botService = botService;
    }

    public ResponseEntity<Object> sendNotify(NotifyDto notifyDto) {
        logger.info("Start sendNotify #{}", gson.toJson(notifyDto));

        // validate param
        if(notifyDto == null) {
            return new ResponseEntity<>("body is not empty", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmpty(notifyDto.getConversationId())) {
            return new ResponseEntity<>("conversationId is not empty", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isEmpty(notifyDto.getBody())) {
            return new ResponseEntity<>("body is not empty", HttpStatus.BAD_REQUEST);
        }

        // Send notify
        if(!botService.sendNotify(notifyDto)) {
            return new ResponseEntity<>("error when call SDK", HttpStatus.BAD_REQUEST);
        }
        logger.info("End sendNotify #{}", gson.toJson(notifyDto));

        return new ResponseEntity<>("messages have been sent. content: " + notifyDto.getBody(),HttpStatus.ACCEPTED);
    }
}
