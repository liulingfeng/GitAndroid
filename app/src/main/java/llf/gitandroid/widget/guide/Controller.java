package llf.gitandroid.widget.guide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import llf.gitandroid.tools.ScreenUtil;
import llf.gitandroid.widget.GuideLayout;

/**
 * Created by llf on 2017/9/26.
 */

public class Controller {
    private Activity activity;
    private HighLight mHighLight;
    private int backgroundColor;
    private OnGuideChangedListener onGuideChangedListener;
    private int layoutResId;
    private int[] viewIds;
    private FrameLayout mParentView;
    private GuideLayout guideLayout;

    public Controller(Builder builder) {
        this.activity = builder.getActivity();
        this.mHighLight = builder.getHighLight();
        this.backgroundColor = builder.getBackgroundColor();
        this.onGuideChangedListener = builder.getOnGuideChangedListener();
        this.layoutResId = builder.getLayoutResId();
        this.viewIds = builder.getViewIds();

        mParentView = (FrameLayout) activity.getWindow().getDecorView();
    }

    public void show() {
        guideLayout = new GuideLayout(activity);
        guideLayout.setHighLight(mHighLight);
        if (backgroundColor != 0)
            guideLayout.setBackgroundColor(backgroundColor);

        if (layoutResId != 0) {
            View view = LayoutInflater.from(activity).inflate(layoutResId, guideLayout, false);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.topMargin = ScreenUtil.getStatusBarHeight(activity);
            params.bottomMargin = ScreenUtil.getNavigationBarHeight(activity);
            if (viewIds != null) {
                for (int viewId : viewIds) {
                    view.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            remove();
                        }
                    });
                }
            }
            guideLayout.addView(view, params);
        }

        mParentView.addView(guideLayout, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        guideLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                remove();
                return true;
            }
        });
        if (onGuideChangedListener != null) onGuideChangedListener.onShowed(this);
    }

    public void remove() {
        if (guideLayout != null && guideLayout.getParent() != null) {
            ((ViewGroup) guideLayout.getParent()).removeView(guideLayout);
            if (onGuideChangedListener != null) onGuideChangedListener.onRemoved(this);
        }
    }

}
