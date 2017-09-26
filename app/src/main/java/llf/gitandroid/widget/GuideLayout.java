package llf.gitandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import llf.gitandroid.widget.guide.HighLight;

/**
 * Created by llf on 2017/9/26.
 * 引导布局
 */

public class GuideLayout extends FrameLayout {
    private Paint mPaint;
    private int mBackgroundColor = 0xb2000000;
    private HighLight mHighLight;

    public GuideLayout(Context context) {
        this(context, null);
    }

    public GuideLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GuideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        mPaint.setXfermode(porterDuffXfermode);

        setClickable(true);
        //ViewGroup默认设定为true，会使onDraw方法不执行，如果复写了onDraw(Canvas)方法，需要清除此标记
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(mBackgroundColor);
        RectF rectF = mHighLight.getRectF();
        switch (mHighLight.getType()){
            case CIRCLE:
                canvas.drawCircle(rectF.centerX(), rectF.centerY(), mHighLight.getRadius(), mPaint);
                break;
            case RECTANGLE:
                canvas.drawRect(rectF, mPaint);
                break;
            case OVAL:
                canvas.drawOval(rectF, mPaint);
                break;
            case ROUND_RECTANGLE:
                canvas.drawRoundRect(rectF, mHighLight.getRound(), mHighLight.getRound(), mPaint);
                break;
        }
        canvas.restoreToCount(saved);
    }

    public void setHighLight(HighLight highLight) {
        mHighLight = highLight;
    }
}
