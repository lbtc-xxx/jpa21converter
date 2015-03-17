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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCompositeKeyEmbeddable that = (MyCompositeKeyEmbeddable) o;

        if (someLocalDate != null ? !someLocalDate.equals(that.someLocalDate) : that.someLocalDate != null)
            return false;
        if (someLocalDateTime != null ? !someLocalDateTime.equals(that.someLocalDateTime) : that.someLocalDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = someLocalDateTime != null ? someLocalDateTime.hashCode() : 0;
        result = 31 * result + (someLocalDate != null ? someLocalDate.hashCode() : 0);
        return result;
    }
}
