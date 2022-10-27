package com.tugas.pesanan.repository;

import com.tugas.pesanan.model.PesananModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PesananRepository extends JpaRepository<PesananModel, Long> {
}
