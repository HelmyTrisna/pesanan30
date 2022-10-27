package com.tugas.pesanan.service;

import com.tugas.pesanan.constant.MessageConstant;
import com.tugas.pesanan.form.PesananForm;
import com.tugas.pesanan.model.PesananModel;
import com.tugas.pesanan.repository.PesananRepository;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PesananSvcImpl implements PesananSvc{

    private final PesananRepository pesananRepo;

    @Autowired
    public PesananSvcImpl(PesananRepository pesananRepo){
        this.pesananRepo = pesananRepo;
    }

    @Override
    public PesananModel create(PesananForm form) {

        return pesananRepo.save(pesanan(form));
    }

    @Override
    public List<PesananModel> getAll() {
        return pesananRepo.findAll();
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        try {
            Optional<PesananModel> getById = pesananRepo.findById(id);
            return getById.map(pesananModel -> ResponseUtil.build(MessageConstant.SUCCESS, pesananModel, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deletedById(Long id) {
        try {
            Optional<PesananModel> data = pesananRepo.findById(id);
            if (!data.isPresent())
                return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            pesananRepo.deleteOne(true, data.get().getId());
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETES, null, HttpStatus.OK);

        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Objects> updateById(PesananForm form, Long id) {
        try {
            Optional<PesananModel> getById = pesananRepo.findById(id);
            if (!getById.isPresent())
                return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            PesananModel product = getById.get();
            pesanan.setjenisFilm(form.getJenisFilm());
            pesanan.sethargaTicket(form.getHargaTicket());
            pesananRepo.save(product);
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, pesananRepo.save(product), HttpStatus.OK);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }

    private PesananModel product(PesananForm form){
        PesananModel pesanan = new PesananModel();
        pesanan.setjenisfilm(form.getJenisFilm());
        pesanan.sethargaTicket(form.getHargaTicket());

        return pesanan;

    }

}

}
