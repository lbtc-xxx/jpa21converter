package jpa21converter.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class MyCompositeKeyTable implements Serializable {
    @EmbeddedId
    private MyCompositeKeyEmbeddable key;

    @SuppressWarnings("UnusedDeclaration")
    public MyCompositeKeyEmbeddable getKey() {
        return key;
    }

    public void setKey(MyCompositeKeyEmbeddable key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
