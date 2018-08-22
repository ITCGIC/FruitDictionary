package gicitc.dictionary.fruit.fruitdictionary;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gicitc.dictionary.fruit.fruitdictionary.dummy.DummyContent;

public class DefinitionActivity extends AppCompatActivity implements DefinitionFragment.OnDefinitionInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.activity_definition);
        if(getIntent() != null && getIntent().hasExtra("selected_fruit")) {
            DummyContent.DummyItem item = getIntent().getParcelableExtra("selected_fruit");
            DefinitionFragment fragment = (DefinitionFragment) getSupportFragmentManager().findFragmentById(R.id.f_definition);
            fragment.updateDefinition(item);
        }
    }

    @Override
    public void onDefinitionInteraction(Uri uri) {
        // Do nothing
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) finish();
    }
}
