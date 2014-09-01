/**
 *
 *	created by Mr.Simple, Sep 1, 20142:17:05 PM.
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
import android.widget.ImageView;

import com.example.listview_nested_gv.R;

import java.util.List;

/**
 * @author mrsimple
 */
public class GridViewAdapter extends BaseAdapter {

    Context mContext;
    List<Integer> mImages;

    public GridViewAdapter(Context context, List<Integer> images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Integer getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item,
                parent, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.my_img);
        imageView.setImageResource(getItem(position));
        return rootView;
    }

}
