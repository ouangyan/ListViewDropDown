package com.xy.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TestAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestDataSource.initDataSource();
        initAdapter();
        events();
    }

    private void initAdapter(){
        listView=findViewById(R.id.lv_list);
        adapter=new TestAdapter(this);
        listView.setAdapter(adapter);
        adapter.loadData();
    }

    public void events(){
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                Toast.makeText(MainActivity.this,"scrollState:"+scrollState,Toast.LENGTH_LONG).show();
                // 滚动停止时
                if(scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    // 判断在最后一行时加载
                    if(view.getLastVisiblePosition()==view.getCount()-1){
                        adapter.loadData();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                Toast.makeText(MainActivity.this,"当前滚动到了："+(visibleItemCount+firstVisibleItem),Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,"firstVisibleItem:"+firstVisibleItem+"<>visibleItemCount:"+visibleItemCount+"<>totalItemCount:"+totalItemCount,Toast.LENGTH_LONG).show();
            }
        });
    }
}
