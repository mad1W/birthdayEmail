package com.madong.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtUtil {
    public static List<String> readTxt(File file) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader br = new BufferedReader(in);
        List<String> content = new ArrayList<>();
        while ((s=br.readLine())!=null){
            content.add(s);
        }
        return content;
    }
}
