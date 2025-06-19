package com.mavis.test;

import com.mavis.entity.AlistConfig;
import com.mavis.util.AlistUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        AlistConfig alistConfig = new AlistConfig("http://localhost:5244","admin","admin");
        ArrayList<HashMap<String, String>> alistAllFilesInfo = AlistUtils.getAlistAllFilesInfo(alistConfig, "/files/DockerImage", "");
        for (HashMap<String, String> map : alistAllFilesInfo) {
            System.out.println(map);
        }
    }
}
