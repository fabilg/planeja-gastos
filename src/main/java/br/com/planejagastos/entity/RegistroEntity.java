package br.com.planejagastos.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.planejagastos.enumerate.TipoRegistro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "registros")
public class RegistroEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
    private Long id;
    
	@Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
	
	@Positive
	@Column(name = "valor", nullable = false)    
    private Double valor;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_registro", nullable = false)
    private TipoRegistro tipo;
    
    @OneToOne
    @JoinColumn(name = "estrutura_registro_id", nullable = true)
    private EstruturaRegistroEntity estruturaRegistro;    
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_registro", nullable = false)
    private LocalDate data;
}
