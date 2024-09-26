package hu.unideb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @EqualsAndHashCode.Include
    String neptun;
    String name;
    Program program;
    OffsetDateTime created;
    OffsetDateTime updated;

    //bean: automatikusan peldanyositodo osztaly

    public enum Program {
        CS_BSC,
        CSE_BSC,
        BI_BSC
    }
}
