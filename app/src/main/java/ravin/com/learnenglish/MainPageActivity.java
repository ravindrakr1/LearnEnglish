package ravin.com.learnenglish;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;



public class MainPageActivity extends AppCompatActivity {

    GridView gridView;
    Context context;
    Typeface fontAwesomeFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        this.gridView =(GridView) findViewById(R.id.grid_View);
        this.gridView.setVerticalSpacing(5);
        this.gridView.setHorizontalSpacing(5);
        String [] NameList = {"Conversation","Quiz","Dictionary","Grammar","Discussion Forum","Daily Phrases","Pronunciation"}; // title Array
        String[]  ImagesList = {"\uf001","\uf002","\uf003","\uf004","\uf005","\uf006","\uf007"}; // BackGround image array
        this.gridView.setAdapter(new CustomHomePageAdapter(this, NameList, ImagesList));

    }
}
