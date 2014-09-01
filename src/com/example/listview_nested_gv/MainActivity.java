
package com.example.listview_nested_gv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview_nested_gv.adapters.MsgFlowAdapter;
import com.example.listview_nested_gv.beans.ListViewItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MsgFlowFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * 消息流模拟界面
     */
    public static class MsgFlowFragment extends Fragment {

        ListView mListView;

        public MsgFlowFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mListView = (ListView) rootView.findViewById(R.id.my_listview);
            // 设置Adapter
            mListView.setAdapter(new MsgFlowAdapter(getActivity(), mockData()));
            // 点击事件
            mListView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), "listview position = " + position,
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });
            return rootView;
        } // end of

        /**
         * 模拟一些数据
         * 
         * @return
         */
        private List<ListViewItem> mockData() {
            List<ListViewItem> items = new ArrayList<ListViewItem>();
            ListViewItem item = new ListViewItem();
            item.mText = "这里是文本内容, 新浪微博有点卡";
            item.mImages.add(R.drawable.umeng_community_qq);
            item.mImages.add(R.drawable.umeng_community_wechat);
            item.mImages.add(R.drawable.umeng_community_sina);
            item.mImages.add(R.drawable.umeng_community_qq);
            item.mImages.add(R.drawable.umeng_community_qq);
            item.mImages.add(R.drawable.umeng_community_sina);
            item.mImages.add(R.drawable.umeng_community_qq);
            items.add(item);

            item = new ListViewItem();
            item.mText = "今天天气还不错啊";
            item.mImages.add(R.drawable.umeng_community_qq);
            items.add(item);

            item = new ListViewItem();
            item.mText = "消息流页面";
            item.mImages.add(R.drawable.umeng_community_qq);
            item.mImages.add(R.drawable.umeng_community_qq);
            items.add(item);
            return items;
        }
    }

}
