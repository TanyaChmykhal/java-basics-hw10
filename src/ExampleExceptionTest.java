import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
            {8, 2, 16},
            {20, 10, 200}
    };
  }

  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
            {-3, -3},
            {1, -2}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
assertEquals(ExampleException.rectangleArea(a, b), c);
  }

  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a,b);
    }
    catch (IllegalArgumentException d)
    {
      assertEquals(d.getMessage(), "input value is below zero!");
    }
  }
}