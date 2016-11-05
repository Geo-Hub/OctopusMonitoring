package org.blueventures.octopusmonitoring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;

import io.fiskur.form.Form;
import io.fiskur.form.FormApi;
import io.fiskur.form.ImageLoader;


public class FormActivity extends AppCompatActivity {
  private static final String TAG = "FormActivity";
  private static final String EXTRA_FORM = "org.blueventures.octopusmonitoring.EXTRA_FORM";

  public static Intent createIntent(Context context, Form form){
    Intent intent = new Intent(context, FormActivity.class);
    if(form != null){
      intent.putExtra(EXTRA_FORM, form);
    }
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_form);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //noinspection ConstantConditions
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    LinearLayout root = (LinearLayout) findViewById(R.id.form_root);
    if(getIntent().hasExtra(EXTRA_FORM)) {
      Form form = (Form) getIntent().getSerializableExtra(EXTRA_FORM);
      FormApi.getInstance().setImageLoader(new ImageLoader() {
        @Override
        public void loadImage(ImageView imageView, String url) {
          Log.d(TAG, "loadImage: " + url);
          Picasso.with(FormActivity.this).load(url).into(imageView);
        }
      });
      FormApi.getInstance().buildViews(this, form, root);
      if(getSupportActionBar() != null) {
        getSupportActionBar().setTitle(form.title);
      }
    }else{
      //todo - error message
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    switch (id) {
      case android.R.id.home:
        new MaterialDialog.Builder(this)
          .title(R.string.warning)
          .content(R.string.dismiss_are_you_sure)
          .positiveText(R.string.ok)
          .negativeText(R.string.cancel)
          .onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              finish();
            }
          })
          .show();
        break;

    }

    return super.onOptionsItemSelected(item);
  }
}