package pl.polsl.photoplus.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.polsl.photoplus.annotations.Patchable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity(name = "topics")
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
public class Topic
        extends AbstractEntityModel
{

    @Patchable
    private String name;

    @ManyToOne
    @Patchable
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Section section;

    @Patchable
    private LocalDate date;

    @ManyToOne
    private User creator;

    public Topic(final String name, final LocalDate date)
    {
        this.name = name;
        this.date = date;
    }
}
