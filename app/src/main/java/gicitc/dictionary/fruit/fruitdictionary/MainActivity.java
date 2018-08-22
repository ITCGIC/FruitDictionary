package gicitc.dictionary.fruit.fruitdictionary;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import gicitc.dictionary.fruit.fruitdictionary.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
implements FruitFragment.OnListFragmentInteractionListener, DefinitionFragment.OnDefinitionInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DefinitionActivity.class);
            intent.putExtra("selected_fruit", item);
            startActivity(intent);
        }else{
            DefinitionFragment fragment = (DefinitionFragment) getSupportFragmentManager().findFragmentById(R.id.f_definition);
            fragment.updateDefinition(item);
        }
    }

    @Override
    public void onDefinitionInteraction(Uri uri) {
        //do nothing
    }
}
