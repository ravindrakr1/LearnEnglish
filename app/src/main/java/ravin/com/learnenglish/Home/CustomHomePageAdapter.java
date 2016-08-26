package ravin.com.learnenglish.Home;

/**
 * Created by mayankg on 25/08/16.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import ravin.com.learnenglish.R;

public class CustomHomePageAdapter extends BaseAdapter {
    private Context context;
    private MainPageActivity mainActivity;
    private static LayoutInflater inflater=null;
    private ArrayList<GridViewInfo> gridInfo;

    // Constructor
    public CustomHomePageAdapter(MainPageActivity mainActivity, ArrayList<GridViewInfo> gridInfo) {
        this.context = mainActivity;
        this.gridInfo = gridInfo;
        this.mainActivity = mainActivity;
        inflater = ( LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return this.gridInfo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public class Holder
    {
        TextView itemType;
        TextView itemIcon;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.activity_home_list, null);
        holder.itemType = (TextView) rowView.findViewById(R.id.textView1);
        holder.itemType.setText(this.gridInfo.get(position).getTitile());
        holder.itemType.setGravity(Gravity.CENTER);

        holder.itemIcon = (TextView) rowView.findViewById(R.id.imageView1);
        holder.itemIcon.setText(this.gridInfo.get(position).getImageCode()); // setting text
        holder.itemIcon.setTypeface(mainActivity.fontAwesomeFont);


        rowView.setBackgroundColor(Color.parseColor("#85a4a0"));

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // on selection each grid
                Intent intent;
                switch (position) {

                    case 0:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.Conversation.ConversationActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(mainActivity,ravin.com.learnenglish.Quiz.QuizActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.Dictionary.DictionaryActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.Grammar.GrammarActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.DiscussionForum.DiscussionForumActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.DailyPhrases.DailyPhrasesActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(mainActivity, ravin.com.learnenglish.Pronunciation.PronunciationActivity.class);
                        mainActivity.startActivity(intent);
                        break;
                    default:
                        break;
                    
                }
            }
        });

        return rowView;
    }


}
