package cehs0703.seo.travel;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    Button sub;
    ImageView imageView;
    Animation frombottom;
    Animation fromtop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(Color.parseColor("#9DC8C8"));
        }

        sub=(Button)findViewById(R.id.spalsh_btn);
        imageView=(ImageView)findViewById(R.id.spalsh_top);



        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop=AnimationUtils.loadAnimation(this,R.anim.fromtop);

        sub.setAnimation(frombottom);
        imageView.setAnimation(fromtop);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(splash.this,MainActivity.class);
                startActivity(i);
                splash.this.finish();
            }
        });

    }


}
