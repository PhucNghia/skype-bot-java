package vnpt.stc.enterprise.stc_bot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import vnpt.stc.enterprise.stc_bot.endpoints.NotifyEndpoint;
import vnpt.stc.enterprise.stc_bot.entity.NotifyDto;

public class ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(NotifyEndpoint.class);
    //(STC - Chém gió)
    private static final String STC_GROUP_ID = "19:ceb3d4c7ea254528b50769ec922a8e72@thread.skype";
    //(Mobile Team)
    private static final String ONE_HOME_GROUP_ID = "19:c79c6819227c48f185873e16d2aa4ec2@thread.skype";

    @Autowired
    private BotService botService;
    /**
     * Job nhắc log work vào 8h15 ngày Thứ 6
     */
    @Scheduled(cron = "0 15 08 * * FRI")
    public void logWorkSchedule() {
        logger.info("Start run logWorkSchedule");

        String content = "Mọi người cập nhật trạng thái công việc ngày hôm nay nhé\nhttps://docs.google.com/spreadsheets/d/1yvAJp93nd6WdTkCMnQ0ZQRBZew2gmxL0hbPfWtT0Io4/edit#gid=1198474019";
        NotifyDto notifyDto = new NotifyDto(STC_GROUP_ID, content);
        botService.sendNotify(notifyDto);

        logger.info("End run logWorkSchedule");
    }

    /**
     * Job nhắc daily meeting nhóm One-Home vào 17h45 từ T2->T6
     */
    @Scheduled(cron = "00 45 17 * * MON-FRI")
    public void dailyMeetingSchedule() {
        logger.info("Start run dailyMeetingSchedule");

        String content = "Hôm nay là thứ 6 rồi. Cả nhà log work nhé\n(tropicalfish)(tropicalfish)(tropicalfish)";
        NotifyDto notifyDto = new NotifyDto(ONE_HOME_GROUP_ID, content);
        botService.sendNotify(notifyDto);

        logger.info("End run dailyMeetingSchedule");
    }
}
