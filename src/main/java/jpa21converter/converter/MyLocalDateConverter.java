package jpa21converter.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("UnusedDeclaration")
@Converter(autoApply = true)
public class MyLocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date> {
    private static final Logger log = Logger.getLogger(MyLocalDateConverter.class.getName());
    private static final Level LEVEL = Level.FINEST;

    @Override
    public java.sql.Date convertToDatabaseColumn(java.time.LocalDate attribute) {
        log.log(LEVEL, "convertToDatabaseColumn({0})", attribute);
        return attribute == null ? null : java.sql.Date.valueOf(attribute);
    }

    @Override
    public java.time.LocalDate convertToEntityAttribute(java.sql.Date dbData) {
        log.log(LEVEL, "convertToEntityAttribute({0})", dbData);
        return dbData == null ? null : dbData.toLocalDate();
    }
}
