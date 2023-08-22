package vnpt.stc.enterprise.stc_bot.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vnpt.stc.enterprise.stc_bot.entity.NotifyDto;
import vnpt.stc.enterprise.stc_bot.services.NotifyService;

@RestController
public class NotifyEndpoint {
    private final NotifyService notifyService;

    @Autowired
    public NotifyEndpoint(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    @PostMapping("/api/notification")
    public ResponseEntity<Object> sendNotify(@RequestBody NotifyDto notifyDto) {
        return notifyService.sendNotify(notifyDto);
    }
}
