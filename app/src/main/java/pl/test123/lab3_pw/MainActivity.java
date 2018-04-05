package pl.test123.lab3_pw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int ACT = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Wcisnięto przycisk Settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Log_In:
                Toast.makeText(getApplicationContext(), "Wcisnięto przycisk Log_In", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.Aparat:
                Toast.makeText(getApplicationContext(), "Wcisnięto przycisk Item2", Toast.LENGTH_SHORT).show();
                Intent intent_img = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent_img,REQUEST_IMAGE_CAPTURE);
                break;

            case R.id.Item3:
                Toast.makeText(getApplicationContext(), "Wcisnięto przycisk Item3", Toast.LENGTH_SHORT).show();
                iconChange();
                break;

            case R.id.Item4:
                Toast.makeText(getApplicationContext(), "Wcisnięto przycisk Item4", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickBtn(View view){
        Toast.makeText(getApplicationContext(),"Wcisnięto przycisk Button", Toast.LENGTH_SHORT).show();

    }

    public void iconChange(){
        Random r = new Random();
        int rand = r.nextInt(4);
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        Bitmap imageBitmap = (Bitmap)bundle.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }
}
