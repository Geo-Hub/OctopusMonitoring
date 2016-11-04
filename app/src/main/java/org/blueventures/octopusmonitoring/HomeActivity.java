package org.blueventures.octopusmonitoring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.fiskur.form.Form;
import io.fiskur.form.FormApi;
import io.fiskur.form.creator.CreatorActivity;

public class HomeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Button creatorButton = (Button) findViewById(R.id.creator_button);
    creatorButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(HomeActivity.this, CreatorActivity.class));
      }
    });

    Button demoButton = (Button) findViewById(R.id.demo_button);
    demoButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Form form = FormApi.getInstance().createForm(readRawTextFile(HomeActivity.this, R.raw.demo_form));
        Intent formIntent = FormActivity.createIntent(HomeActivity.this, form);
        startActivity(formIntent);
      }
    });
  }

  public String readRawTextFile(Context ctx, int resId) {
    InputStream inputStream = ctx.getResources().openRawResource(resId);

    InputStreamReader inputreader = new InputStreamReader(inputStream);
    BufferedReader buffreader = new BufferedReader(inputreader);
    String line;
    StringBuilder text = new StringBuilder();

    try {
      while (( line = buffreader.readLine()) != null) {
        text.append(line);
        text.append('\n');
      }
    } catch (IOException e) {
      return null;
    }
    return text.toString();
  }

  private static final String TEST_JSON = "{\n" +
    "  \"title\": \"Octopus Monitoring\",\n" +
    "  \"date\": \"05092016\",\n" +
    "  \"time\": \"10:49\",\n" +
    "  \"author\": \"Jonathan Fisher\",\n" +
    "  \"contact\": \"jonathan@fiskur.eu\",\n" +
    "  \"fields\": [\n" +
    "      {\n" +
    "      \"id\": \"AGE1\",\n" +
    "      \"type\": \"SINGLE_CHOICE\",\n" +
    "      \"text\": \"Are you over 18?\",\n" +
    "      \"choices\": [\n" +
    "        {\n" +
    "          \"id\": \"AGEA\",\n" +
    "          \"text\": \"Under 18\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"AGEB\",\n" +
    "          \"text\": \"Over 18\"\n" +
    "        }\n" +
    "      ],\n" +
    "      \"subfields\": [\n" +
    "        {\n" +
    "          \"id\": \"AGEAS\",\n" +
    "          \"text\": \"Did you ever drink alcohol when you were under 18?\",\n" +
    "          \"parent\": \"AGEA\",\n" +
    "          \"type\": \"FREE_TEXT\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"AGEBA\",\n" +
    "          \"text\": \"Have you ever drunk alcohol?\",\n" +
    "          \"parent\": \"AGEB\",\n" +
    "          \"type\": \"FREE_TEXT\"\n" +
    "        }\n" +
    "      ]\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"D1\",\n" +
    "      \"type\": \"CURRENT_DATE\",\n" +
    "      \"text\": \"Today's Date\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"D1\",\n" +
    "      \"type\": \"DIVIDER\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"DOB\",\n" +
    "      \"type\": \"DATE\",\n" +
    "      \"text\": \"Date of Birth\"\n" +
    "    }, \n" +
    "    {\n" +
    "      \"id\": \"WAKE1\",\n" +
    "      \"type\": \"TIME\",\n" +
    "      \"text\": \"What time did you wake up?\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"S2\",\n" +
    "      \"type\": \"STATIC_TEXT\",\n" +
    "      \"title\": \"Static Title\",\n" +
    "      \"subtitle\": \"Static Subtitle\",\n" +
    "      \"text\": \"Hello World\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"Q3\",\n" +
    "      \"type\": \"FREE_TEXT\",\n" +
    "      \"text\": \"Describe the public transport you used\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"GENDER1\",\n" +
    "      \"type\": \"SINGLE_CHOICE\",\n" +
    "      \"text\": \"What gender do you identify with?\",\n" +
    "      \"choices\": [\n" +
    "        {\n" +
    "          \"id\": \"GENA\",\n" +
    "          \"text\": \"female\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENB\",\n" +
    "          \"text\": \"male\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENC\",\n" +
    "          \"text\": \"unspecified\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GEND\",\n" +
    "          \"text\": \"intersex\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENE\",\n" +
    "          \"text\": \"prefer not to say\"\n" +
    "        }\n" +
    "      ]\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"MUSIC1\",\n" +
    "      \"type\": \"MULTI_CHOICE\",\n" +
    "      \"text\": \"Which music genres do you enjoy?\",\n" +
    "      \"choices\": [\n" +
    "        {\n" +
    "          \"id\": \"GENA\",\n" +
    "          \"text\": \"Avant-Garde\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENB\",\n" +
    "          \"text\": \"Baroque\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENC\",\n" +
    "          \"text\": \"Chamber Music\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GEND\",\n" +
    "          \"text\": \"Choral\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENE\",\n" +
    "          \"text\": \"Classical Crossover\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENF\",\n" +
    "          \"text\": \"Minimalism\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENG\",\n" +
    "          \"text\": \"Modern Composition\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENH\",\n" +
    "          \"text\": \"Opera\"\n" +
    "        },\n" +
    "        {\n" +
    "          \"id\": \"GENI\",\n" +
    "          \"text\": \"Romantic\"\n" +
    "        }\n" +
    "      ]\n" +
    "    }\n" +
    "  ]\n" +
    "}";

}
