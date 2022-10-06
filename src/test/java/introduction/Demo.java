package introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
    @Test
    public void testIfNumber4IsEven4() {
        int actualImput = 5;
        int expectedResult = 0;
        int actualResult;
        actualResult = actualImput % 2;
        Assert.assertTrue(actualResult, expectedResult);
    }

}


