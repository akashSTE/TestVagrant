package Core;

import static Core.GlobalData.VARIANCE;

public class Comparator {

    public int convertKelvinInCelsius(int tempInKelvin) {
        int tempInCelsius = (tempInKelvin - 273);
        return tempInCelsius;
    }

    public boolean compareTemp(int temp1, int temp2) {
        boolean flag;
        int diff;
        if (temp1 > temp2) {
            diff = (temp1 - temp2);
            if (diff <= VARIANCE) {
                flag = true;
            } else {
                flag = false;
            }
        } else if (temp2 > temp1) {
            diff = (temp2 - temp1);
            if (diff <= VARIANCE) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = true;
        }
        return flag;
    }

}
