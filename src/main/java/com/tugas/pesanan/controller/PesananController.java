package com.tugas.pesanan.controller;

import com.tugas.pesanan.form.PesananForm;
import com.tugas.pesanan.model.PesananModel;
import com.tugas.pesanan.service.PesananSvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/pesanan")

public class PesananController {

    private final PesananSvc pesananSvc;


}

    @PostMapping
    public PesananModel create(@RequestBody PesananForm form){
        return pesananSvc.create(form);
    }

    @GetMapping
    public List<PesananModel> getAll(){
        return pesananSvc.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Objects> getById(@PathVariable Long id){
        return pesananSvc.findById(id);
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Objects> update(@RequestBody PesananForm form, @PathVariable Long id){
        return pesananSvc.updateById(form, id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Objects> deletedById(@PathVariable Long id){
        return pesananSvc.deletedbyId(id);
    }
}
