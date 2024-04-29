package de.ztronics.springexample.service;

import de.ztronics.springexample.model.User;
import de.ztronics.springexample.model.Voucher;
import de.ztronics.springexample.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    private final NotificationService notificationService;
    private final VoucherRepository voucherRepository;

    @Autowired
    public WelcomeService(NotificationService notificationService, VoucherRepository voucherRepository) {
        this.notificationService = notificationService;
        this.voucherRepository = voucherRepository;
    }

    public void welcomeNewUser(User user) {
        // Create and save a new voucher
        Voucher voucher = new Voucher();
        voucher.setCode("WELCOME2024"); // Generiere vielleicht einen einzigartigen Code
        voucher.setRedeemed(false);
        voucher.setUser(user);
        voucherRepository.save(voucher);

        // Send welcome email
        notificationService.sendWelcomeEmail(user.getEmail());


        // Optional: Zusätzliche Logik, z.B. Protokollierung oder Benachrichtigung anderer Systeme
    }
}
