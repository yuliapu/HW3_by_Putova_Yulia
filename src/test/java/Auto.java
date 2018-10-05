package com.example.tests;


import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)

public class Auto {
   private static WebDriver driver;
  static com.example.tests.Calc calc = new com.example.tests.Calc(driver);

  @Parameterized.Parameter
  public String exp;
  @Parameterized.Parameter(1)
  public String expected;

  @BeforeClass
  public static void openPage() {
    calc.setUp();
  }

  @org.junit.Test
  public void displaytest() throws Exception {

      assertEquals(expected, calc.display(exp));

  }
  @Parameterized.Parameters (name="Test: {0}={1}")
  public static Collection<Object[]> data() {
     return Arrays.asList(new Object[][] {
            { "1", "1" },
            { "2", "2" },
            { "3", "3" },
            { "4", "4" },
            { "5", "5" },
            { "6", "6" },
            { "7", "7" },
            { "8", "8" },
            { "9", "9" },
            { "0", "0" },

            { "1/0", "Infinity" },

            { "0.999999999999999+1", "1.999999999999999" },
            { "0.99999999999999999+1", "1.99999999999999999" },
            { "0.999999999999999999+1", "1.999999999999999999" },

            { "0.000000000000001+1", "1.000000000000001" },
            { "0.0000000000000001+1", "1.0000000000000001" },
            { "0.00000000000000001+1", "1.00000000000000001" },

            { "+1", "1" },
            { "1+", "1" },
            { "1", "1" },
            { "", "" },

            { "qweyqtrye", "qweyqtrye" },
            { "!@#$%^&", "!@#$%^&" },
            { "Infinity*0", "0" },
            { "        ", "" }
    });
  }
  /* Object[][] data=new Object[22][2];
    for (int i=0;i<10;i++)
    {
     data[i][0]= Integer.toString(i);
data[i][1]= Integer.toString(i);
    }
   data[10][0]="1/0";  data[10][1]="Infinity";


    data[11][0]="0.999999999999999+1";  data[11][1]="1.999999999999999";
    data[12][0]="0.99999999999999999+1";  data[12][1]="1.99999999999999999";
    data[13][0]="0.999999999999999999+1";  data[13][1]="1.999999999999999999";

    data[14][0]="0.000000000000001+1";  data[14][1]="1.000000000000001";
    data[15][0]="0.0000000000000001+1";  data[15][1]="1.0000000000000001";
    data[16][0]="0.00000000000000001+1";  data[16][1]="1.00000000000000001";

    data[17][0]="+1";  data[17][1]="1";
    data[18][0]="1+";  data[18][1]="1";
    data[19][0]="1";  data[19][1]="1";
    //data[20][0]="";  data[20][1]="";

    data[20][0]="qweyqtrye";  data[20][1]="qweyqtrye";
    data[21][0]="!@#$%^&";  data[21][1]="!@#$%^&";
    //data[0][0]="         ";  data[0][1]="";

    return Arrays.asList(data);
  }
*/

  @AfterClass
  public static void stop() throws Exception {
   calc.quit();

  }
}