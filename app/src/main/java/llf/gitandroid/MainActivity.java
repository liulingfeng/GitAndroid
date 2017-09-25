package llf.gitandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_mall, R.id.btn_topic, R.id.btn_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mall:
                break;
            case R.id.btn_topic:
                break;
            case R.id.btn_mine:
                break;
        }
    }
}
