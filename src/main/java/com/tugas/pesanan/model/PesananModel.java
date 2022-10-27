package com.tugas.pesanan.model;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pesanan")
@NoArgsConstructor
@MappedSuperclass
public class PesananModel extends BaseDao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "jenis film", nullable = false)
    private String jenisFilm;

    @Column(name = "harga ticket", nullable = false)
    private Double hargaTicket;
}
