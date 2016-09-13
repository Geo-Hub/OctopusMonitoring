package org.blueventures.octopusmonitoring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import io.fiskur.form.Form;
import io.fiskur.form.FormApi;


public class FormActivity extends AppCompatActivity {

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

    LinearLayout root = (LinearLayout) findViewById(R.id.form_root);
    if(getIntent().hasExtra(EXTRA_FORM)) {
      Form form = (Form) getIntent().getSerializableExtra(EXTRA_FORM);
      FormApi.getInstance().buildViews(this, form, root);
      if(getSupportActionBar() != null) {
        getSupportActionBar().setTitle(form.title);
      }
    }else{
      //todo - error message
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_form, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}