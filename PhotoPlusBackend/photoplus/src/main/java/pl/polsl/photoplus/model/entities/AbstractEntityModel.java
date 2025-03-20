package pl.polsl.photoplus.model.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import java.security.SecureRandom;

/**
 * Base class for all entities.
 * Contains all common values for model objects.
 * After extending that class the columns from that class are inserted to entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntityModel
{
    @Transient
    protected final int CODE_NAME_LENGTH = 4;

    @Transient
    protected final int CODE_NUMBER_LENGTH = 8;

    public AbstractEntityModel()
    {
        this.code=createCodeNumber();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected long id;

    @Column(name = "model_code")
    protected @NotBlank String code;

    /**
     * Function is responsible for generating code for given model type.
     * Function is automatically invoked when creating object.
     * See constructor of AbstractEntityModel.
     * Code should consist of generated numbers
     *
     * Using secure random should be enough to guarantee that codes won't be the same.
     */
    protected String createCodeNumber()
    {
        final SecureRandom secureRandom = new SecureRandom();
        final long secureNumber = id + Math.abs(secureRandom.nextLong());
        final String codeNumber = Long.toString(secureNumber);
        return codeNumber.substring(0, CODE_NUMBER_LENGTH);
    }

}
