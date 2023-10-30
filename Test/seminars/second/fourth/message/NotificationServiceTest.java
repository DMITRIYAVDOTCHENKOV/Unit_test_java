package seminars.second.fourth.message;


import org.junit.jupiter.api.Test;
import org.seminars.fourth.message.MessageService;
import org.seminars.fourth.message.NotificationService;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Test
    void messageServiceTest() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        messageService.sendMessage("Hello", "Vasia");

        verify(messageService, times(1)).sendMessage("Hello", "Vasia");
    }

}