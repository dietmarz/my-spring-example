package de.ztronics.springexample.repository;

import de.ztronics.springexample.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}
