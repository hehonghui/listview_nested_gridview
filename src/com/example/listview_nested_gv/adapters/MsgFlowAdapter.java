/**
 *
 *	created by Mr.Simple, Sep 1, 20142:23:04 PM.
 *	Copyright (c) 2014, hehonghui@umeng.com All Rights Reserved.
 *
 *                #####################################################
 *                #                                                   #
 *                #                       _oo0oo_                     #   
 *                #                      o8888888o                    #
 *                #                      88" . "88                    #
 *                #                      (| -_- |)                    #
 *                #                      0\  =  /0                    #   
 *                #                    ___/`---'\___                  #
 *                #                  .' \\|     |# '.                 #
 *                #                 / \\|||  :  |||# \                #
 *                #                / _||||| -:- |||||- \              #
 *                #               |   | \\\  -  #/ |   |              #
 *                #               | \_|  ''\---/''  |_/ |             #
 *                #               \  .-\__  '-'  ___/-. /             #
 *                #             ___'. .'  /--.--\  `. .'___           #
 *                #          ."" '<  `.___\_<|>_/___.' >' "".         #
 *                #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 *                #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 *                #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 *                #                       `=---='                     #
 *                #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 *                #                                                   #
 *                #               佛祖保佑         永无BUG              #
 *                #                                                   #
 *                #####################################################
 */

package com.example.listview_nested_gv.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview_nested_gv.R;
import com.example.listview_nested_gv.beans.ListViewItem;
import com.example.listview_nested_gv.utils.GridViewUtils;
import com.example.listview_nested_gv.widgets.MGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrsimple
 */
public class MsgFlowAdapter extends BaseAdapter {

    List<ListViewItem> mImages = new ArrayList<ListViewItem>();
    LayoutInflater mInflater;
    Context mContext;

    public MsgFlowAdapter(Context context, List<ListViewItem> items) {
        mContext = context;
        mImages = items;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public ListViewItem getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mGridView = (MGridView) convertView.findViewById(R.id.my_gridview);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.my_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ListViewItem item = getItem(position);
        // 设置GridView的Adapter
        viewHolder.mGridView.setAdapter(new GridViewAdapter(mContext, item.mImages));
        // 计算GridView宽度, 设置默认为numColumns为3.
        GridViewUtils.updateGridViewLayoutParams(viewHolder.mGridView, 3);
        viewHolder.mTextView.setText(item.mText);
        return convertView;
    }

    /**
     * @author mrsimple
     */
    static class ViewHolder {
        MGridView mGridView;
        TextView mTextView;
    }

}
