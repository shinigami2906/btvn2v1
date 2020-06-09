package vn.daikon.myapplication.repository;



import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

import vn.daikon.myapplication.model.Picture;

public class PictureRepo {

    FileReader inp;
    FileWriter out;
    public PictureRepo(FileReader inp,FileWriter out) {
        this.inp = inp;
        this.out = out;
    }
    public void write(String pictureID, String name, String age){
        Picture picture = new Picture(pictureID,name,age);

    }

}
