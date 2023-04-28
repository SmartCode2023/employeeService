package com.example.Empleados.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conductores")
public class Conductores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String documentoDeIdentificacion;
    @Column
    private String apellido;
    @Column
    private Integer tipoDeConductorId;
    @Column
    private Integer tipoDocumentoIdentificacionId;

}
