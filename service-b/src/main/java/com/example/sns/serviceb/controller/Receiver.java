package com.example.sns.serviceb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.config.annotation.NotificationSubject;
import io.awspring.cloud.messaging.endpoint.NotificationStatus;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationMessageMapping;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;

@Controller
@RequestMapping("/receive")
public class Receiver {

        @NotificationSubscriptionMapping
        public void confirmUnsubscribeMessage(
          NotificationStatus notificationStatus) {
            notificationStatus.confirmSubscription();
        }
     
        @NotificationMessageMapping
        public void receiveNotification(@NotificationMessage String message, 
          @NotificationSubject String subject) {
            // handle message
            System.out.println(message);
        }

        @NotificationUnsubscribeConfirmationMapping
        public void confirmSubscriptionMessage(
          NotificationStatus notificationStatus) {
            notificationStatus.confirmSubscription();
        }

}
