package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.day01.R;

public class SplashActivity extends AppCompatActivity {
    private Button skip;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            toLoginActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();

        //延迟2秒
        handler.postDelayed(runnable, 2000);


    }

    /**
     * 初始化组件
     */
    private void initView() {
        skip = findViewById(R.id.skip);
    }

    /**
     * 监听事件
     */
    private void initData() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                toLoginActivity();
            }
        });
    }

    /**
     * 跳转到主页面
     */
    private void toLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 防止内存泄露
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}