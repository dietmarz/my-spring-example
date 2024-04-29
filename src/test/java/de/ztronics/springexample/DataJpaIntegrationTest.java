package de.ztronics.springexample;

import de.ztronics.springexample.model.User;
import de.ztronics.springexample.model.Voucher;
import de.ztronics.springexample.repository.VoucherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DataJpaIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoucherRepository voucherRepository;

    @Test
    void testCreateUserAndVoucher() {
        // Erstelle und speichere einen neuen User
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        User savedUser = entityManager.persistFlushFind(user);

        // Erstelle und speichere einen neuen Voucher für den User
        Voucher voucher = new Voucher();
        voucher.setCode("WELCOME2024");
        voucher.setRedeemed(false);
        voucher.setUser(savedUser);
        Voucher savedVoucher = entityManager.persistFlushFind(voucher);

        // Verifiziere, dass der Voucher dem User zugeordnet ist
        assertThat(savedVoucher.getUser()).isEqualTo(savedUser);

        Voucher foundVoucher = voucherRepository.findAll().stream().findFirst().orElseThrow();
        assertThat(foundVoucher).isEqualTo(savedVoucher);
    }
}
