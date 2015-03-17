package jpa21converter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MySimpleTable implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private java.time.LocalDateTime someLocalDateTime;
    private java.time.LocalDate someLocalDate;

    public Long getId() {
        return id;
    }

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
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", id, someLocalDate, someLocalDateTime);
    }
}
