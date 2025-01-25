package br.com.planejagastos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

import br.com.planejagastos.enumerate.TipoRegistro;

@AllArgsConstructor
@Data
@Entity
@Table(name = "estrutura_registros")
public class EstruturaRegistroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoRegistro tipo;

    @ManyToOne
    @JoinColumn(name = "estrutura_id", nullable = false)
    private EstruturaEntity estrutura;
}

