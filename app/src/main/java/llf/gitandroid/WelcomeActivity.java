package llf.gitandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import llf.gitandroid.base.BaseActivity;
import llf.gitandroid.widget.guide.NewbieGuide;

/**
 * Created by llf on 2017/9/26.
 * 欢迎页，其实就是引导页
 */

public class WelcomeActivity extends BaseActivity {
    @Bind(R.id.btn_click)
    Button mBtnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        NewbieGuide.with(WelcomeActivity.this)
                .addHighLight(mBtnClick)
                .setLayoutRes(R.layout.view_guide)
                .show();
    }
}
