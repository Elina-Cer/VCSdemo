package introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Classwork {

    @Test
    public void testIfNumber995DividesWith3WithoutReminder() {

        int input = 995;
        int expectedReminder = 0;

        int actualReminder = input % 3;

        Assert.assertEquals(actualReminder, expectedReminder);
    }

    @Test
    public void testIfTodayIsWednesday() {

        DayOfWeek expectedDayOfWeek = DayOfWeek.WEDNESDAY;
        DayOfWeek actualDayOfWeek = LocalDateTime.now().getDayOfWeek();

        Assert.assertEquals(actualDayOfWeek, expectedDayOfWeek);
    }

    @Test
    public void testWaitFor5Seconds() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCountOfEvenNumbersBetween1And10() {

        int expectedEvenNumberCount = 4;
        int actualEvenNumberCount = 0;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                actualEvenNumberCount++;
            }
        }

        Assert.assertEquals(actualEvenNumberCount, expectedEvenNumberCount);
    }


}
