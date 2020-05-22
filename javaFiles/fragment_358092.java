package com.so.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class Sof {
    public static void main(String[] args) throws IOException {
        List<File> files = getDirs(new File("path to root folder"), 0); //level 0 is inside parent , level 1, and so on
        System.out.println(files);
        String[] paths = new String[files.size()];

        int i = 0;
        for (File file : files) {
            paths[i++] = file.getAbsolutePath();
        }
        String matchword = "Folder1";

        //File  f = null;
        HashMap<String, String > old_new = new HashMap<>();
        for (int j = 0; j < paths.length; j++) {
            System.out.println(paths[j]);
            String old_path = paths[j];
            String foldername = new File(paths[j]).getName();
            //02_PA__OPCON.MES.GC.Configuration 
            //02_Configuration

            if(old_path.contains(matchword)){
                paths[j] =paths[j].replaceAll(matchword, "Directory");

                old_new.put(old_path, paths[j]);

            }else{
                System.out.println("skipping->"+old_path);
            }
            //f = new File(paths[j]);
            //f.mkdirs();
        }

        for(String key : old_new.keySet()){
            FileUtils.copyDirectory(new File(key), new File(old_new.get(key)));
        }

        //FileUtils.copyDirectory(new File(old_new.get), new File(arg0));
     }

     static List<File> getDirs(File parent, int level){
        List<File> dirs = new ArrayList<File>(); //to store 
        for(File f: parent.listFiles()){
            if(f.isDirectory()) {
                if (level==0) dirs.add(f);
                else 
                    if (level > 0) dirs.addAll(getDirs(f,level-1)); //recursion
            }
        }
        return dirs;
    }
}