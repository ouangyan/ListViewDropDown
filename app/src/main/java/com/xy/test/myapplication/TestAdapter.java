package com.xy.test.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 2019/11/6.
 */

public class TestAdapter extends BaseAdapter {
    private List<Map<String,Object>> dataSource=new ArrayList<>();
    private Activity activity;
    private int currentPage=0;

    public TestAdapter(Activity activity){
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView=this.activity.getLayoutInflater().inflate(R.layout.lv_item,null);

        Map<String,Object> mapTemp=this.dataSource.get(position);

        TextView tv_name=convertView.findViewById(R.id.tv_name);
        TextView tv_content=convertView.findViewById(R.id.tv_content);
        tv_name.setText(mapTemp.get(position+"").toString());
        return convertView;
    }

    public void loadData(){
        currentPage+=1;
        dataSource.addAll(TestDataSource.getDataByPage(currentPage));

        this.notifyDataSetChanged();
    }
}
