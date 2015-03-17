package jpa21converter.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("UnusedDeclaration")
@Converter(autoApply = true)
public class MyLocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {
    private static final Logger log = Logger.getLogger(MyLocalDateTimeConverter.class.getName());
    private static final Level LEVEL = Level.FINEST;

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime attribute) {
        log.log(LEVEL, "convertToDatabaseColumn({0})", attribute);
        return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
    }

    @Override
    public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData) {
        log.log(LEVEL, "convertToEntityAttribute({0})", dbData);
        return dbData == null ? null : dbData.toLocalDateTime();
    }
}
