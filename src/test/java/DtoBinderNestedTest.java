import static org.assertj.core.api.Assertions.assertThat;

import classes.NestedObject;
import classes.SimpleAge;
import classes.SimpleName;
import classes.TwiceNestedObject;
import classes.TwiceNestedObject.InnerClass1;
import classes.TwiceNestedObject.InnerClass1Dto;
import classes.TwiceNestedObject.InnerClass2;
import classes.TwiceNestedObject.InnerClass2Dto;
import classes.TwiceNestedObject.TwiceNestedObjectDto;
import classes.dto.NestedObjectDto;
import classes.dto.SimpleAgeDto;
import classes.dto.SimpleNameDto;
import dtobinder.DtoBinder;
import org.junit.jupiter.api.Test;

public class DtoBinderNestedTest {

    @Test
    void bindAs_nestedOnce() {
        NestedObject nestedObject = new NestedObject(
            "bperhaps", 29, new SimpleName("bperhaps2"), new SimpleAge(30)
        );

        NestedObjectDto nestedObjectDto = new DtoBinder(nestedObject)
            .toDto("simpleName", SimpleNameDto.class)
            .toDto("simpleAge", SimpleAgeDto.class)
            .bindAs(NestedObjectDto.class);

        NestedObjectDto expected = new NestedObjectDto(
            "bperhaps", 29, new SimpleNameDto("bperhaps2"), new SimpleAgeDto(30)
        );

        assertThat(nestedObjectDto)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }

    @Test
    void bindAs_nestedTwice() {
        TwiceNestedObject nestedObject = new TwiceNestedObject(
            new InnerClass1(
                new InnerClass2("testName")
            )
        );

        TwiceNestedObjectDto nestedObjectDto = new DtoBinder(nestedObject)
            .toDto("innerClass1", InnerClass1Dto.class)
            .toDto("innerClass1.innerClass2", InnerClass2Dto.class)
            .bindAs(TwiceNestedObjectDto.class);

        TwiceNestedObjectDto expected = new TwiceNestedObjectDto(
            new InnerClass1Dto(
                new InnerClass2Dto("testName")
            )
        );

        assertThat(nestedObjectDto)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }
}
