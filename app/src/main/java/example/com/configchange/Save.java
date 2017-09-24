package example.com.configchange;

import android.app.Application;

/**
 * Created by Gul on 9/24/2017.
 */

public class Save extends Application{
    private int i =0;
    public int ap(){
        return i++;
    }
}
