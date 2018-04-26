package com.gmail.farasabiyyu12.italiabeautiful;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ScrollingActivity extends AppCompatActivity {

    TextView tvtentangitalia, judulinfo, deskripsiinfo;

    private SpannableString styledString = new SpannableString("Tentang Kami");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        //TODO Toolbar Method
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        //TODO GET INTENT
        Intent inama = getIntent();

        String snama = inama.getStringExtra("namas");

        //TODO deklarasi textview
        tvtentangitalia = findViewById(R.id.tvtentangitalia);
        judulinfo = findViewById(R.id.judulinfo);
        deskripsiinfo = findViewById(R.id.deskripsiinfo);

        //TODO "Negara Italia" / "Tentang" TextView Method
        if (snama.equals("Negara Italia")) {
            tvtentangitalia.setText(R.string.large_text);
            judulinfo.setText(R.string.judul);
            deskripsiinfo.setText(R.string.deskripsi_negara);
        }else if (snama.equals("Tentang")){
            styledString.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 7, 0);
            styledString.setSpan(new ForegroundColorSpan(Color.RED), 8, 12, 0);

            tvtentangitalia.setText(Html.fromHtml("<div style=\"text-align:center\"><b>Tentang Developer</b><div>"
            + "Aplikasi ini dibuat sepenuh hati oleh sang developer. Aplikasi ini dibuat oleh <b>Farras Abiyyu Handoko</b> dari SMK IDN" +
                    "        Madinatul Ilmi. Termasuk text yang sedang anda baca ini, ini adalah buatan sang developer. Tahukah anda, aplikasi ini jadi karena adanya target\n" +
                    "        35 aplikasi dalam ½ semester. 25 untuk android &amp; 10 untuk iOS."));
            judulinfo.setText(styledString);
            deskripsiinfo.setText(null);
        }


        //TODO FAB
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String status = tvtentangitalia.getText().toString();

                Intent share = new Intent(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_SUBJECT, R.id.judulinfo)
                        .putExtra(Intent.EXTRA_TEXT, status);
                startActivity(Intent.createChooser(share, "Share The Info"));
            }
        });

        //TODO Glide
        try {
            Glide.with(this).load(R.drawable.backgroundappbar).into((ImageView) findViewById(R.id.appback));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO Option Menu Operation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO Set Collapsing Toolbar
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
