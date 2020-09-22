import Core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Core.GlobalData.*;

public class Phase3 extends BaseTest {

    @Test(priority = 1)
    public void compareUIAndAPITemp() {
        System.out.println("tempFromAPI in Kelvin:################ "+tempFromAPI);
        tempFromAPI = comparator.convertKelvinInCelsius(tempFromAPI);
        boolean flag = comparator.compareTemp(tempFromUI,tempFromAPI);
        System.out.println("Flag Value:################ "+flag);
        System.out.println("tempFromUI:################ "+tempFromUI);
        System.out.println("tempFromAPI:################ "+tempFromAPI);
        Assert.assertTrue(flag);
    }

}
