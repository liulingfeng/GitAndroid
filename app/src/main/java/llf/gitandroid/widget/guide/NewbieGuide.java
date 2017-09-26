package llf.gitandroid.widget.guide;

import android.app.Activity;

/**
 * Created by llf on 2017/9/26.
 */

public class NewbieGuide {
    public static Builder with(Activity activity) {
        return new Builder(activity);
    }
}
