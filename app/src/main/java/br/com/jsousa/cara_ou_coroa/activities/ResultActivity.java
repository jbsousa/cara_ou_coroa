package br.com.jsousa.cara_ou_coroa.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.com.jsousa.cara_ou_coroa.R;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageResult;
    private Button buttonBack;

    private final int[] imagesCoins = {R.drawable.cara, R.drawable.coroa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageResult     =   findViewById(R.id.imageViewResult);
        buttonBack      =   findViewById(R.id.buttonBack);

        Toast.makeText(
                getApplicationContext(),
                "Toque na moeda",
                Toast.LENGTH_SHORT
                ).show();

        buttonBack.setOnClickListener(view -> onBackPressed());
    }

    public void flipCoin(View view) {

        int i = new Random().nextInt(2);

        imageResult.animate()
                .rotationYBy(-270)
                .setDuration(250)
                .setInterpolator(new AccelerateInterpolator())
                .scaleX(1.5f)
                .scaleY(1.5f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        imageResult.setRotationY(90);
                        imageResult.setImageResource(imagesCoins[i]);
                        imageResult.animate()
                                .rotationY(0)
                                .setDuration(125)
                                .scaleX(1f)
                                .scaleY(1f)
                                .setInterpolator(new DecelerateInterpolator())
                                .setListener(null)
                                .start();
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                }).start();
    }

}