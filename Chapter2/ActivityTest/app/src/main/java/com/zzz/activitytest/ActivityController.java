package com.zzz.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }


    //不管想在什么地方退出程序，只要调用ActivityController.finishAll()即可
    public static void finishAll() {
        for (Activity activity :
                activities) {
            activity.finish();
        }
        activities.clear();
    }

}
