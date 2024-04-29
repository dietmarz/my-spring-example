package de.ztronics.springexample.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendWelcomeEmail(String email) {
        // Logik zum Senden einer Willkommens-E-Mail
        System.out.println("Sending welcome email to " + email);
    }
}
