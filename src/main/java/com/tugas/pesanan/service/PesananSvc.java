package com.tugas.pesanan.service;

import com.tugas.pesanan.form.PesananForm;
import com.tugas.pesanan.model.PesananModel;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface PesananSvc {

    PesananModel create(PesananForm form);

    List<PesananModel> getAll();

    ResponseEntity<Objects> findById(Long id);

    ResponseEntity<Objects> updateById(PesananForm form, Long id);

    ResponseEntity<Objects> deletedbyId(Long id);
}
