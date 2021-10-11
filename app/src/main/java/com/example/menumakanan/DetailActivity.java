package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mImageView;
    TextView mTextView;
    TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        mTextView = (TextView) findViewById(R.id.textView2);
        mTextView2 = (TextView) findViewById(R.id.textView3);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle(mBundle.getString("foodNames"));
            mImageView.setImageResource(mBundle.getInt("foodImages"));
            mTextView.setText(mBundle.getString("foodPrices"));
            mTextView2.setText(mBundle.getString("foodDetails"));
        }
    }
}