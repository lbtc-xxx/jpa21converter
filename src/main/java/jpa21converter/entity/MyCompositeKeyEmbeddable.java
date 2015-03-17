package jpa21converter.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MyCompositeKeyEmbeddable implements Serializable {
    @Column(nullable = false)
    private java.time.LocalDateTime someLocalDateTime;
    @Column(nullable = false)
    private java.time.LocalDate someLocalDate;

    public java.time.LocalDateTime getSomeLocalDateTime() {
        return someLocalDateTime;
    }

    public void setSomeLocalDateTime(java.time.LocalDateTime someLocalDateTime) {
        this.someLocalDateTime = someLocalDateTime;
    }

    public java.time.LocalDate getSomeLocalDate() {
        return someLocalDate;
    }

    public void setSomeLocalDate(java.time.LocalDate someLocalDate) {
        this.someLocalDate = someLocalDate;
    }

    @Override
    public String toString() {
        return String.format("<tr><td>%s</td><td>%s</td></tr>", someLocalDate, someLocalDateTime);
    }
}
