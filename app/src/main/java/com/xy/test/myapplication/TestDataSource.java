package com.xy.test.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Ouyang on 2019/11/8.
 */

public class TestDataSource {
    private static List<Map<String,Object>> dataSource=new ArrayList<>();
    private static int size=20;

    public static void initDataSource(){
        for(int i=0;i<400;i++){
            Map<String,Object> mapTemp=new HashMap<>();
            String name= UUID.randomUUID().toString()+"<>"+i;
            mapTemp.put(String.valueOf(i),name);
            dataSource.add(mapTemp);
        }
    }

    public static List<Map<String,Object>> getDataByPage(int page){
        if(page==0)
            page=1;
        if(dataSource.size()<=0)
            return null;
        if(page*size-size>dataSource.size())
            return null;

        List<Map<String,Object>> listTemp=new ArrayList<>();
        int total=page*size;
        for(int i=total-size;i<total;i++){
            Map<String,Object> mapTemp=dataSource.get(i);
            if(mapTemp!=null)
                listTemp.add(mapTemp);
            else
                break;
        }
        return listTemp;
    }
}
