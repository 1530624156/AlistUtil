package com.mavis.test;

import com.mavis.entity.AlistConfig;
import com.mavis.util.AlistUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        AlistConfig alistConfig = new AlistConfig("http://mavis01.top:15244","admin","gyx1129@");
        ArrayList<HashMap<String, String>> alistAllFilesInfo = AlistUtils.getAlistAllFilesInfo(alistConfig, "/files/DockerImage", "");
        for (HashMap<String, String> map : alistAllFilesInfo) {
            System.out.println(map);
        }


    }
}
