package llf.gitandroid.widget.guide;

import android.app.Activity;
import android.view.View;

/**
 * Created by llf on 2017/9/26.
 */

public class Builder {
    private Activity mActivity;
    private int backgroundColor;
    private OnGuideChangedListener onGuideChangedListener;
    private int layoutResId;
    private int[] viewIds;
    private HighLight mHighLight;

    public Builder(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 添加需要高亮的view,默认高亮类型为矩形
     */
    public Builder addHighLight(View view) {
        return addHighLight(view, HighLight.Type.RECTANGLE, 0);
    }

    /**
     * 添加需要高亮的view
     *
     * @param view 需要高亮的view
     * @param type 高亮类型：圆形，椭圆，矩形，圆角矩形
     * @return builder
     */
    public Builder addHighLight(View view, HighLight.Type type) {
        return addHighLight(view, type, 0);
    }

    /**
     * 添加需要高亮的view
     *
     * @param view  需要高亮的view
     * @param type  高亮类型：圆形，椭圆，矩形，圆角矩形
     * @param round 圆角尺寸，单位dp
     * @return builder
     */
    public Builder addHighLight(View view, HighLight.Type type, int round) {
        HighLight highLight = new HighLight(view, type);
        if (round > 0) {
            highLight.setRound(round);
        }
        this.mHighLight = highLight;
        return this;
    }

    /**
     * 引导层背景色
     */
    public Builder setBackgroundColor(int color) {
        backgroundColor = color;
        return this;
    }

    /**
     * 设置引导层隐藏，显示监听
     */
    public Builder setOnGuideChangedListener(OnGuideChangedListener listener) {
        onGuideChangedListener = listener;
        return this;
    }

    /**
     * 设置引导层控件布局
     *
     * @param resId 布局 id
     * @param id    需要设置点击隐藏引导层的view id
     * @return builder
     */
    public Builder setLayoutRes(int resId, int... id) {
        this.layoutResId = resId;
        viewIds = id;
        return this;
    }

    /**
     * 构建引导层controller并直接显示引导层
     *
     * @return controller
     */
    public Controller show() {
        Controller controller = new Controller(this);
        controller.show();
        return controller;
    }

    Activity getActivity() {
        return mActivity;
    }

    HighLight getHighLight() {
        return mHighLight;
    }

    OnGuideChangedListener getOnGuideChangedListener() {
        return onGuideChangedListener;
    }

    int getBackgroundColor() {
        return backgroundColor;
    }

    int getLayoutResId() {
        return layoutResId;
    }

    int[] getViewIds()

    {
        return viewIds;
    }
}
