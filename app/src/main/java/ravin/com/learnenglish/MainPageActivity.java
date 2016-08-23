package ravin.com.learnenglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
               if(position==0){
                   Intent intent = new Intent(MainPageActivity.this,ConversationActivity.class);
                   startActivity(intent);

               }
                else if (position == 1){
                   Intent intent = new Intent(MainPageActivity.this,QuizActivity.class);
                   startActivity(intent);

               }
                else if (position == 2){
                   Intent intent = new Intent(MainPageActivity.this,DictionaryActivity.class);
                   startActivity(intent);

               }
                else if (position == 3){
                   Intent intent = new Intent(MainPageActivity.this,GrammarActivity.class);
                   startActivity(intent);

               }
                else if(position == 4){
                   Intent intent = new Intent(MainPageActivity.this,DiscussionForumActivity.class);
                   startActivity(intent);

               }
                else if(position == 5){
                   Intent intent = new Intent(MainPageActivity.this,DailyPhrasesActivity.class);
                   startActivity(intent);

               }
                else if (position == 6){
                   Intent intent = new Intent(MainPageActivity.this,PronunciationActivity.class);
                   startActivity(intent);

               }
            }
        });


    }
}
