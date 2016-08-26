package ravin.com.learnenglish.Home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import ravin.com.learnenglish.R;



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
        this.gridView.setAdapter(new ravin.com.learnenglish.Home.CustomHomePageAdapter(this, getGridViewInfo()));
    }

    protected ArrayList<GridViewInfo> getGridViewInfo(){
        ArrayList<GridViewInfo> gridInfo = new ArrayList<GridViewInfo>();
        final String [] nameList = {"Conversation","Quiz","Dictionary","Grammar","Discussion Forum","Daily Phrases","Pronunciation"}; // title Array
        final String[]  imagesList = {"\uf001","\uf002","\uf003","\uf004","\uf005","\uf006","\uf007"}; // BackGround image array
        final Integer gridCount = nameList.length;
        for (Integer i = 0; i < gridCount; ++i ){
            GridViewInfo grid = new GridViewInfo(nameList[i],imagesList[i]);
            gridInfo.add(i,grid);

        }
        return gridInfo;
    }
}
