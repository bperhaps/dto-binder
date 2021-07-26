import static org.assertj.core.api.Assertions.assertThat;

import classes.dto.SimpleObjectDto;
import classes.SimpleObject;
import dtobinder.DtoBinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DtoBinderSimpleTest {

    @DisplayName("Bind simple dto and Object.")
    @Test
    void bind_bindSimpleDtoAndObject_returnBoundDto() {
        SimpleObject simpleObject = new SimpleObject(
            1, 2, "string", true, true, 3L, 4L
        );
        SimpleObjectDto simpleObjectDto = new DtoBinder(simpleObject).bindAs(SimpleObjectDto.class);

        SimpleObjectDto expected = new SimpleObjectDto(
            1, 2, "string", true, true, 3L, 4L
        );

        assertThat(simpleObjectDto)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }
}
