package org.telesoccorso.model;

import javax.persistence.*;

@NamedStoredProcedureQuery(
        name = "CodaEveModel.sp_i_InsertAllarmi_in_CodaEve_Brondi",
        procedureName = "sp_i_InsertAllarmi_in_CodaEve_Brondi",
        resultClasses = CodaEveModel.class,
        parameters = {
                @StoredProcedureParameter(
                        name = "p_telefono",
                        type = String.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "p_filename",
                        type = Integer.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "p_centrale",
                        type = Integer.class,
                        mode = ParameterMode.IN
                )
        }
)
@Entity(name = "CODA_EVE")
public class CodaEveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ALLARME", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
